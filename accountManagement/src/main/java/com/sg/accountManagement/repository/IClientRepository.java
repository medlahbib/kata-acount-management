package com.sg.accountManagement.repository;

import com.sg.accountManagement.entity.Client;

public interface IClientRepository {
	
	Client findById(int idClient);
	
	void update(Client client);

	Client getClientByUsername(String username);
	 
}
