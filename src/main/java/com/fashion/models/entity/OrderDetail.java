package com.fashion.models.entity;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdetail")
public class OrderDetail {
	@EmbeddedId
	OrderDetailIdentity detailIdentity;
	
	private int quantity;

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderDetailIdentity getDetailIdentity() {
		return detailIdentity;
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(OrderDetailIdentity detailIdentity, int quantity) {
		super();
		this.detailIdentity = detailIdentity;
		this.quantity = quantity;
	}

	public void setDetailIdentity(Product product) {
		// TODO Auto-generated method stub
		
	}
	public void setDetailIdentity(Order order) {
		// TODO Auto-generated method stub
		
	}

	public void setDetailIdentity(OrderDetailIdentity detailIdentity) {
		this.detailIdentity = detailIdentity;
	}

	public int getId() {
		return detailIdentity.getId();
	}

	public void setId(int id) {
		detailIdentity.setId(id);
	}

	public Product getIdpro() {
		return detailIdentity.getIdpro();
	}

	public void setIdpro(Product idpro) {
		detailIdentity.setIdpro(idpro);
	}

	public Order getIdord() {
		return detailIdentity.getIdord();
	}

	public void setIdord(Order idord) {
		detailIdentity.setIdord(idord);
	}

	public int hashCode() {
		return detailIdentity.hashCode();
	}

	public boolean equals(Object obj) {
		return detailIdentity.equals(obj);
	}

	public String toString() {
		return detailIdentity.toString();
	}



	
	

}
