package com.nttdata.productsservice.mappers;

import org.mapstruct.Mapper;

import com.nttdata.productsservice.dtos.ProductRequestDTO;
import com.nttdata.productsservice.dtos.ProductResponseDTO;
import com.nttdata.productsservice.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	Product productRequestDtoToProduct(ProductRequestDTO dto);
	Product productResponseDtoToProduct(ProductResponseDTO dto);
	ProductResponseDTO productToProductResponseDto(Product product);
	ProductRequestDTO productToProductRequestDto(Product product);
}
