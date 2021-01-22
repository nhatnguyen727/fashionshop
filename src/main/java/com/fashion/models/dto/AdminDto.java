package com.fashion.models.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonPropertyOrder("AdminID")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AdminDto{
	private int AdminID;
	private String Admin_name;
	private String Password;
	private RoleDto RoleID;
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	public String getAdmin_name() {
		return Admin_name;
	}
	public void setAdmin_name(String admin_name) {
		Admin_name = admin_name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public RoleDto getRoleID() {
		return RoleID;
	}
	public void setRoleID(RoleDto roleID) {
		RoleID = roleID;
	}
	
	
}
