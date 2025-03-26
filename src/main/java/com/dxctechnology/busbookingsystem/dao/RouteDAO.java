package com.dxctechnology.busbookingsystem.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dxctechnology.busbookingsystem.entity.Route;

@Repository
public interface RouteDAO extends JpaRepository<Route, Integer>{

	Route getByBusid(int id);
	
	Route getByOrigin(String origin);
	
	Route getByDestination(String destination);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Route WHERE origin = :terminal OR destination = :terminal")
	void deleteByTerminal(@Param(value = "terminal") String terminal);
	
	@Query("from Route WHERE origin = :from and destination= :to and dateoftravel=:date")
    List<Route> getByDestinationOriginAndDate(@Param(value = "from") String from, @Param("to") String to,@Param("date") LocalDate date);
}
