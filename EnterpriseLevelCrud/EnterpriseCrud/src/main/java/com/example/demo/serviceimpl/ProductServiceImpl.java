package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	
	
	
	
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public ProductDto saveProduct(ProductDto productDto) {
		
		Product product=productMapper.toEntity(productDto);
		Product product2=productRepository.save(product);
		ProductDto productDto2= productMapper.toDto(product2);
		return productDto2;
	}

	
	
	
//to get all product	
	
	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> products=productRepository.findAll();
		List<ProductDto> dtos=products.stream().map((pro)-> productMapper.toDto(pro)).collect(Collectors.toList());
		return dtos;
	}

	
	
	
	@Override
	public Optional<ProductDto> getProductById(long id) {
		// TODO Auto-generated method stub
		
		Optional<Product> product=productRepository.findById(id);
		Optional<ProductDto> products=product.map((pro)->productMapper.toDto(pro));
		return products;
	}

	@Override
	public String updateProduct(long id, ProductDto productDto) {
		if (productRepository.existsById(id)) {
			Product product=productMapper.toEntity(productDto);
			product.setId(id);
			productRepository.save(product);
			return "succesfully updated the product with id "+id;
		}
	return "product not available with id "+id;

	}

	@Override
	public String deleteProduct(long id) {

		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return "succesfully deleted the product with id "+id;
		}
		return "no product available with id "+id;
	}

}
