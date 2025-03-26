package com.dxctechnology.busbookingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dxctechnology.busbookingsystem.entity.Ticket;

@Repository
public interface TicketDAO extends JpaRepository<Ticket, Integer> {
	
	Ticket getByTicketid(String ticketid);
	
	List<Ticket> getByUserid(String userid);

	@Query("FROM Ticket WHERE date = (SELECT MAX(date) FROM Ticket WHERE userid = :userid) and tickettime = (SELECT MAX(tickettime) FROM Ticket WHERE userid = :userid)")
	Ticket getLatest(@Param(value = "userid") String userid);
}
