package com.iotconnect.miband.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iotconnect.miband.models.Client;
import com.iotconnect.miband.models.Heartbeat;
import com.iotconnect.miband.service.IClientService;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
	
	private IClientService serviceClient;

	public ClientController(IClientService sc) {
		this.serviceClient = sc;
	}

	@PostMapping("/saveClient")
	public List<Client> saveClient(@RequestBody Client p) {
		return serviceClient.add(p);
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@PutMapping("/updateClient/{id}")
	public List<Client> updateClient(@PathVariable("id") String id, @RequestBody Client p) {
		return serviceClient.update(id, p);
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@GetMapping("/listClients")
	public List<Client> listClients() {
		return serviceClient.getAll();
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@DeleteMapping("/deleteClient/{id}")
	public List<Client> deleteClient(@PathVariable("id") String id) {
		return serviceClient.delete(id);
	}
	
	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@GetMapping("/getHeartbeatsByClient/{authid}")
	public List<Heartbeat> getHeartbeatsByClient(@PathVariable String authid) {
		return serviceClient.getHeartbeatsByClient(authid);
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	@GetMapping("/getClientById/{authid}")
	public Client getClientById(@PathVariable String authid) {
		return serviceClient.getClientById(authid);
	}

}
