package com.pragma.service;

import java.util.List;

import com.pragma.model.Client;

public interface IClientService {

	public List<Client> getAllClient();
	
	public Client getClientByDocNum(Client client);
	
	public Client saveClient(Client client);
	
	public Client updateClient(Client client);
	
	public String deleteClient(Client client);
	
}
