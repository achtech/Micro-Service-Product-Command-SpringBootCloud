package com.nttdata.productsservice.dtos;

import com.nttdata.productsservice.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
	private String id;
	private String label;
	private double price;
	private int qte;
	private Category category;
}
