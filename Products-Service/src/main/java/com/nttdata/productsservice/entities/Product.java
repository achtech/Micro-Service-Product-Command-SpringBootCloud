/**
 * 
 */
package com.nttdata.productsservice.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.nttdata.productsservice.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author asaloumi
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	@Id
	private String id;
	private String label;
	private Double price;
	private Integer qte;
	@Enumerated(EnumType.STRING)
	private Category category;
}
