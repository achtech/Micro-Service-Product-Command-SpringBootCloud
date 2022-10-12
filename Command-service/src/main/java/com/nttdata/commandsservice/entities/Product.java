package com.nttdata.commandsservice.entities;

import com.nttdata.commandsservice.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author asaloumi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private String id;
	private String label;
	private Double price;
	private Integer qte;
	private Category category;
}
