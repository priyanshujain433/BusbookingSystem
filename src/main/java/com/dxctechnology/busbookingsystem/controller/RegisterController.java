package com.dxctechnology.busbookingsystem.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechnology.busbookingsystem.dto.UserDTO;
import com.dxctechnology.busbookingsystem.service.RegisterService;


@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@GetMapping("/register")
	public ModelAndView registerpage() {
		LOGGER.info("registerpage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@PostMapping("/save.do")
	public ModelAndView saveUserInfo(UserDTO dto) {
		LOGGER.info("saveUserInfo method invoked");
		ModelAndView modelAndView = new ModelAndView();
		if (registerService.validateAndSaveUser(dto)!=null) {
			modelAndView.setViewName("registrationsuccess");
			modelAndView.addObject("firstname", dto.getFirstName());
			modelAndView.addObject("lastname", dto.getLastName());
		} else {
			modelAndView.setViewName("register");
		}
		return modelAndView;
	}

	
	
	

}
