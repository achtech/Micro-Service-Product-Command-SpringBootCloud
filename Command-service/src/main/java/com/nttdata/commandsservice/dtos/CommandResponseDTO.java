package com.nttdata.commandsservice.dtos;

import com.nttdata.commandsservice.entities.Product;
import com.nttdata.commandsservice.enums.CommandType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CommandResponseDTO {
	private String id;
	private String productId;
	private int qte;
	private double price;
	private CommandType commandType;
	private Product product;
}
