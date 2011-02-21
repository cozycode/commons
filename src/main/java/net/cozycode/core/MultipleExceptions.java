/*
 * Copyright (C) 2011 Cozycode.net
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.cozycode.core;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * When an action causes multiple independent exceptions which need to be
 * reported as a single exception then this exception can be used to 
 * aggregate them together.
 * 
 * @author Pete Poulos
 */
public class MultipleExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final Throwable[] causes;

	public MultipleExceptions( String message, List<? extends Throwable> causes ) {
		super( message );
		this.causes = causes.toArray( new Throwable[causes.size()]);
	}
	
	public MultipleExceptions( String message, Throwable... causes ) {
		super( message );
		this.causes = causes;
	}
	
	public Throwable[] getCauses() {
		return causes;
	}

	@Override
	public void printStackTrace(PrintStream s) {
        synchronized (s) {
        	super.printStackTrace( s );
        	
        	StackTraceElement[] ourTrace = getStackTrace();
        	for( int i = 0; i < causes.length; ++i ) {
        		printStackTraceAs( causes[i], s, ourTrace, "Root Cause["+ i +"]" );
        	}
        }
	}

	@Override
	public void printStackTrace(PrintWriter s) {
        synchronized (s) {
        	super.printStackTrace( s );
        	
        	StackTraceElement[] ourTrace = getStackTrace();
        	for( int i = 0; i < causes.length; ++i ) {
        		printStackTraceAs( causes[i], s, ourTrace, "Root Cause["+ i +"]" );
        	}
        }
	}
	
	protected static void printStackTraceAs( Throwable cause, Object out, StackTraceElement[] causedTrace, String message ) {
		StackTraceElement[] trace = cause.getStackTrace();
		int framesInCommon = countFramesInCommon( trace, causedTrace );
		int uniqueFrames = trace.length - framesInCommon;
		
		println( out, message +": "+ cause );
		
		// Print unique frames
		for( int i = 0; i < uniqueFrames; ++i ) {
        	println( out, "\tat "+ trace[i] );
        }
        
		// Print number of frames in common
        if( framesInCommon > 0 ) {
            println( out, "\t... "+ framesInCommon +" more" );
        }

        // Print cause of the cause
        Throwable causeOfRoot = cause.getCause();
        if( causeOfRoot != null ){
        	printStackTraceAs( causeOfRoot, out, trace, "Caused by" );
        }
	}
	
	protected static int countFramesInCommon( StackTraceElement[] lhs, StackTraceElement[] rhs ) {
		int l = lhs.length - 1;
		int r = rhs.length - 1;
		
		while( l >= 0 && r >= 0 && lhs[l].equals( rhs[r]) ) {
			--l;
			--r;
		}
		
        return lhs.length - l;
	}
	
	
	protected static void println( Object printStreamOrWriter, String message ) {
		if( printStreamOrWriter instanceof PrintStream ) {
			((PrintStream)printStreamOrWriter).println( message );
		}
		else if( printStreamOrWriter instanceof PrintWriter ) {
			((PrintWriter)printStreamOrWriter).println( message );
		}
	}
}
