package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Box;

import com.luv2code.springdemo.entity.Item;

public interface BoxDAO {



	public List<Box> getBox();

	public Box getBox(int boxId);

	public List<Box> getBox(int boxId, String color);

	public void saveBox(List<Box> boxes, Box parentBox);

	public void saveItems(List<Item> items, Box parentBox);



	
}
