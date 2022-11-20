package com.iotconnect.miband.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
	
	@Id
	private String id;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true )
	private List<Heartbeat> heartbeats = new ArrayList<>();
	
	public void addHeartbeat(Heartbeat heartbeat) {
		heartbeats.add(heartbeat);
		heartbeat.setClient(this);
    }
 
    public void removeHeartbeat(Heartbeat heartbeat) {
    	heartbeats.remove(heartbeat);
    	heartbeat.setClient(null);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id: "+ id + " , name: " + name ;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + 31 + id.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
	        return true;
	    if (!(o instanceof Client))
	        return false;
	    Client other = (Client)o;
	    boolean clientCodeEquals = (this.id == null && other.id == null)
	      || (this.id != null && this.id.equals(other.id));
	    return this.name.equals(other.name) && clientCodeEquals;
	}

	public List<Heartbeat> getHeartbeats() {
		return heartbeats;
	}

	public void setHeartbeats(List<Heartbeat> heartbeats) {
		this.heartbeats = heartbeats;
	}
	
	

}
