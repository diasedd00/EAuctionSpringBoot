package com.dia.eauction.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "sellers")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long sellerId;
	@NotBlank
	@Length(min = 5, max = 30)
	private String firstName;
	@NotBlank
	@Length(min = 3, max = 25)
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String pinCode;
	@Email
	@NotBlank
	private String email;
	@NotNull
	@Min(1000000000)
	@Max(9999999999L)
	private Long phoneNumber;
}
