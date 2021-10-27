package com.dia.eauction.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.dia.eauction.entity.Seller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
	
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
    
    private Seller seller;
}
