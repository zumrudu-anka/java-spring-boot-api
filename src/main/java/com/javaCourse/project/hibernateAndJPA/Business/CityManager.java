package com.javaCourse.project.hibernateAndJPA.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaCourse.project.hibernateAndJPA.DataAccess.ICityDAL;
import com.javaCourse.project.hibernateAndJPA.Entities.City;

@Service
public class CityManager implements ICityService{
	
	private ICityDAL cityDAL;
	
	@Autowired
	public CityManager(ICityDAL cityDAL) {
		this.cityDAL = cityDAL;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		return this.cityDAL.getAll();
	}
	
	@Override
	@Transactional
	public City get(int cityId) {
		return this.cityDAL.get(cityId);
	}

	@Override
	@Transactional
	public void add(City city) {
		// Business Rules
		this.cityDAL.add(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDAL.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDAL.delete(city);
	}

	

}
