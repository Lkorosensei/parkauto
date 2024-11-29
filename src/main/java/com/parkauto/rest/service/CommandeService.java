package com.parkauto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.rest.entity.Commande;
import com.parkauto.rest.repository.ICommandeRepository;

@Service
public class CommandeService {
	
	@Autowired
	ICommandeRepository commandeRepository;
	
	//Listes des Commandes
	public List<Commande> getCommande() {
		return commandeRepository.findAll();
	}
	
	//Save
	public Commande saveCommande(Commande commande) {
		return commandeRepository.save(commande);
	}
	
	//Get a commande
	public Commande getCommandeById(Long idcomman) {
		return commandeRepository.findById(idcomman).get();
	}
	
	//Delete
	public void deleteCommande(Commande commande) {
		commandeRepository.delete(commande);
	}
}
