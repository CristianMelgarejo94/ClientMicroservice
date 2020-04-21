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


@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private IClientDao repoClient;		

	@GetMapping()
	public List<Client> getAll() {
		return repoClient.findAll();
	}	
	
	@GetMapping(value = "{id}")
	public Client find(@PathVariable Integer id) {
		return repoClient.getOne(id);
	}

	@PostMapping()
	public ResponseEntity<Client> save(@RequestBody Client client) {
		Client obj = repoClient.save(client);
		return new ResponseEntity<Client>(obj, HttpStatus.OK);
	}	
	
	@PutMapping(value = "{id}")
	public ResponseEntity<Client> update(@RequestBody Client client) {
		Client obj = repoClient.save(client);
		return new ResponseEntity<Client>(obj, HttpStatus.OK);
	}	

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Client> delete(@PathVariable Integer id) {
		Client client = repoClient.getOne(id);
		if (client != null) {
			repoClient.delete(client);
		}else {
			return new ResponseEntity<Client>(client, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
}