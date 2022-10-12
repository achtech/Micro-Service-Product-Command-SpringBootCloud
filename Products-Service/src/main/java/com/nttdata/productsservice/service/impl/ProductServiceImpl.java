package com.nttdata.productsservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nttdata.productsservice.dtos.ProductRequestDTO;
import com.nttdata.productsservice.dtos.ProductResponseDTO;
import com.nttdata.productsservice.entities.Product;
import com.nttdata.productsservice.mappers.ProductMapper;
import com.nttdata.productsservice.repositories.ProductRepository;
import com.nttdata.productsservice.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	private static final String SALES = "SALES";
	private static final String PURCHASE = "PUCHASE";
	ProductRepository productRepository;
	ProductMapper productMapper;
	
	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		super();
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	public List<ProductResponseDTO> findAll() {
		List<Product> products= productRepository.findAll();
		List<ProductResponseDTO> list = products.stream()
				.map(p->productMapper.productToProductResponseDto(p))
				.collect(Collectors.toList());
		return list;
	}

	public ProductResponseDTO findById(String id) {
		Product product = productRepository.findById(id).get();
		return productMapper.productToProductResponseDto(product);
	}

	public ProductResponseDTO save(ProductRequestDTO productRequest) {
		Product product  = productMapper.productRequestDtoToProduct(productRequest);
		Product savedProduct = productRepository.save(product);
		return productMapper.productToProductResponseDto(savedProduct);
	}

	public ProductResponseDTO update(String id, ProductRequestDTO productRequest) {
		ProductResponseDTO productResponse = findById(id);
		Product product = productMapper.productResponseDtoToProduct(productResponse);
		if (productRequest.getCategory() != null)
			product.setCategory(productRequest.getCategory());
		if (productRequest.getLabel() != null)
			product.setLabel(productRequest.getLabel());
		if (productRequest.getPrice() != null)
			product.setPrice(productRequest.getPrice());
		if (productRequest.getQte() != null)
			product.setQte(productRequest.getQte());
		Product savedProduct = productRepository.save(product);
		return productMapper.productToProductResponseDto(savedProduct);
	}

	public void deleteById(String id) {
		productRepository.deleteById(id);
	}
	
	public void updateQte(String id,int qte, String type)
	{
		Product product = productMapper.productResponseDtoToProduct(this.findById(id));
		if(SALES.equals(type)){
			product.setQte(product.getQte()-qte);
		} else {
			product.setQte(product.getQte()+qte);
		}
		productRepository.save(product);
	}

	@Override
	public Product getProductById(String code) {return productRepository.findById(code).get();}

	@Override
	public void purchase(String id, int qte) { this.updateQte(id, qte, PURCHASE);}

	@Override
	public void sale(String id, int qte) { this.updateQte(id, qte, SALES);}
}
