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
 * This class is intended to be statically imported to provide standardized comparisons.
 */
public final class Comparisons {
   protected Comparisons() { /* Static Interface */ }

   /** 
    * Compares to items for equality.  Returns true if they are both null.
    * 
    * @param lhs one of two items to be compared for equality
    * @param rhs one of two items to be compared for equality
    * @return true IFF both items are equal
    */
   public static boolean areEqual( Object lhs, Object rhs ) {
      return lhs == rhs || ( lhs != null && lhs.equals( rhs )); 
   }


   /** 
    * Compares to items for inequality.
    * 
    * @param lhs one of two items to be compared for inequality
    * @param rhs one of two items to be compared for inequality
    * @return true IFF both items are not equal
    */
   public static boolean areNotEqual( Object lhs, Object rhs ) {
      return lhs != rhs && (lhs == null || !lhs.equals( rhs ));
   }


   /**
    * Checks that the string is either null or "".
    * 
    * @param str the string 
    * @return true IFF str is either null or ""
    */
   public static boolean isEmpty( String str ) {
      return str == null || "".equals( str );
   }

   /**
    * Checks that the string is not null or "".
    * 
    * @param str the string 
    * @return true IFF str is not null and not ""
    */
   public static boolean isNotEmpty( String str ) {
      return str != null && !"".equals( str );
   }

   /**
    * Checks item is null, "" or not a string.
    * 
    * @param item any old object
    * @return true IFF item is not a string || item is null || item.equals("")
    */
   public static boolean isEmptyString( Object item ) {
      return !( item instanceof String ) || Comparisons.isEmpty( (String)item );
   }


   /**
    * Checks that item is a string and is not null or "".
    * 
    * @param item any old object
    * @return true IFF item is not null && a string && !item.equals("")
    */
   public static boolean isNotEmptyString( Object item ) {
      return !isEmptyString( item );
   }
}
