package com.nttdata.commandsservice.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.nttdata.commandsservice.enums.CommandType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Command {
	@Id
	private String id;
	private String productId;
	private String qte;
	private double price;
	@Enumerated(EnumType.STRING)
	private CommandType commandType;
	@Transient
	private Product product;
}
