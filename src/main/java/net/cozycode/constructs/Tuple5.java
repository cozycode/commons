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

public final class Tuple5<T1, T2, T3, T4, T5> {
	private final T1 first;
	private final T2 second;
	private final T3 third;
	private final T4 fourth;
	private final T5 fifth;

   private final Thunk<Integer> hashcode = new HashCode();
	
	public Tuple5(T1 v1, T2 v2, T3 v3, T4 v4, T5 v5 ) {
		this.first = v1;
		this.second = v2;
		this.third = v3;
		this.fourth = v4;
		this.fifth = v5;
	}
	
	public T1 getFirst() { return first; }	
	public T2 getSecond() { return second; }
	public T3 getThird() { return third; }
	public T4 getFourth() { return fourth; }
	public T5 getFifth() { return fifth; }

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if( this == obj ) return true;
		
		if( obj instanceof Tuple5 ) {
			Tuple5 that = (Tuple5)obj;
			return Comparisons.areEqual( this.first, that.first ) 
		    && Comparisons.areEqual( this.second, that.second )
		    && Comparisons.areEqual( this.third, that.third )
		    && Comparisons.areEqual( this.fourth, that.fourth )
		    && Comparisons.areEqual( this.fifth, that.fifth );
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "( "+ first +", "+ second +", "+ third +", "+ fourth +", "+ fifth +" )";
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
         int fourthHash = fourth != null ? fourth.hashCode() : 19;
         int fifthHash = fifth != null ? fifth.hashCode() : 23;

         int hash = firstHash;
         hash = hash * 7 + secondHash;
         hash = hash * 7 + thirdHash;
         hash = hash * 7 + fourthHash;
         hash = hash * 7 + fifthHash;
         return hash;
      }
   }
}
