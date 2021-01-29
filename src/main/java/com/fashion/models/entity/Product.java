package com.fashion.models.entity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue
	private int id;
	@Column(columnDefinition = "nvarchar(255)")
	private String name;
	private double price_enter;
	private double price_sale;
	@Column(columnDefinition = "nvarchar(255)")
	private String unit;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idware", foreignKey = @ForeignKey(name = "idware"))
	private Warehouse idware;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddis", foreignKey = @ForeignKey(name = "iddis"))
	private Discount iddis;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcate", foreignKey = @ForeignKey(name = "idcate"))
	private Category idcate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsup", foreignKey = @ForeignKey(name = "idsup"))
	private Supplier idsup;
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
	public Warehouse getIdware() {
		return idware;
	}
	public void setIdware(Warehouse idware) {
		this.idware = idware;
	}
	public Discount getIddis() {
		return iddis;
	}
	public void setIddis(Discount iddis) {
		this.iddis = iddis;
	}
	public Category getIdcate() {
		return idcate;
	}
	public void setIdcate(Category idcate) {
		this.idcate = idcate;
	}
	public Supplier getIdsup() {
		return idsup;
	}
	public void setIdsup(Supplier idsup) {
		this.idsup = idsup;
	}
	
}
