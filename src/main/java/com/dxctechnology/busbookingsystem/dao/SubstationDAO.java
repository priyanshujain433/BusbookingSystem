package com.dxctechnology.busbookingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxctechnology.busbookingsystem.entity.SubStation;

@Repository
public interface SubstationDAO extends JpaRepository<SubStation, Integer>{
	
	List<SubStation> getByTerminal(String terminal);
	void deleteByTerminal(String terminal);
}
