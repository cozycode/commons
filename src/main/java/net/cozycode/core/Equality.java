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

public interface Equality {
   public boolean areEqual( Object lhs, Object rhs );
   
   
   /** Uses reference equality (aka == equality) to compare the two values */
   public static final Equality REFERENCE_EQUALITY = new Equality() {
      @Override public boolean areEqual( Object lhs, Object rhs ) {
         return lhs == rhs;
      }
   };
   
   
   /** Uses Object.equals( Object ) to compare the two values */
   public static final Equality VALUE_EQUALITY = new Equality() {
      @Override public boolean areEqual( Object lhs, Object rhs ) {
         return lhs == null ? rhs == null : lhs.equals( rhs );
      }
   };
   
   
   /** regardless of which objects are passed in this comparison always returns true.  */
   public static final Equality ALWAYS_EQUAL = new Equality() {
      @Override public boolean areEqual( Object lhs, Object rhs ) {
         return true;
      }
   };
   

   /** regardless of which objects are passed in this comparison always returns false.  */
   public static final Equality NEVER_EQUAL = new Equality() {
      @Override public boolean areEqual( Object lhs, Object rhs ) {
         return false;
      }
   };
}
