package com.dia.eauction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

import com.dia.eauction.dto.BidDto;
import com.dia.eauction.entity.Bid;
import com.dia.eauction.entity.Seller;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {	

  List<Bid> getBidsByProductId(Long productId);
  List<Bid> findByProductIdOrderByBidAmountDesc(Long productId);
}
