package com.fashion.models.dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonPropertyOrder("OrDetailID")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
	private int id;
	private OrderDto idord;
	
	private ProductDto idpro;
	
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderDto getIdord() {
		return idord;
	}

	public void setIdord(OrderDto idord) {
		this.idord = idord;
	}

	public ProductDto getIdpro() {
		return idpro;
	}

	public void setIdpro(ProductDto idpro) {
		this.idpro = idpro;
	}
	
	
}
