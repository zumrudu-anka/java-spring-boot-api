package com.javaCourse.project.hibernateAndJPA.Business;

import java.util.List;

import com.javaCourse.project.hibernateAndJPA.Entities.City;

public interface ICityService {
	List<City> getAll();
	City get(int cityId);
	void add(City city);
	void update(City city);
	void delete(City city);
}
