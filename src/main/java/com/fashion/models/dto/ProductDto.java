package com.fashion.models.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder("ProductID")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	private int id;
	private WarehouseDto idware;
	private DiscountDto iddis;
	private CategoryDto idcate;
	private SupplierDto idsup;
	private String name;
	private double price_enter;
	private double price_sale;
	private String unit;

	@JsonCreator
	public ProductDto(@JsonProperty("id_pro") int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WarehouseDto getIdware() {
		return idware;
	}

	public void setIdware(WarehouseDto idware) {
		this.idware = idware;
	}

	public DiscountDto getIddis() {
		return iddis;
	}

	public void setIddis(DiscountDto iddis) {
		this.iddis = iddis;
	}

	public CategoryDto getIdcate() {
		return idcate;
	}

	public void setIdcate(CategoryDto idcate) {
		this.idcate = idcate;
	}

	public SupplierDto getIdsup() {
		return idsup;
	}

	public void setIdsup(SupplierDto idsup) {
		this.idsup = idsup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice_enter() {
		return price_enter;
	}

	public void setPrice_enter(double price_enter) {
		this.price_enter = price_enter;
	}

	

	public double getPrice_sale() {
		return price_sale;
	}

	public void setPrice_sale(double price_sale) {
		this.price_sale = price_sale;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	

}
