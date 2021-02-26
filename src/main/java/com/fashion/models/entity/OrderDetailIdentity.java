package com.fashion.models.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Embeddable
public class OrderDetailIdentity implements Serializable {
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idpro", foreignKey = @ForeignKey(name = "idpro"))
	private Product idpro;
	
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idord", foreignKey = @ForeignKey(name = "idord"))
	private Order idord;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getIdpro() {
		return idpro;
	}

	public void setIdpro(Product idpro) {
		this.idpro = idpro;
	}

	public Order getIdord() {
		return idord;
	}

	public void setIdord(Order idord) {
		this.idord = idord;
	}

	
}
