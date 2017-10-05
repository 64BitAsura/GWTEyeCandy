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

package com.google.code.gwteyecandy;

import com.google.code.gwteyecandy.resources.ButtonResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;

public class Toolbar extends FlowPanel implements HasEnabled {

	private static final ButtonResources res = GWT.create(ButtonResources.class);
	private boolean enabled = true;
	
	public Toolbar() {
		res.style().ensureInjected();
		addStyleName(res.style().toolbar());
		addStyleName(res.style().enabled());
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		if(enabled == this.enabled) {
			return;
		}
		this.enabled = enabled;
		if(enabled) {
			addStyleName(res.style().enabled());
		} else {
			removeStyleName(res.style().enabled());
		}
		for(int i = 0; i < getWidgetCount(); i++) {
			Widget w = getWidget(i);
			if(w instanceof HasEnabled) {
				((HasEnabled)w).setEnabled(enabled);
			}
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}
