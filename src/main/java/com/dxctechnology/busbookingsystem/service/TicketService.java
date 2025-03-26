package com.dxctechnology.busbookingsystem.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechnology.busbookingsystem.dao.TicketDAO;
import com.dxctechnology.busbookingsystem.dto.PassangerDTO;
import com.dxctechnology.busbookingsystem.dto.TicketDTO;
import com.dxctechnology.busbookingsystem.entity.Ticket;
import com.dxctechnology.busbookingsystem.entity.User;
import com.dxctechnology.busbookingsystem.util.MailSenderUtil;

@Service
public class TicketService {
	private static final Logger LOGGER = LogManager.getLogger();
	@Autowired
	private TicketDAO impl;
	@Autowired
	private MailSenderUtil util;

	public Ticket validateAndSaveTicket(TicketDTO dto,HttpSession session) {
			LOGGER.info("validateAndSaveTicket method invoked");
			User user = (User) session.getAttribute("user");
			/*
			 * util.sendMail(user.getEmail(), "Hi " + user.getFirstName() + " " +
			 * user.getLastName() + " Thanks for Purchasing Ticket",
			 * "Success!. \n Ticket No: " + dto.getTicketid()+"\n Fare : " +
			 * dto.getTotalfare());
			 */
			Ticket ticket = new Ticket();
			ticket.setDate(LocalDate.parse(dto.getDate()));
			ticket.setDtime(LocalTime.parse(dto.getDtime()));
			String tickettime = dto.getTickettime();
			DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss z uuuu", Locale.ENGLISH);
			ticket.setTickettime(LocalDateTime.parse(tickettime, inputFormat));  
			BeanUtils.copyProperties(dto, ticket);
			impl.save(ticket);
			return ticket;
		}
	
	public boolean validatePickupAndDrop(PassangerDTO dto) {
		LOGGER.info("validatePassanger method invoked");
		if (Objects.nonNull(dto.getPickup()) && Objects.nonNull(dto.getDrop()) && !dto.getPickup().isEmpty()
				&& !dto.getDrop().isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
}
