package com.fashion.models.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor

@JsonPropertyOrder("AdminID")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AdminDto{
	private int id;
	private String name;
	private String password;
	
	private RoleDto idrole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDto getIdrole() {
		return idrole;
	}

	public void setIdrole(RoleDto idrole) {
		this.idrole = idrole;
	}

	
	

	
}
