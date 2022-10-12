package com.nttdata.commandsservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.commandsservice.dtos.CommandRequestDTO;
import com.nttdata.commandsservice.dtos.CommandResponseDTO;
import com.nttdata.commandsservice.service.CommandService;

@RestController
@RequestMapping(path="/api")
public class CommandRestController {
	private CommandService service;
	
	public CommandRestController(CommandService service) {
		this.service = service;
	}
	
	@GetMapping(path="/commands")
	public List<CommandResponseDTO> lisCommand(){
		return service.lisCommand();
	}
	
	@GetMapping(path="/commands/{id}")
	public CommandResponseDTO getCommand(@PathVariable String id) {
		return service.getCommand(id);
	}
	
	@PostMapping(path="/commands")
	public CommandResponseDTO newCommand(@RequestBody CommandRequestDTO command) {
		return service.newCommand(command);
	}
}
