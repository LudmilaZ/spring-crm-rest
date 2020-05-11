package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Box;

import com.luv2code.springdemo.entity.ElementRead;

public interface BoxService {



	public List<Box> getBox();

	public Box getBox(int boxId);

	public List<Box> getBox(int boxId, String color);

	public void saveElements(ElementRead elementModel);

	public void readXML(String fileName);




	
}
