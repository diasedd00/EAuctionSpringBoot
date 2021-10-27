package com.dia.eauction.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dia.eauction.dto.SellerDto;
import com.dia.eauction.entity.Product;
import com.dia.eauction.entity.Seller;
import com.dia.eauction.exceptions.SellerNotFoundException;
import com.dia.eauction.repository.SellerRepository;
import com.dia.eauction.service.SellerService;


@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public SellerDto registerSeller(SellerDto sellerDto) {
		Seller sellerEntity = new Seller();
		BeanUtils.copyProperties(sellerDto, sellerEntity);
		Seller seller = sellerRepository.save(sellerEntity);
		sellerDto.setSellerId(seller.getSellerId());
		return sellerDto;
	}
	
	@Override
	public SellerDto updateSeller(SellerDto sellerDto) {
		Seller sellerEntity = new Seller();
		BeanUtils.copyProperties(sellerDto, sellerEntity);
		sellerRepository.save(sellerEntity);
		return sellerDto;
	}

	@Override
	public Boolean deleteSeller(Long sellerId) {
        SellerDto sellerById =getSellerById(sellerId);
		Seller sellerEntity = new Seller();
		BeanUtils.copyProperties(sellerById, sellerEntity);
		sellerRepository.delete(sellerEntity);
		return true;	
    }
   

	@Override
	public SellerDto getSellerById(Long sellerId) {
		Optional<Seller> seller = sellerRepository.findById(sellerId);
		if (seller.isPresent()) {
			SellerDto sellerDto = new SellerDto();
			BeanUtils.copyProperties(seller.get(), sellerDto);
			return sellerDto;
		} else {
			throw new SellerNotFoundException("Seller with id " + sellerId + " does not exists");
		}
	}

	@Override
	public List<SellerDto> getAllSellers() {
		List<Seller> sellers = sellerRepository.findAll();
		List<SellerDto> sellerDtos = new ArrayList<>();
		for (Seller entity : sellers) {
			SellerDto sellerDto = new SellerDto();
            BeanUtils.copyProperties(entity, sellerDto);
            sellerDtos.add(sellerDto);			
		}
		return sellerDtos;
	}
}
