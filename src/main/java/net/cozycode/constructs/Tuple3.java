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

package net.cozycode.constructs;

import net.cozycode.core.Comparisons;
import net.cozycode.thunk.AbstractThunk;
import net.cozycode.thunk.Thunk;

public final class Tuple3<T1, T2, T3> {
   private final T1 first;
   private final T2 second;
   private final T3 third;

   private final Thunk<Integer> hashcode = new HashCode();

   public Tuple3(T1 v1, T2 v2, T3 v3 ) {
      this.first = v1;
      this.second = v2;
      this.third = v3;
   }

   public T1 getFirst() { return first; }	
   public T2 getSecond() { return second; }
   public T3 getThird() { return third; }

   @Override
   @SuppressWarnings("rawtypes")
   public boolean equals(Object obj) {
      if( this == obj ) return true;

      if( obj instanceof Tuple3 ) {
         Tuple3 that = (Tuple3)obj;
         return Comparisons.areEqual( this.first, that.first ) 
             && Comparisons.areEqual( this.second, that.second )
             && Comparisons.areEqual( this.third, that.third );
      }

      return false;
   }

   @Override
   public String toString() {
      return "( "+ first +", "+ second +", "+ third +" )";
   }

   @Override
   public int hashCode() {
      return hashcode.get();
   }

   private final class HashCode extends AbstractThunk<Integer> {
      @Override
      protected Integer compute() {
         int firstHash = first != null ? first.hashCode() : 11;
         int secondHash = second != null ? second.hashCode() : 13;
         int thirdHash = third != null ? third.hashCode() : 17;

         int hash = firstHash;
         hash = hash * 7 + secondHash;
         hash = hash * 7 + thirdHash;
         return hash;
      }
   }
}
