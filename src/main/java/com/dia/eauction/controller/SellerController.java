package com.dia.eauction.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dia.eauction.dto.BidDto;
import com.dia.eauction.dto.ProductDto;
import com.dia.eauction.entity.Bid;
import com.dia.eauction.exceptions.InvalidDataException;
import com.dia.eauction.service.BidService;
import com.dia.eauction.service.ProductService;


@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private BidService bidService;

	@PostMapping("/add-product")
	public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Product data is invalid");
        }
		productService.addProduct(productDto);
		return ResponseEntity.ok(productDto);
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable Long productId) {		
		productService.deleteProduct(productId);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/show-bids/{productId}")
	public ResponseEntity<List<Bid>> showBids(@PathVariable Long productId) {
		List<Bid> bidsList = bidService.getAllBidsOnProductById(productId);		
		return ResponseEntity.ok(bidsList);
	}	
	
	
	@GetMapping("/fetch-products")
	public ResponseEntity<List<ProductDto>> fetchProducts() {		
		return ResponseEntity.ok(productService.getAllProducts());
	}

}
