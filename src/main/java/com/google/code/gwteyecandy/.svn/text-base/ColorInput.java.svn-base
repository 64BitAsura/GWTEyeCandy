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

import com.google.code.gwteyecandy.resources.ColorResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class ColorInput extends Widget implements HasValue<String> {
	
	private static final ColorResources res = GWT.create(ColorResources.class);
	
	private String value;
	
	public ColorInput() {
		this(new ColorPicker(), "rgb(255, 255, 255)");
	}
	
	public ColorInput(ColorPicker picker, String value) {
		
		setElement(createDisplayElement());
		
		setValue(value);
		final PopupPanel popup = new PopupPanel(true);
		popup.setStyleName(res.style().palettePopup());
		popup.setWidget(picker);
		
		addDomHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				popup.showRelativeTo(ColorInput.this);
			}
		}, ClickEvent.getType());
		
		picker.addSelectionHandler(new SelectionHandler<String>() {
			
			@Override
			public void onSelection(SelectionEvent<String> event) {
				setValue(event.getSelectedItem(), true);
				popup.hide();
			}
		});
	}
	
	/**
	 * Creates and returns the DOM element of the widget.
	 * Override this method to change the look of the widget as it is rendered.
	 * In such a case you may also need to override 
	 * {@link ColorInput#updateDisplayElement(String)}
	 * @return DOM element
	 */
	protected Element createDisplayElement() {
		res.style().ensureInjected();
		Element element = DOM.createSpan();
		element.addClassName(res.style().colorInput());
		return element;
	}
	
	/**
	 * This method is called after setting or changing the selected color and
	 * updates the DOM element to reflect the change.
	 * If you override {@link ColorInput#createDisplayElement()} , you may need
	 * to override too.
	 * @param value The selected color
	 */
	protected void updateDisplayElement(String value) {
		getElement().getStyle().setBackgroundColor(value);
	}
	
	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
		updateDisplayElement(value);
	}

	@Override
	public void setValue(String value, boolean fireEvents) {
		String oldValue = this.value;
		setValue(value);
		if(fireEvents) {
			ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
		}
	}

}
