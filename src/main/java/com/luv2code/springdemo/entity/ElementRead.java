package com.luv2code.springdemo.entity;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;



@JacksonXmlRootElement
public class ElementRead {
	 @JacksonXmlElementWrapper(useWrapping = false, localName = "boxes")
	    @JacksonXmlProperty(localName = "Box")
	    private List<Box> boxes;

	    @JacksonXmlElementWrapper(useWrapping = false, localName = "items")
	    @JacksonXmlProperty(localName = "Item")
	    private List<Item> items;

		public List<Box> getBoxes() {
			return boxes;
		}

		public void setBoxes(List<Box> boxes) {
			this.boxes = boxes;
		}

		public List<Item> getItems() {
			return items;
		}

		public void setItems(List<Item> items) {
			this.items = items;
		}

	
}
