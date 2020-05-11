package com.luv2code.springdemo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.luv2code.springdemo.dao.BoxDAO;
import com.luv2code.springdemo.entity.Box;

import com.luv2code.springdemo.entity.ElementRead;

@Service
public class BoxServiceImpl implements BoxService {

	// need to inject customer dao
	@Autowired
	private BoxDAO customerDAO;



	@Override
	@Transactional
	public List<Box> getBox() {

		return customerDAO.getBox();
	}

	@Override
	@Transactional
	public Box getBox(int boxId) {
		// TODO Auto-generated method stub
		return customerDAO.getBox(boxId);
	}

	@Override
	@Transactional
	public List<Box> getBox(int boxId, String color) {
		
		return customerDAO.getBox(boxId,color);
	}

	@Override
	@Transactional
	public void saveElements(ElementRead elementModel) {
		customerDAO.saveBox(elementModel.getBoxes(), null);
		customerDAO.saveItems(elementModel.getItems(), null);
		
	}

	@Override
	@Transactional
	public void readXML(String fileName) {
		ElementRead elementModel = null;
		try {
			elementModel = read(fileName);
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}

		System.out.println("BIEN " + elementModel);
		
		saveElements(elementModel);
		
	}
	
	public ElementRead read(String fileName) throws IOException {

		File file = new File(fileName);

		FileInputStream fileInputStream = new FileInputStream(file);

		String xml = inputStreamToString(fileInputStream);

		XmlMapper mapper = new XmlMapper();

	
		return mapper.readValue(xml, ElementRead.class);
	}

	private String inputStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);

		}
		br.close();
		return sb.toString();
	}

	private String file(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}

	

}
