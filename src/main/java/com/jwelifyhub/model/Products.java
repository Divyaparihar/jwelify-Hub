package com.jwelifyhub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Entity
@Data
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_id")
	private int id;
	
	@Column(name = "Product_Name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Category_id", referencedColumnName = "Category_id")
    private Category category;  //can't handle category object direct for that we have to create dto
	
	@Column(name = "Product_Price")
	private double price;
	
	@Column(name = "Product_Description")
	private String description;
	
	@Column(name = "Product_Image")
	private String imageName;
}
