package com.luciano.cargomgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luciano.cargomgmt.dao.CargoDAO;
import com.luciano.cargomgmt.model.Cargo;

@RestController
public class CargoController {

	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping(value="/cargo",method = RequestMethod.GET,headers="Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cargo> getAllCargo(){
		CargoDAO cargoDAO = appContext.getBean(CargoDAO.class);
		List<Cargo> cargoes = cargoDAO.allCargo();
		return cargoes;
	}
	
	@RequestMapping(value="/cargo/insert",method = RequestMethod.POST,headers="Accept=application/json")
	public List<Cargo> addCargo(@RequestBody Cargo cargo){ 
		System.out.println(cargo.getId() + " " + cargo.getName());
		CargoDAO cargoDAO = appContext.getBean(CargoDAO.class);
		cargoDAO.save(cargo);
	  	
	  	List<Cargo> cargoes = cargoDAO.allCargo();
		return cargoes;
	}    
}
