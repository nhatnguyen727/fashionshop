package com.fashion.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idpro", foreignKey = @ForeignKey(name = "idpro"))
	private Product idpro;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idord", foreignKey = @ForeignKey(name = "idord"))
	private Order idord;
	
	private int quantity;

	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}
