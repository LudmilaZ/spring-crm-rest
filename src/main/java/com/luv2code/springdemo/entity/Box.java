package com.luv2code.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "box")
public class Box {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "ID")
	private int id;

	@Column(name = "CONTAINED_IN", nullable = true)
	private int containedIn;

	public Box(int id, int containedIn) {
		this.id = id;
		this.containedIn = containedIn;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTAINED_IN")
	@JacksonXmlElementWrapper(useWrapping = false, localName = "items")
	@JacksonXmlProperty(localName = "Item")
	private List<Item> items;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTAINED_IN")
	@JacksonXmlElementWrapper(useWrapping = false, localName = "boxList")
	@JacksonXmlProperty(localName = "Box")
	private List<Box> boxList;

	public Box() {

	}

	public List<Box> getBoxList() {
		return boxList;
	}

	public void setBoxList(List<Box> boxList) {
		this.boxList = boxList;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> value) {
		 if (items == null) {
			 items = new ArrayList<>(value.size());
	        }
		 items.addAll(value);
//		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContainedIn() {
		return containedIn;
	}

	public void setContainedIn(int containedIn) {
		this.containedIn = containedIn;
	}

	@Override
	public String toString() {
		return "Box [id=" + id + ", containedIn=" + containedIn + "]";
	}

}
