package com.dia.eauction.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuyerDto {	
	
	private Long buyerId;
	@NotBlank
	@Length(min = 5, max = 30)
	private String buyerFirstName;
	@NotBlank
	@Length(min = 5, max = 25)
	private String buyerLastName;
	private String buyerAddress;
	private String buyerCity;
	private String buyerState;
	private String buyerPinCode;
	@Email
	@NotBlank
	private String buyerEmail;
	@NotNull
	@Min(1000000000)
	@Max(9999999999L)
	private Long buyerPhoneNumber;
	
}