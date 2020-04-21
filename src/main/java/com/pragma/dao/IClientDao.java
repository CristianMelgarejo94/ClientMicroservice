package com.pragma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pragma.model.Client;

public interface IClientDao extends JpaRepository<Client, Integer> {

}
