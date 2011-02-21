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

package net.cozycode.thunk;

/**
 * This wraps a Getter in thread-safe thunk operation.
 * 
 * @author Pete Poulos
 */
public final class Thunkify<T> implements Thunk<T> {
   private volatile Getter<T> getter;
   
   public Thunkify( final Getter<T> compute ) {
      this.getter = new SynchronizedThunk<T>() {
         @Override
         protected T compute() {
            T result = compute.get();
            getter = new MemoizedThunk<T>( result );
            return result;
         }
      };
   }
   
   @Override
   public T get() {
      return getter.get();
   }
}
