package com.parkauto.rest.controller;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkauto.rest.entity.Voiture;
import com.parkauto.rest.service.VoitureService;

@RestController
@RequestMapping//("/api")  Ajout d'un préfixe pour organiser les routes
@CrossOrigin("*")
public class VoitureController {
	
	@Autowired
	VoitureService voitureService;

    // Ajout de la route racine
    @GetMapping("/")
    public String home() {
        return "Bienvenue sur l'API de gestion des voitures !"; // Message de bienvenue
    }

	@PostMapping("/voitures")
	public Voiture createVoiture(@Validated @RequestBody Voiture voiture) {
		return voitureService.saveVoiture(voiture);
	}
	
	@GetMapping("/voitures")
	public List<Voiture> getAllVoiture() {
		return voitureService.getVoitures();
	}
	
	@GetMapping("/voitures/{idVoiture}")
	public ResponseEntity findVoitureById(@PathVariable(name="idVoiture") Long idVoiture) {
		if (idVoiture == null) {
			return ResponseEntity.badRequest().body("Cannot retrieve voiture with null ID");
		}
		
		Voiture voit = voitureService.getVoitureById(idVoiture);
		if (voit == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(voit);
	}
	
	@DeleteMapping("/voitures/{id}")
	public ResponseEntity<Voiture> deleteVoiture(@PathVariable(name = "id") Long idVoiture) {
		
		Voiture voit = voitureService.getVoitureById(idVoiture);
		if (voit == null) {
			return ResponseEntity.notFound().build();
		}
		voitureService.deleteVoiture(voit);
		
		return ResponseEntity.ok().body(voit);
	}
	
	@PutMapping("/voitures/{id}")
	public ResponseEntity<Voiture> updateVoiture(@PathVariable(name = "id") Long idVoiture, @RequestBody Voiture voiture) {
		
		if (voiture == null) {
			return ResponseEntity.notFound().build();
		}
		Voiture voit = voitureService.updateVoiture(idVoiture, voiture);
		return ResponseEntity.ok().body(voit);
	}
	
}
