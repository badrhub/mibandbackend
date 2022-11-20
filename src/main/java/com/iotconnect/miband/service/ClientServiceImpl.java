package com.iotconnect.miband.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iotconnect.miband.dao.ClientRepository;
import com.iotconnect.miband.models.Client;
import com.iotconnect.miband.models.Heartbeat;

@Transactional
@Service
public class ClientServiceImpl implements IClientService{
	
	private ClientRepository  clientRepository;
	
	public ClientServiceImpl(ClientRepository cr) {
		this.clientRepository = cr;
	}

	@Override
	public List<Client> update(String id, Client c) {
	  Client old = clientRepository.findById(id).get();
	  old.setId(id);
	  old.setName(c.getName());
	  clientRepository.save(old);
	  return clientRepository.findAll();
	}

	@Override
	public List<Client> add(Client c) {
		 clientRepository.save(c);
		 return clientRepository.findAll();
	}

	@Override
	public List<Client> delete(String id) {
		Client old = clientRepository.findById(id).get();
	    clientRepository.delete(old);
	    return clientRepository.findAll();
	}

	@Override
	public Client getById(String id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public Client getByHeartbeat(Long id) {
		return null;
	}

	@Override
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	@Override
	public List<Heartbeat> getHeartbeatsByClient(String authid) {
		if(authid != null) {
			Client c = clientRepository.findById(authid).get();
			if(c != null) {
				return c.getHeartbeats();
			}
		}
		return null;
	}

	@Override
	public Client getClientById(String authid) {
		return clientRepository.findById(authid).get();
	}
	


}
