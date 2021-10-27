package com.dia.eauction.service;

import java.util.List;

import com.dia.eauction.dto.ProductDto;

public interface ProductService {
	
	public ProductDto addProduct(ProductDto productDto);
	public ProductDto getProductById(Long productId);
	public List<ProductDto> getAllProducts();
	boolean deleteProduct(Long productId);

}
