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
	public Client update(Long id, Client c) {
	  Client old = clientRepository.findById(id).get();
	  old.setNom(c.getNom());
	  old.setPrenom(c.getPrenom());	
	  old.setAdresse(c.getAdresse());
	  old.setMail(c.getMail());
	  old.setTel(c.getTel());
	  if(c.getMac() != null ) {
		  old.setMac(c.getMac());
	  }
	  return clientRepository.save(old);
	}

	@Override
	public Client add(Client c) {
		return  clientRepository.save(c);
	}

	@Override
	public Client delete(Long id) {
		Client old = clientRepository.findById(id).get();
	    clientRepository.delete(old);
	    return old;
	}

	@Override
	public Client getByMac(String mac) {
		return clientRepository.findByMac(mac);
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
	public List<Heartbeat> getHeartbeatsByClient(Long id) {
		if(id != null) {
			Client c = clientRepository.findById(id).get();
			if(c != null) {
				return c.getHeartbeats();
			}
		}
		return null;
	}

	@Override
	public Client getClientById(Long id) {
		return clientRepository.findById(id).get();
	}

}
