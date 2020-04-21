package com.pragma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.dao.IClientDao;
import com.pragma.model.Client;
import com.pragma.service.ClientService;
import com.pragma.service.IClientService;


@RestController
@RequestMapping("/client")
public class ClientController {	
	
	@Autowired
	private IClientService clientService;

	@GetMapping()
	public List<Client> getAll() {
		return clientService.getAllClient();
	}	
	
	// Metodo get para traer un cliente con determinado ID
	// No seria seguro utilizarlo dado que en la URL viajaria su ID
	//	@GetMapping(value = "{id}")
	//	public Client find(@PathVariable Integer id) {
	//		return repoClient.getOne(id);
	//	}
	
	@GetMapping(value = "/find")
	public ResponseEntity<Client> find(@RequestBody Client client) {
		
		Client clientFound = clientService.getClientByDocNum(client);
		
		if(clientFound == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Client>(clientFound, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Client> save(@RequestBody Client client) {
		Client newClient = clientService.saveClient(client);
		return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
	}	
	
	@PutMapping()
	public ResponseEntity<Client> update(@RequestBody Client client) {
		Client updateClient = clientService.updateClient(client);
		
		if(updateClient == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Client>(updateClient, HttpStatus.OK);
	}	

	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestBody Client client) {
		String resp = clientService.deleteClient(client);
		if (resp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}
	
}