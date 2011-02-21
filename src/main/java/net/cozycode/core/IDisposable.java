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
 * Classes which implement this interface have some cleanup operations
 * which should be executed when the object is no longer in use. 
 * This could be a variety of things, such as closing/releasing database 
 * connections, closing files, removing listeners from other objects, etc.
 * 
 * @author Pete Poulos
 */
public interface IDisposable {
	/**
	 * This method is called when the object is being disposed. 
	 * Your cleanup code goes here.
	 */
	void dispose();
}
