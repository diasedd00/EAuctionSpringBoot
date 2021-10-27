package com.dia.eauction.service;

import java.util.List;

import com.dia.eauction.dto.SellerDto;

public interface SellerService {

	public SellerDto registerSeller(SellerDto sellerDto);

	public SellerDto updateSeller(SellerDto sellerDto);

	public Boolean deleteSeller(Long sellerId);

	public SellerDto getSellerById(Long sellerId);

	public List<SellerDto> getAllSellers();

}
