package com.nttdata.commandsservice.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nttdata.commandsservice.dtos.CommandRequestDTO;
import com.nttdata.commandsservice.dtos.CommandResponseDTO;
import com.nttdata.commandsservice.mappers.CommandMapper;
import com.nttdata.commandsservice.openfeign.ProductServiceRestClient;
import com.nttdata.commandsservice.repositories.CommandRepositories;
import com.nttdata.commandsservice.service.CommandService;
import com.nttdata.commandsservice.entities.Command;
import com.nttdata.commandsservice.entities.Product;
import com.nttdata.commandsservice.enums.CommandType;

@Service
@Transactional
public class CommandServiceImp implements CommandService{
	private final CommandRepositories repository;
	private final CommandMapper mapper;
	private final ProductServiceRestClient productService;
	
	public CommandServiceImp(CommandRepositories repositories, CommandMapper mapper
			,ProductServiceRestClient productService
			) {
		super();
		this.repository = repositories;
		this.mapper = mapper;
		this.productService = productService;
	}

	@Override
	public List<CommandResponseDTO> lisCommand() {
		List<Command> commands= repository.findAll();
		List<CommandResponseDTO> list = commands.stream()
				.map(p->mapper.cmd2CmdRes(p))
				.collect(Collectors.toList());
		list.forEach(cmd->{
			cmd.setProduct(productService.productById(cmd.getProductId()));
		});
		return list;
	}

	@Override
	public List<CommandResponseDTO> listCommandByProduct(String productId) {
		List<Command> commands= repository.findByProductId(productId);
		List<CommandResponseDTO> list = commands.stream()
				.map(p->mapper.cmd2CmdRes(p))
				.collect(Collectors.toList());
		list.forEach(cmd->{
			cmd.setProduct(productService.productById(cmd.getProductId()));
		});
		return list;
	}

	@Override
	public CommandResponseDTO getCommand(String id) {
		Command cmd = repository.findById(id).get();
		Product product = productService.productById(cmd.getProductId());
		cmd.setProduct(product);
		return mapper.cmd2CmdRes(cmd);
	}

	@Override
	public CommandResponseDTO newCommand(CommandRequestDTO request) {
		
		Product product = productService.productById(request.getProductId());
		Command cmd = mapper.cmdReq2Cmd(request);
		cmd.setId(UUID.randomUUID().toString());
		cmd.setPrice(product.getPrice()*request.getQte());
		Command savedCommand=  repository.save(cmd);
		savedCommand.setProduct(product);
		
		if(savedCommand!= null && savedCommand.getId() != null) {
			int newQte=0;
			if(CommandType.SALE.equals(savedCommand.getCommandType())) {
				productService.sale(request.getProductId(),request.getQte());
				newQte = savedCommand.getProduct().getQte()-request.getQte();
			} else {
				productService.purchase(request.getProductId(),request.getQte());
				newQte = savedCommand.getProduct().getQte()+request.getQte();
			}
			savedCommand.getProduct().setQte(newQte);
		}
		return mapper.cmd2CmdRes(savedCommand);
	}

}
