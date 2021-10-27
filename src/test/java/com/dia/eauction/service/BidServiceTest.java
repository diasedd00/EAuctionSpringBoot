package com.dia.eauction.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.dia.eauction.repository.BidRepository;
import com.dia.eauction.repository.ProductRepository;
import com.dia.eauction.service.impl.BidServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BidServiceTest {
	
	  @Mock
	   private ProductRepository productRepository;
	  
	  @Mock
	  BidRepository bidRepository;
	  
	  @Autowired
	  @InjectMocks
	  private BidServiceImpl bidService;

}
