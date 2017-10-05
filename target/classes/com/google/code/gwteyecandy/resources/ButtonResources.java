/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.code.gwteyecandy.resources;

import static com.google.gwt.resources.client.ImageResource.RepeatStyle.Horizontal;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

public interface ButtonResources extends ClientBundle {

	public interface Style extends CssResource {
		String btn();
		String outer();
		String border();
		String upper();
		String inner();
		String filler();
		String noleft();
		String noright();
		String bar();
		String pressed();
		String hover();
		String icon();
		String enabled();
		String disabled();
		String disabledIE8();
		String disabledIE6();
		String toolbar();
	}
	
	@Source("button.css")
	Style style();
	
	@ImageOptions(repeatStyle=Horizontal)
	ImageResource toolbarbg();
}
