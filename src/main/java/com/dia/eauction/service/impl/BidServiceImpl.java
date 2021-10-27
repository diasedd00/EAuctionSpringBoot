package com.dia.eauction.service.impl;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dia.eauction.dto.BidDto;
import com.dia.eauction.entity.Bid;
import com.dia.eauction.entity.Buyer;
import com.dia.eauction.entity.Product;
import com.dia.eauction.exceptions.CannotDeleteProductException;
import com.dia.eauction.exceptions.DuplicateBidException;
import com.dia.eauction.exceptions.ProductNotFoundException;
import com.dia.eauction.repository.BidRepository;
import com.dia.eauction.repository.ProductRepository;
import com.dia.eauction.service.BidService;
import com.dia.eauction.utils.Utilities;

@Service
public class BidServiceImpl implements BidService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BidRepository bidRepository;

	@Override
	public BidDto placeBid(BidDto bidDto) {
		Long productId =bidDto.getProductId();
		Optional<Product> product = productRepository.findById(productId);
		List<Bid> bidsList = bidRepository.getBidsByProductId(productId);
		String bidEmail = bidDto.getBuyer().getBuyerEmail();
		for (Bid b: bidsList) {
			if (b.getBuyer().getBuyerEmail().contains(bidEmail)) {
				throw new DuplicateBidException("Email "+bidEmail+" has an active bid for Product Id "+productId+".Cannot place bid.");
			}
		}
		if (product.isEmpty()) {
			throw new ProductNotFoundException("Product ID "+bidDto.getProductId()+" is not found");
		} else {
			LocalDate bidEnddate = product.get().getBidEnddate();
			String date = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now()));
			LocalDate currentdate = LocalDate.parse(date);			
			int currentDateShouldBeLessThanBidEndDate = Utilities.compareDates(currentdate, bidEnddate);			
			if (currentDateShouldBeLessThanBidEndDate>0) {
				throw new CannotDeleteProductException("Cannot bid for Product after bid end date");
			}		
			Bid bid = new Bid();
			BeanUtils.copyProperties(bidDto, bid);
			Bid bidSaved = bidRepository.save(bid);
			
			bidDto.setId(bidSaved.getBidId());
			return bidDto;
		}
	}

	@Override
	public List<Bid> getAllBidsOnProductById(Long productId) {	
		return bidRepository.findByProductIdOrderByBidAmountDesc(productId);
	}
	
	

}
