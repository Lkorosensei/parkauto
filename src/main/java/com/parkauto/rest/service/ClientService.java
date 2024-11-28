package com.parkauto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.rest.entity.Client;
import com.parkauto.rest.repository.IClientRepository;

@Service
public class ClientService {
	
	@Autowired
	IClientRepository clientRepository;
	
	//Listes des clients
	public List<Client> getClient(){
		return clientRepository.findAll();
	}
	
	//Save
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}
	
	//Get a client
	public Client getClientById(Integer idclient) {
		return clientRepository.findById(idclient).get();
	}
	
	//Delete
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}

}
