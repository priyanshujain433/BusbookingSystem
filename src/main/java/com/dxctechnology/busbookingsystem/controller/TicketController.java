package com.dxctechnology.busbookingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechnology.busbookingsystem.dao.RouteDAO;
import com.dxctechnology.busbookingsystem.dao.SubstationDAO;
import com.dxctechnology.busbookingsystem.dao.TicketDAO;
import com.dxctechnology.busbookingsystem.dto.PassangerDTO;
import com.dxctechnology.busbookingsystem.dto.TicketDTO;
import com.dxctechnology.busbookingsystem.entity.Route;
import com.dxctechnology.busbookingsystem.entity.SubStation;
import com.dxctechnology.busbookingsystem.entity.Ticket;
import com.dxctechnology.busbookingsystem.entity.User;
import com.dxctechnology.busbookingsystem.service.SearchRoutesService;
import com.dxctechnology.busbookingsystem.service.TicketService;


@Controller
public class TicketController {
	
	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	SearchRoutesService searchRoutesService;
	@Autowired
	RouteDAO routeDAO;
	@Autowired
	SubstationDAO substationDAO;
	@Autowired
	TicketService ticketService;
	@Autowired
	TicketDAO ticketDAO;

	@RequestMapping(value = "/bookticketpage", method = RequestMethod.GET)
	public ModelAndView bookticketpage(HttpSession session) {
		LOGGER.info("booktickectpage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		int id = (int) session.getAttribute("routeid");
		Route route = routeDAO.getByBusid(id);
		List<SubStation> pickup = substationDAO.getByTerminal(route.getOrigin());
		List<SubStation> drop = substationDAO.getByTerminal(route.getDestination());
		int fare = route.getFare();
		modelAndView.addObject("pickup", pickup);
		modelAndView.addObject("drop", drop);
		modelAndView.addObject("fare", fare);
		modelAndView.setViewName("bookticket");
		return modelAndView;
	}
	@RequestMapping(value = "/bookticket", method = RequestMethod.POST)
	public ModelAndView bookticket(PassangerDTO dto, HttpSession session) {
		LOGGER.info("bookticket method invoked");
		ModelAndView modelAndView = new ModelAndView();
		int id = (int) session.getAttribute("routeid");
		User user = (User) session.getAttribute("user");
		Route route = routeDAO.getByBusid(id);
		if(ticketService.validatePickupAndDrop(dto)) {
		modelAndView.setViewName("ticketpage");
		modelAndView.addObject("route", route);
		modelAndView.addObject("user", user);
		modelAndView.addObject("passanger", dto);
		}else {
			String msg = "Please select All Option";
			modelAndView.setViewName("bookticket");
			modelAndView.addObject("msg", msg);	
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/saveticket", method = RequestMethod.POST)
	public ModelAndView saveticket(TicketDTO dto, HttpSession session) {
		LOGGER.info("saveticket method invoked");
		ModelAndView modelAndView = new ModelAndView();
		Ticket ticket = ticketService.validateAndSaveTicket(dto, session);
		if(ticket!=null) {
			modelAndView.setViewName("Booking_success");
			session.setAttribute("userticket", ticket);		
		}else {
			modelAndView.setViewName("ticketpage");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/viewticket", method = RequestMethod.GET)
	public ModelAndView viewticket() {
		LOGGER.info("viewticket method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("printticketpage");
		return modelAndView;
	}
	
	@RequestMapping(value = "viewticket/{id}", method = RequestMethod.GET)
	public String viewticketInProfile(@PathVariable("id") String id, HttpSession session) {
		LOGGER.info("viewticketInProfile method invoked");
		Ticket ticket = ticketDAO.getByTicketid(id);
		session.setAttribute("uticket", ticket);
		return "redirect:/view";
	}
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(HttpSession session) {
		LOGGER.info("view method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("printticketpage");
		Ticket ticket1 = (Ticket) session.getAttribute("uticket");
		modelAndView.addObject("userticket", ticket1);
		return modelAndView;
	}
	@RequestMapping(value = "cancelticket/{id}", method = RequestMethod.GET)
	public String cancelticket(@PathVariable("id") String id) {
		LOGGER.info("cancelticket method invoked");
		Ticket ticket = ticketDAO.getByTicketid(id);
		System.out.println(ticket);
		ticketDAO.delete(ticket);
		return "redirect:/cancel";
	}
	
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public ModelAndView cancellationsuccesspage() {
		LOGGER.info("cancellationsuccesspage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cancellation_success");
		return modelAndView;
	}
	
	@GetMapping("/tickets")
	public ModelAndView allTicketDetails() {
		LOGGER.info("allTicketDetails method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("allticketdetails");
		List<Ticket> tickets = ticketDAO.findAll();
		modelAndView.addObject("tickets", tickets);
		return modelAndView;
	}
}
