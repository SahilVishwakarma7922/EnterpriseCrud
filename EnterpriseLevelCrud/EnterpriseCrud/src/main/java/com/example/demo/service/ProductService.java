package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ProductDto;

public interface ProductService {

	
	public ProductDto saveProduct(ProductDto productDto);
	
	
	
	public List<ProductDto> getAllProduct();
	public Optional<ProductDto> getProductById(long id);
	public String updateProduct(long id,ProductDto productDto);
	public String deleteProduct(long id);
	
}
