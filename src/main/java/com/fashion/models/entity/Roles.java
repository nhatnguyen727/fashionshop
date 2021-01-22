package com.fashion.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
	@Id
	@GeneratedValue
	private int RoleID;
	
	private String Name;

	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
