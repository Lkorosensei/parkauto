package com.parkauto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.rest.entity.Camion;
import com.parkauto.rest.entity.Vehicule;
import com.parkauto.rest.repository.ICamionRepository;

@Service
public class CamionService {
	
	@Autowired
	ICamionRepository camionRepository;
	
	//Listes des Camions
	public List<Camion> getCamion(){
		return camionRepository.findAll();
	}
	
	//Save
	public Camion saveCamion(Camion camion) {
		return camionRepository.save(camion);
	}
	
	//Get a camion
	public Camion getCamionById(Long idcami) {
		return camionRepository.findById(idcami).get();
	}

	//Delete
	public void deleteCamion(Camion camion) {
		camionRepository.delete(camion);
	}
}
