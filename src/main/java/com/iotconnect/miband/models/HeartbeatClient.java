package com.iotconnect.miband.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class HeartbeatClient {
	
	@NotNull
	private String auth_id;
	
	@NotNull
	private Integer value;
	
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss[.SSS]")
	private LocalDateTime date_prelevement;

	public String getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(String auth_id) {
		this.auth_id = auth_id;
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
	
	

}
