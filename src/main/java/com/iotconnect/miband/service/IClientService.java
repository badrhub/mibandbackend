package com.iotconnect.miband.service;

import java.util.List;

import com.iotconnect.miband.models.Client;
import com.iotconnect.miband.models.Heartbeat;

public interface IClientService {

	List<Client> update(String id, Client c);

	List<Client> add(Client c);

	List<Client> delete(String id);

	Client getById(String id);

	Client getByHeartbeat(Long id);

	List<Client> getAll();

	List<Heartbeat> getHeartbeatsByClient(String authid);

	Client getClientById(String authid);

}
