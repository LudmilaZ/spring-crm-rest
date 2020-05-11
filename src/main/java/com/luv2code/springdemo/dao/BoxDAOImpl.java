package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Box;

import com.luv2code.springdemo.entity.Item;

@Repository
public class BoxDAOImpl implements BoxDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<Box> getBox() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("IN servis");

		Query<Box> theQuery = currentSession.createQuery("from Box", Box.class);

		// execute query and get result list
		List<Box> box = theQuery.getResultList();

		// return the results
		return box;
	}

	@Override
	public Box getBox(int boxId) {

		System.out.println("IN servis getBox ID");
		Session currentSession = sessionFactory.getCurrentSession();
		Box theBox = currentSession.get(Box.class, boxId);

		return theBox;
	}

	@Override
	public List<Box> getBox(int boxId, String color) {
		System.out.println("IN servis getBox ID COLOR");

		Box theBox = getBox(boxId);

		for (Item iterable_element : theBox.getItems()) {

		}
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Box> theQuery = currentSession.createQuery("where id= :boxId AND color =:color", Box.class);

		// execute query and get result list
		List<Box> box = theQuery.getResultList();

		// return the results
		return box;
	}

	@Override
	public void saveBox(List<Box> boxes, Box parentBox) {

		for (Box box : boxes) {
			saveDataBase(box);
		}
		System.out.println("FINAL");
	}

	private void saveDataBase(Box thebox) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(thebox);

	}

	private void saveDataBase(Item theItem) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theItem);

	}

	@Override
	public void saveItems(List<Item> items, Box parentBox) {

		for (Item item : items) {
			saveDataBase(item);
		}
		System.out.println("FINAL");

	}

}
