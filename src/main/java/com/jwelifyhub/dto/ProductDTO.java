package com.jwelifyhub.dto;


import lombok.Data;


//it works as a holder or object

@Data
public class ProductDTO {

	private int id;
	private String name;
	private int categoryId; 
	private double price;
	private String description;
	private String imageName;
}
