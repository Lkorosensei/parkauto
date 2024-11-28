package com.parkauto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.rest.entity.Voiture;
import com.parkauto.rest.repository.IVoitureRepository;

@Service
public class VoitureService {
	
	@Autowired
	IVoitureRepository VoitureRepository;
	
	//Listes des Voitures 
	public List<Voiture> getVoitures(){
		return VoitureRepository.findAll();
	}
	
	//Save = create
	public Voiture saveVoiture(Voiture Voiture) {
		return VoitureRepository.save(Voiture);
	}
	
	//Get a Voiture
	public Voiture getVoitureById(Long idvoiture) {
		return VoitureRepository.findById(idvoiture).get();
	}
	
	//Delete
	public void deleteVoiture(Voiture Voiture) {
		VoitureRepository.delete(Voiture);
	}
	
}
