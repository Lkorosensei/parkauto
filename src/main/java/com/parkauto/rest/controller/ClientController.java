package com.parkauto.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkauto.rest.entity.Client;
import com.parkauto.rest.service.ClientService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/client")
	public Client createClient(@Validated @RequestBody(required = false) Client client) {
		return clientService.saveClient(client);
	}
	
	@GetMapping("/client/{idClient}")
	public ResponseEntity findClientById(@PathVariable(name = "idClient") Integer idClient) {
		if (idClient == null) {
			return ResponseEntity.badRequest().body("Cannot retrieve client with null ID");
		}
		
		Client clien = clientService.getClientById(idClient);
		if ( clien == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/client/{idClient}")
	public ResponseEntity<Client> deleteClient(@PathVariable(name = "id") Integer idClient) {
		
		Client clien = clientService.getClientById(idClient);
		if (clien == null) {
			return ResponseEntity.notFound().build();
		}
		
		clientService.deleteClient(clien);
		return ResponseEntity.ok().body(clien);
	}
}
