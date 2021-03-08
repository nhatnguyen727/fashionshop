package com.fashion.models.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idrole", foreignKey = @ForeignKey(name = "idrole"))
	private Role idrole;
	
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
	public Role getIdrole() {
		return idrole;
	}
	public void setIdrole(Role idrole) {
		this.idrole = idrole;
	}
	
	
	
}
