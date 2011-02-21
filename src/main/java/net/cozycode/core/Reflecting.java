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

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/**
 * Reflection Utilities
 * 
 * @author Pete Poulos
 */
public class Reflecting {

   /**
    * Returns the first single argument constructor it can find which matches the type of the
    * argument, one if its super types or one of its interfaces (in that order).
    * <p>
    * Interfaces are searched in random order.
    * 
    * @param clazz - the type we are trying to instantiate
    * @param arg - the argument for the constructor we are calling.
    * @return a new instance or null if no matching constructor was found.
    */
   public static <TYPE,ARG> Constructor<TYPE> getMatchingConstructor( Class<TYPE> clazz, ARG arg ) {
      HashSet<Class<?>> interfaces = new HashSet<Class<?>>();

      // First, try each super type and collect available interfaces
      Class<?> iter = arg.getClass();
      while( iter != null ) {
         try {
            addInterfaces( interfaces, iter );
            return clazz.getConstructor( iter );
         }
         catch( NoSuchMethodException e ) {
            iter = iter.getSuperclass();
         }
      }

      // Next, try each interface
      for( Class<?> iface : interfaces ) {
         try {
            return clazz.getConstructor( iface );
         }
         catch( NoSuchMethodException e ) {
            /* noop */
         }
      }

      return null;
   }

   private static void addInterfaces( Set<Class<?>> set, Class<?> clazz ) {
      for( Class<?> iface : clazz.getInterfaces() ) {
         set.add( iface );
         addInterfaces( set, iface );
      }
   }
}
