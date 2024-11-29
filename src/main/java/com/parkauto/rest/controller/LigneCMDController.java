package com.parkauto.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkauto.rest.entity.Commande;
import com.parkauto.rest.entity.LigneCMD;
import com.parkauto.rest.service.CommandeService;
import com.parkauto.rest.service.LigneCMDService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping
@CrossOrigin("*")
public class LigneCMDController {
	
	@Autowired
	LigneCMDService ligneCMDService;
	
	@PostMapping("/ligneCMD")
	public LigneCMD createLigneCMD(@Validated @RequestBody( required = false) LigneCMD ligneCMD) {	
		return ligneCMDService.saveLigneCMD(ligneCMD);
	}
	
	@GetMapping("/ligneCMD/{idLigneCMD}")
	public ResponseEntity findClientById(@PathVariable(name = "idLigneCMD") Long idLigneCMD) {
		if (idLigneCMD == null) {
			return ResponseEntity.badRequest().body("Cannot retrieve ligneCMD with null ID");		
			}
		
		LigneCMD ligneCMD = ligneCMDService.getLigneCMDById(idLigneCMD);
		if (ligneCMD == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/ligneCMD/{idLigneCMD}")
	public ResponseEntity<LigneCMD> deleteLigneCMD(@PathVariable(name = "id") Long idLigneCMD) {
		
		LigneCMD ligneCMD = ligneCMDService.getLigneCMDById(idLigneCMD);
		if (ligneCMD == null) {
			return ResponseEntity.notFound().build();
		}
		
		ligneCMDService.deleteLigneCMD(ligneCMD);
		return ResponseEntity.ok().body(ligneCMD);
	}
	
}
