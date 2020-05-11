package com.luv2code.springdemo.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.hibernate.cfg.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.luv2code.springdemo.entity.Box;

import com.luv2code.springdemo.entity.ElementRead;
import com.luv2code.springdemo.entity.Item;
import com.luv2code.springdemo.service.BoxService;

@RestController
@RequestMapping("/api")
public class BoxRestController {

	private static final String FILE_NAME = "C:\\db-datas.xml";

	@Autowired
	private BoxService customerService;

	@PostConstruct
	public void loadData() {

		customerService.readXML(FILE_NAME);
		System.out.println("Datas is add");
	}

	@GetMapping("/box")
	public List<Box> getBox() {
		return customerService.getBox();

	}

	@GetMapping("/box/{boxId}")
	public Box getBox(@PathVariable int boxId) {
		Box theBox = customerService.getBox(boxId);
		if (theBox==null) {
			throw new BoxnotFoundExc("Box id not found "+boxId);
		}
		return theBox;

	}

	private Set<Integer> getBoxColor(String color, Box theBox) {

		Set<Integer> thelist = new HashSet();
		thelist = getBox(color, thelist, theBox.getBoxList());

		for (Item item : theBox.getItems()) {
			if (color.equals(item.getColor())) {
				thelist.add(item.getId());
			}

		}

		System.out.println(thelist);
		return thelist;
	}

	private Set<Integer> getBox(String color, Set<Integer> thelist, List<Box> theBoxList) {

		for (Box box : theBoxList) {

			if (box.getBoxList().size() == 0) {
				for (Item item : box.getItems()) {
					if (color.equals(item.getColor())) {
						thelist.add(item.getId());

					}

				}

			} else {
//				Scanner scanner = new Scanner(System.in);
//				int a = scanner.nextInt();
//				if (a == 1) {
//					return thelist;
//				} else {
//					
//				}
				
				
				getBox(color, thelist, box.getBoxList());
			}

		}

		return thelist;
	}

	@GetMapping("/box/{boxId}/{color}")
	public Set<Integer> getBox(@PathVariable int boxId, @PathVariable String color) {

		Box theBox = customerService.getBox(boxId);
		Set<Integer> itemSet = getBoxColor(color, theBox);
		System.out.println(itemSet);
		
		if (theBox==null) {
			throw new BoxnotFoundExc("Box id not found "+boxId);
		}
		return itemSet;

	}

}
