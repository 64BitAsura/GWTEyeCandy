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

package com.google.code.gwteyecandy.impl;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window.Navigator;


public class ButtonImplIE6 extends ButtonImplIE8 {
	
	private final boolean isIE6; /* true -> IE6 , false -> IE7 */
	
	public ButtonImplIE6() {
		isIE6 = Navigator.getUserAgent().contains("MSIE 6.0");
	}

	@Override
	public int getEventsToSink() {
		if(isIE6) {
			return super.getEventsToSink() | Event.ONMOUSEOVER | Event.ONMOUSEOUT;
		} else {
			return super.getEventsToSink();
		}
	}
	
	@Override
	public void setHover(Element element) {
		element.addClassName(res.style().hover());
	}

	@Override
	public void setUnhover(Element element) {
		element.removeClassName(res.style().hover());
	}
	
	@Override
	public void fixGradient(final Element element) {
		if(isIE6) {
			Scheduler.get().scheduleDeferred(new ScheduledCommand() {
				public void execute() {
					int width = element.getParentElement().getOffsetWidth() - 3;
					element.getStyle().setWidth(width, Unit.PX);
					
					int height = (int)(element.getParentElement().getOffsetHeight() * 0.4);
					element.getStyle().setBottom(0, Unit.PX);
					element.getStyle().setPropertyPx("lineHeight", height);
				}
			});
		}
	}
	
	@Override
	public void setEnabled(Element element, boolean enabled) {
		if(enabled) {
			element.getStyle().clearProperty("filter");
		} else {
			element.getStyle().setProperty("filter", "alpha(opacity=50)");
		}
	}
}
