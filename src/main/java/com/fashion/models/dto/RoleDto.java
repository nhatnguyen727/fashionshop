package com.fashion.models.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonPropertyOrder("RoleID")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class RoleDto {
	private int RoleID;
	private String Name;
	public int getRoleID() {
		return RoleID;
	}
	public void setRoleID(int roleID) {
		RoleID = roleID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
