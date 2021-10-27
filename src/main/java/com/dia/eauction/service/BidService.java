package com.dia.eauction.service;

import java.util.List;

import com.dia.eauction.dto.BidDto;
import com.dia.eauction.entity.Bid;

public interface BidService {	

	public BidDto placeBid(BidDto bidDto);
	public List<Bid> getAllBidsOnProductById(Long productId);	
}
