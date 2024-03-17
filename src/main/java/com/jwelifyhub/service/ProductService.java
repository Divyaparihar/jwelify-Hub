package com.jwelifyhub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwelifyhub.model.Products;
import com.jwelifyhub.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Products> getAllProduct() {
        return productRepository.findAll();
    }
	
	public void addProduct(Products product) {
		productRepository.save(product);
	}

	public void removeProductById(int id) {
		productRepository.deleteById(id);
	}
	
	public Optional<Products> getProductById(int id) {
		return productRepository.findById(id);
	}
	
	public List<Products> getAllProductByCategoryId(int id ){
		return productRepository.findAllByCategory_Id(id);
	}

}
