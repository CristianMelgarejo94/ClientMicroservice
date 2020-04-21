package com.pragma.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pragma.model.Client;

@Repository
public interface IClientDao extends JpaRepository<Client, Integer> {

	@Query(value="SELECT cli.* FROM client cli WHERE cli.type_document = ?1 AND cli.document_number = ?2", nativeQuery = true)
	public Client findByDocNumber(String typeDoc,int documentNumber);
	
}
