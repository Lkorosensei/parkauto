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
	
	//Mise à jour d'une voiture
	public Voiture updateVoiture(Long idVoiture, Voiture voiture) {
		
		Voiture voitureMAJ = VoitureRepository.findById(idVoiture).get();
		
		voitureMAJ.setAnneeModel(voiture.getAnneeModel());
		voitureMAJ.setCategorie(voiture.getCategorie());
		voitureMAJ.setImmatriculation(voiture.getImmatriculation());
		voitureMAJ.setMatricule(voiture.getMatricule());
		voitureMAJ.setMedia(voiture.getMedia());
		voitureMAJ.setNbPorte(voiture.getNbPorte());
		voitureMAJ.setPoidsTotal(voiture.getPoidsTotal());
		voitureMAJ.setPrix(voiture.getPrix());
		voitureMAJ.setPuissanceFiscale(voiture.getPuissanceFiscale());
		
		return VoitureRepository.save(voitureMAJ);
	}
}
