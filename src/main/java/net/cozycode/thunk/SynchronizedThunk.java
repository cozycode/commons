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
 * This is a thread-safe thunk which synchronizes on the thunk
 * each time the thunk result is requested.  The AbstractThunk
 * implementation uses this implementation internally and
 * is slightly more performant than this one.  However,
 * I decided to expose this one publicly in case you prefer
 * this implementation over the more complex implementation
 * in AbstractThunk.
 * 
 * @author Pete Poulos
 */
public abstract class SynchronizedThunk<T> implements Thunk<T>{
   private Getter<T> getter = new Getter<T>() {
      @Override
      public T get() {
         getter = new MemoizedThunk<T>( compute() );
         return getter.get();
      }
   };

   @Override
   public synchronized T get() {
      return getter.get();
   }

   abstract protected T compute();
}
