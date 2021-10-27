package com.dia.eauction.dto;

import com.dia.eauction.entity.Buyer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BidDto {
	private Long id;
	private Double bidAmount;
	private Long productId;
	private Buyer buyer;
}
