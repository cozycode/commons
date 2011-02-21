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

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * This is a utility class for writing values to Strings.
 * 
 * @author Pete Poulos
 */
public final class Printing {
   private Printing() { /* STATIC SINGLETON */ }

   public static String arrayToString( Object[] array ) {
      StringBuffer buffer = new StringBuffer( "[ " );
      for( Object i : array ) {
         buffer.append( i.toString() );
         buffer.append( " " );
      }
      buffer.append( ']' );
      return buffer.toString();
   }
   
   public static String arrayToString( int[] array ) {
      StringBuffer buffer = new StringBuffer( "[ " );
      for( int i : array ) {
         buffer.append( i );
         buffer.append( " " );
      }
      buffer.append( ']' );
      return buffer.toString();
   }
   
   public static String arrayToString( long[] array ) {
      StringBuffer buffer = new StringBuffer( "[ " );
      for( long i : array ) {
         buffer.append( i );
         buffer.append( " " );
      }
      buffer.append( ']' );
      return buffer.toString();
   }
   
   public static String arrayToString( float[] array ) {
      StringBuffer buffer = new StringBuffer( "[ " );
      for( float i : array ) {
         buffer.append( i );
         buffer.append( " " );
      }
      buffer.append( ']' );
      return buffer.toString();
   }
   
   public static String arrayToString( double[] array ) {
      StringBuffer buffer = new StringBuffer( "[ " );
      for( double i : array ) {
         buffer.append( i );
         buffer.append( " " );
      }
      buffer.append( ']' );
      return buffer.toString();
   }
   
   public static String printf( String format, Object... args ) {
      StringWriter stringWriter = new StringWriter();
      PrintWriter printer = new PrintWriter( stringWriter );
      printer.printf( format, args );
      
      return stringWriter.toString(); 
   }
}
