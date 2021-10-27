package com.dia.eauction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dia.eauction.dto.BidDto;
import com.dia.eauction.dto.BuyerDto;
import com.dia.eauction.dto.SellerDto;
import com.dia.eauction.exceptions.InvalidDataException;
import com.dia.eauction.service.BidService;
import com.dia.eauction.service.BuyerService;
import com.dia.eauction.service.ProductService;
import com.dia.eauction.service.SellerService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
	
	@Autowired
	private BidService bidService;
	
	@Autowired
	private BuyerService buyerService;
	
	@PostMapping("/place-bid")
	public ResponseEntity<BidDto> addBid(@Valid @RequestBody BidDto bidDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Bid data is not Valid!");
        }
		bidService.placeBid(bidDto);
		return ResponseEntity.ok(bidDto);
	}
	
	@PutMapping("/update-bid/{productId}/{buyerEmailld}/{newBidAmount}")
	public ResponseEntity<Boolean> updateBid(@PathVariable Long productId,@PathVariable String buyerEmailld,
			@PathVariable Double newBidAmount) {
		
		return ResponseEntity.ok(false);
	}
}
