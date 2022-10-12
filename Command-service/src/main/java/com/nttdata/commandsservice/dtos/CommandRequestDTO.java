package com.nttdata.commandsservice.dtos;

import com.nttdata.commandsservice.enums.CommandType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CommandRequestDTO {
	private String id;
	private String productId;
	private int qte;
	private double price;
	private CommandType commandType;
}
