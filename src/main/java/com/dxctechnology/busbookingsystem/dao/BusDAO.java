package com.dxctechnology.busbookingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxctechnology.busbookingsystem.entity.Bus;

@Repository
public interface BusDAO extends JpaRepository<Bus, Integer>{
	
}
