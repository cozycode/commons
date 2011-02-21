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

/**
 * Some basic utilities for cleaning up interrupted exception
 * checks when working with threads.  
 * 
 * @author Pete Poulos
 */
public class Threading {
   private Threading() { /* static singleton */ }

   /** 
    * Causes the currently running thread to sleep for the
    * specified number of milliseconds.
    * 
    * @param millis - the number of milliseconds to sleep.
    * @return true IFF InterruptedException was not thrown while sleeping
    */
   public static boolean sleep( long millis ) {
      try { 
         Thread.sleep( millis );
      } 
      catch( InterruptedException e ) {
         return false;
      }
      return true;
   }

   /**
    * Causes the currently running thread to sleep for the
    * specified number of milliseconds and nanoseconds.
    * 
    * @param millis - the number of milliseconds to sleep.
    * @param nanos - the number of nanoseconds to sleep.
    * @return true IFF InterruptedException was not thrown while sleeping
    */
   public static boolean sleep( long millis, int nanos ) {
      try {
         Thread.sleep( millis, nanos );
      } 
      catch( InterruptedException e ) {
         return false;
      }
      return true;
   }

   /**
    * Calls join() on the specified thread.
    * 
    * @param t - The thread to join on.
    * @return true IFF InterruptedException was not thrown.
    */
   public static boolean join( Thread t ) {
      try {
         t.join();
      }
      catch( InterruptedException e ) {
         return false;
      }
      return true;
   }

   /**
    * Calls join(millis) on the specified thread.
    * 
    * @param t - The thread to join on.
    * @param millis - time to wait in milliseconds
    * @return true IFF InterruptedException was not thrown.
    */
   public static boolean join( Thread t, long millis ) {
      try {
         t.join( millis );
      }
      catch( InterruptedException e ) {
         return false;
      }
      return true;
   }

   /**
    * Calls join(millis,nanos) on the specified thread.
    * 
    * @param t - The thread to join on.
    * @param millis - time to wait in milliseconds
    * @param nanos - time to wait in nanoseconds
    * @return true IFF InterruptedException was not thrown.
    */
   public static boolean join( Thread t, long millis, int nanos ) {
      try {
         t.join( millis, nanos );
      }
      catch( InterruptedException e ) {
         return false;
      }
      return true;
   }
}
