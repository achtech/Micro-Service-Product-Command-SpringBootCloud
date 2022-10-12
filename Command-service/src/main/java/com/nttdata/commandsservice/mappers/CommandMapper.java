package com.nttdata.commandsservice.mappers;

import org.mapstruct.Mapper;

import com.nttdata.commandsservice.dtos.CommandRequestDTO;
import com.nttdata.commandsservice.dtos.CommandResponseDTO;
import com.nttdata.commandsservice.entities.Command;

@Mapper(componentModel = "spring")
public interface CommandMapper {
	Command cmdReq2Cmd(CommandRequestDTO dto);
	Command cmdRes2Cmd(CommandResponseDTO dto);
	
	CommandRequestDTO cmd2CmdReq(Command cmd);
	CommandResponseDTO cmd2CmdRes(Command cmd);
	
}
