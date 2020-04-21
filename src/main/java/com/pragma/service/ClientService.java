package com.pragma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pragma.dao.IClientDao;
import com.pragma.model.Client;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private IClientDao repoClient;

	@Override
	public List<Client> getAllClient() {		
		return repoClient.findAll();		
	}

	@Override
	public Client getClientByDocNum(Client client) {		
		Client clientFound = repoClient.findByDocNumber(client.getTypeDoc(), client.getDocumentNumber());				
		return clientFound;
	}

	@Override
	public Client saveClient(Client client) {			
		Client newClient = repoClient.save(client);
		return newClient;
	}

	@Override
	public Client updateClient(Client client) {		
		Client clientFound = getClientByDocNum(client);		
		if(clientFound == null) {
			return null;
		}
		client.setId(clientFound.getId());
		Client updateClient = repoClient.save(client);
		return updateClient;
	}

	@Override
	public String deleteClient(Client client) {		
		Client clientFound = getClientByDocNum(client);		
		if(clientFound == null) {
			return null;
		}
		repoClient.delete(clientFound);		
		return "Cliente "+clientFound.getNames()+" Eliminado correctamente";		
	}
}
