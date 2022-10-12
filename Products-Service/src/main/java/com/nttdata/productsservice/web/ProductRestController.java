package com.nttdata.productsservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nttdata.productsservice.dtos.ProductRequestDTO;
import com.nttdata.productsservice.dtos.ProductResponseDTO;
import com.nttdata.productsservice.entities.Product;
import com.nttdata.productsservice.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	private ProductService productService;
	
	ProductRestController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(path="/products")
	public List<ProductResponseDTO> findAll(){
		return this.productService.findAll();
	}
	
	@GetMapping(path="/products/{id}")
	public ProductResponseDTO getProduct(@PathVariable(name="id") String code){
		return this.productService.findById(code);
	}
	
	@GetMapping(path="/products/byId/{id}")
	public Product getProductById(@PathVariable(name="id") String code){
		return this.productService.getProductById(code);
	}
	@PostMapping(path="/products")
	public ProductResponseDTO save(@RequestBody ProductRequestDTO productRequest){
		return this.productService.save(productRequest);
	}
	
	@PutMapping(path="/products/{id}")
	public ProductResponseDTO update(@PathVariable(name="id") String id, 
			@RequestBody ProductRequestDTO productRequest){
		return this.productService.update(id,productRequest);
	}
	
	@DeleteMapping(path="/products/{id}")
	public void delete(@PathVariable(name="id") String code){
		this.productService.deleteById(code);
	}

	@PutMapping(path="/products/purchase/{id}/{qte}")
	public void purchase(@PathVariable(name="id") String id,@PathVariable(name="qte") int qte){
		this.productService.purchase(id, qte);
	}
	@PutMapping(path="/products/sale/{id}/{qte}")
	public void sale(@PathVariable(name="id") String id,@PathVariable(name="qte") int qte){
		this.productService.sale(id, qte);
	}

}
