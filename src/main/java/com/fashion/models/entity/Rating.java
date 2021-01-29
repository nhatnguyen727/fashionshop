package com.fashion.models.entity;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
	@Id
	@GeneratedValue
	private int id;
	private int star;
	@Column(columnDefinition = "nvarchar(255)")
	private String comment;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpro", foreignKey = @ForeignKey(name = "idpro"))
	private Product idpro;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iduser", foreignKey = @ForeignKey(name = "iduser"))
	private User iduser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Product getIdpro() {
		return idpro;
	}
	public void setIdpro(Product idpro) {
		this.idpro = idpro;
	}
	public User getIduser() {
		return iduser;
	}
	public void setIduser(User iduser) {
		this.iduser = iduser;
	}
	
	
}
