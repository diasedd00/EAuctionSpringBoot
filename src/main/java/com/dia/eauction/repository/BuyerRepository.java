package com.dia.eauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dia.eauction.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

	Buyer getBuyerByBuyerEmail(String buyerEmail); 
	
}
