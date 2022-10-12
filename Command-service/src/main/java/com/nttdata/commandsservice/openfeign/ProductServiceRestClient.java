package com.nttdata.commandsservice.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.nttdata.commandsservice.entities.Product;


@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductServiceRestClient {
	
	@GetMapping(path="/api/products/byId/{id}")
	Product productById(@PathVariable String id);
	
	@GetMapping(path="/api/products")
	List<Product> products();
	
	@PutMapping(path="/api/products/sale/{id}/{qte}")
	public void sale(@PathVariable(name="id") String id,@PathVariable(name="qte") int qte);
		
	@PutMapping(path="/api/products/purchase/{id}/{qte}")
	public void purchase(@PathVariable(name="id") String id,@PathVariable(name="qte") int qte);
}
