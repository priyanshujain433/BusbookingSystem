package com.dxctechnology.busbookingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechnology.busbookingsystem.dao.TicketDAO;
import com.dxctechnology.busbookingsystem.entity.Ticket;
import com.dxctechnology.busbookingsystem.entity.User;
import com.dxctechnology.busbookingsystem.service.LoginService;


@Controller
public class LoginController {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	LoginService loginService;
	@Autowired
	TicketDAO ticketDAO;
	
	@GetMapping("/signin")
	public ModelAndView loginpage() {
		LOGGER.info("loginpage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@PostMapping("/signin.do")
	public ModelAndView validateUserlogin(String password, String email, HttpSession session) {
		LOGGER.info("validateUserlogin method invoked");
	
		ModelAndView modelAndView = new ModelAndView();
			User validUser = loginService.validateUser(email, password);
			session.setAttribute("user", validUser);
			if (validUser != null) {
				Ticket ticket = ticketDAO.getLatest(validUser.getEmail());
				session.setAttribute("ticket", ticket);
				modelAndView.setViewName("home");
			}else if (loginService.validateAdmin(email, password)) {
				modelAndView.setViewName("admin");
			}else {
				String msg = "Username or Password is incorrect";
				modelAndView.setViewName("login");
				modelAndView.addObject("msg", msg);	
			}
			return modelAndView;
	}
	
	@GetMapping("/tripdetails")
	public ModelAndView allTripDetails(HttpSession session) {
		LOGGER.info("allTripDetails method invoked");
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		List<Ticket> tickets = ticketDAO.getByUserid(user.getEmail());
		modelAndView.setViewName("userticketdetails");
		modelAndView.addObject("tickets", tickets);
		return modelAndView;
	}

}
