package com.javaCourse.project.hibernateAndJPA.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaCourse.project.hibernateAndJPA.Entities.City;

@Repository
public class HibernateCityDAL implements ICityDAL{

	private EntityManager entityManager;
	
	@Autowired
	public HibernateCityDAL(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		Session session = this.entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City", City.class).getResultList();
		return cities;
	}

	@Override
	@Transactional
	public City get(int cityId) {
		Session session = this.entityManager.unwrap(Session.class);
		return session.get(City.class, cityId);
	}
	
	@Override
	@Transactional
	public void add(City city) {
		Session session = this.entityManager.unwrap(Session.class);
		session.save(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		Session session = this.entityManager.unwrap(Session.class);
		session.saveOrUpdate(city); // Eger id verilmisse guncelleme yapar. Verilmemisse ekler
	}

	@Override
	@Transactional
	public void delete(City city) {
		Session session = this.entityManager.unwrap(Session.class);
		City cityForDelete = session.get(City.class, city.getId());
		session.delete(cityForDelete);
	}

	
}
