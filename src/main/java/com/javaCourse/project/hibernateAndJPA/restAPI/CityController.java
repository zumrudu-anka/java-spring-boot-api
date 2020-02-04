package com.javaCourse.project.hibernateAndJPA.restAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaCourse.project.hibernateAndJPA.Business.ICityService;
import com.javaCourse.project.hibernateAndJPA.Entities.City;

@RestController
@RequestMapping("/api/cities")
public class CityController {
	private ICityService cityService;
	
	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("")
	public List<City> getCities(){
		return this.cityService.getAll();
	}
	
	@GetMapping("/{cityId}")
	public City getCity(@PathVariable int cityId) {
		return cityService.get(cityId);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		cityService.add(city);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	
	
}
