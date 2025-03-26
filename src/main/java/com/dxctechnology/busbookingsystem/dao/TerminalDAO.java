package com.dxctechnology.busbookingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxctechnology.busbookingsystem.entity.Terminal;

@Repository
public interface TerminalDAO extends JpaRepository<Terminal, Integer>{
	

}
