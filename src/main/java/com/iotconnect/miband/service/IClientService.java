package com.iotconnect.miband.service;

import java.util.List;

import com.iotconnect.miband.models.Client;
import com.iotconnect.miband.models.Heartbeat;

public interface IClientService {

	Client update(Long id, Client c);

	Client add(Client c);

	Client delete(Long id);

	Client getByMac(String mac);

	Client getByHeartbeat(Long id);

	List<Client> getAll();

	List<Heartbeat> getHeartbeatsByClient(Long id);

	Client getClientById(Long id);

}
