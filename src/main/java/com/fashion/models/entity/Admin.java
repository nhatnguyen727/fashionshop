package com.fashion.models.entity;
import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue
	private int AdminID;
	private String Admin_name;
	private String Password;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_pk", foreignKey = @ForeignKey(name = "role_pk"))
	private Roles RoleID;
	
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
	public Roles getRoleID() {
		return RoleID;
	}
	public void setRoleID(Roles roleID) {
		RoleID = roleID;
	}
	
	
}
