package com.nttdata.commandsservice.service;

import java.util.List;

import com.nttdata.commandsservice.dtos.CommandRequestDTO;
import com.nttdata.commandsservice.dtos.CommandResponseDTO;

public interface CommandService {
	/**
	 * get all command that exist in command database
	 * @return List<Product>
	 */
	public List<CommandResponseDTO> lisCommand();
	/**
	 * get Command by id from Command database
	 * @param id : String
	 * @return CommandResponseDTO
	 */
	public CommandResponseDTO getCommand(String id);
	/**
	 * add new Command to database
	 * @param Command : CommandRequestDTO
	 * @return CommandResponseDTO
	 */	
	public CommandResponseDTO newCommand(CommandRequestDTO command);
	/**
	 * get list of command by product Id
	 * @param productId : String
	 * @return CommandResponseDTO
	 */
	List<CommandResponseDTO> listCommandByProduct(String productId);
}
