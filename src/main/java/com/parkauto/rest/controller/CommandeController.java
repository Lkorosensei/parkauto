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
import com.parkauto.rest.service.CommandeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping
@CrossOrigin("*")
public class CommandeController {
	
	@Autowired
	CommandeService commandeService;
	
	@PostMapping("/commande")
	public Commande createCommande(@Validated @RequestBody( required = false) Commande commande) {	
		return commandeService.saveCommande(commande);
	}
	
	@GetMapping("/commande/{idCommande}")
	public ResponseEntity findClientById(@PathVariable(name = "idCommande") Long idCommande) {
		if (idCommande == null) {
			return ResponseEntity.badRequest().body("Cannot retrieve commande with null ID");		
			}
		
		Commande command = commandeService.getCommandeById(idCommande);
		if (command == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/commande/{idCommande}")
	public ResponseEntity<Commande> deleteCommande(@PathVariable(name = "id") Long idCommande) {
		
		Commande command = commandeService.getCommandeById(idCommande);
		if (command == null) {
			return ResponseEntity.notFound().build();
		}
		
		commandeService.deleteCommande(command);
		return ResponseEntity.ok().body(command);
	}
	
}
