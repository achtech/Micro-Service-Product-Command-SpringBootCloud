package com.nttdata.commandsservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.commandsservice.entities.Command;

public interface CommandRepositories extends JpaRepository<Command, String>{
	List<Command> findByProductId(String productId);
}
