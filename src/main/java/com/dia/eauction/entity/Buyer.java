package com.dia.eauction.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "buyers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="buyer")
	@JsonIgnore
	private Set<Bid> bids = new HashSet<>();
}
