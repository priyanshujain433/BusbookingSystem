package com.dxctechnology.busbookingsystem.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	private static final Logger LOGGER = LogManager.getLogger();

	@GetMapping("/home")
	public ModelAndView homepage() {
		LOGGER.info("homepage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	@GetMapping("/profile")
	public ModelAndView profilepage() {
		LOGGER.info("profilepage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("profile");
		return modelAndView;
	}


}
