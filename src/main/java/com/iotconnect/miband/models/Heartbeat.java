package com.iotconnect.miband.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Heartbeat {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Integer value;
	
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss[.SSS]")
	private LocalDateTime date_prelevement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public LocalDateTime getDate_prelevement() {
		return date_prelevement;
	}

	public void setDate_prelevement(LocalDateTime date_prelevement) {
		this.date_prelevement = date_prelevement;
	}
	
	@Override
	public String toString() {
		return "id: "+ id + " , value: " + value + " , date: ";
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(value) + 31 + Long.hashCode(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
	        return true;
	    if (!(o instanceof Heartbeat))
	        return false;
	    Heartbeat other = (Heartbeat)o;
	    boolean heartbeatCodeEquals = (this.id == null && other.id == null)
	      || (this.id != null && this.id.equals(other.id));
	    return this.value == other.value && heartbeatCodeEquals;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
