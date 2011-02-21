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

public final class Tuple {
   private Tuple() { /* Static Singleton */ }

   public static <T1,T2> Tuple2<T1,T2> tuple( T1 v1, T2 v2 ) {
      return new Tuple2<T1,T2>( v1, v2 );
   }

   public static <T1,T2,T3> Tuple3<T1,T2,T3> tuple( T1 v1, T2 v2, T3 v3 ) {
      return new Tuple3<T1,T2,T3>( v1, v2, v3 );
   }

   public static <T1,T2,T3,T4> Tuple4<T1,T2,T3,T4> tuple( T1 v1, T2 v2, T3 v3, T4 v4 ) {
      return new Tuple4<T1,T2,T3,T4>( v1, v2, v3, v4 );
   }

   public static <T1,T2,T3,T4,T5> Tuple5<T1,T2,T3,T4,T5> tuple( T1 v1, T2 v2, T3 v3, T4 v4, T5 v5 ) {
      return new Tuple5<T1,T2,T3,T4,T5>( v1, v2, v3, v4, v5 );
   }

}
