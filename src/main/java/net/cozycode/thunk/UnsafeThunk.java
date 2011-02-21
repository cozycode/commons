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
 * This is a thunk which is not thread-safe.
 * However, if you know the thunk will only ever be
 * accessed in a thread safe manner, then this 
 * will be a more performant implementation than
 * AbstractThunk.
 * 
 * @author Pete Poulos
 */
public abstract class UnsafeThunk<T> implements Thunk<T> {
   private Getter<T> getter = new Getter<T>() {
      @Override
      public T get() {
         getter = new MemoizedThunk<T>( compute() );
         return getter.get();
      }
   };

   @Override
   public T get() {
      return getter.get();
   }

   abstract protected T compute();
}
