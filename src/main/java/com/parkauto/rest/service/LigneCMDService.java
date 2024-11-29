package com.parkauto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.rest.entity.Commande;
import com.parkauto.rest.entity.LigneCMD;
import com.parkauto.rest.repository.ICommandeRepository;
import com.parkauto.rest.repository.ILigneCMDRepository;

@Service
public class LigneCMDService {
	
	@Autowired
	ILigneCMDRepository lignecmdRepository;
	
	//Listes des LigneCMD
	public List<LigneCMD> getLigneCMD() {
		return lignecmdRepository.findAll();
	}
	
	//Save
	public LigneCMD saveLigneCMD(LigneCMD lignecmd) {
		return lignecmdRepository.save(lignecmd);
	}
	
	//Get a LigneCMD
	public LigneCMD getLigneCMDById(Long idlignecmd) {
		return lignecmdRepository.findById(idlignecmd).get();
	}
	
	//Delete
	public void deleteLigneCMD(LigneCMD LigneCMD) {
		lignecmdRepository.delete(LigneCMD);
	}
}
