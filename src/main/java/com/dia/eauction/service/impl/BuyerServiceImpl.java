package com.dia.eauction.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dia.eauction.dto.BuyerDto;
import com.dia.eauction.entity.Buyer;
import com.dia.eauction.repository.BuyerRepository;
import com.dia.eauction.service.BuyerService;

@Service
public class BuyerServiceImpl implements BuyerService {
	
	@Autowired
	BuyerRepository buyerRepository;

	@Override
	public BuyerDto addBuyer(BuyerDto buyerDto) {
		Buyer buyer = new Buyer();
		BeanUtils.copyProperties(buyerDto, buyer);
		Buyer buyerSaved = buyerRepository.save(buyer);
		buyerDto.setBuyerId(buyerSaved.getBuyerId());
		return buyerDto;
	}

}
