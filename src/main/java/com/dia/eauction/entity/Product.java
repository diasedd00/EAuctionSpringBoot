package com.dia.eauction.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="products")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;  
	@NotNull
	@Length(min = 3, max = 30)
    private String productName;     
    private String shortDescription;    
    private String detailedDescription;   
    @Pattern(regexp = "Painting|Sculptor|Ornament", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String category;
    @Digits(fraction = 0, integer = 10)
    private BigDecimal startingPrice;
    @Future
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate bidEnddate; 
    
    @ManyToOne(cascade = CascadeType.ALL,targetEntity=Seller.class)
    @JoinColumn(name="sellerId",referencedColumnName="sellerId")
    private Seller seller; 
    
}
