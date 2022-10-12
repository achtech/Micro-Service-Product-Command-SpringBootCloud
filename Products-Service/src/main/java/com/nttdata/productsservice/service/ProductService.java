package com.nttdata.productsservice.service;

import java.util.List;

import com.nttdata.productsservice.dtos.ProductRequestDTO;
import com.nttdata.productsservice.dtos.ProductResponseDTO;
import com.nttdata.productsservice.entities.Product;

public interface ProductService {
	public List<ProductResponseDTO> findAll();
	
	public ProductResponseDTO findById(String id);
	
	public ProductResponseDTO save(ProductRequestDTO product);
	
	public ProductResponseDTO update(String id, ProductRequestDTO product);
	
	public Product getProductById(String code);
	
	public void deleteById(String id);
	
	public void purchase(String id,int qte);
	
	public void sale(String id,int qte);
	
}
