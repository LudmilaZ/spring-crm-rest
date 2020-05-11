package com.luv2code.springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
@Table(name = "item")
public class Item {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JacksonXmlProperty(isAttribute = true)
	private int id;

	@Column(name = "CONTAINED_IN", nullable = true)
	private int containedIn;

	@Column(name = "COLOR")
	@JacksonXmlProperty(isAttribute = true)
	private String color;

	public Item() {

	}

	public Item(int id, int containedIn, String color) {
		this.id = id;
		this.containedIn = containedIn;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", containedIn=" + containedIn + ", color=" + color + "]";
	}

}
