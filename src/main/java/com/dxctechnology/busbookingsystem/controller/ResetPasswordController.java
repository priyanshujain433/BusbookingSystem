package com.dxctechnology.busbookingsystem.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechnology.busbookingsystem.dto.ResetPasswordDTO;
import com.dxctechnology.busbookingsystem.service.ResetPasswordService;

@Controller
public class ResetPasswordController {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	ResetPasswordService resetPasswordService;
	
	@GetMapping("/sendotp")
	public ModelAndView getotppage() {
		LOGGER.info("getotppage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sendotp");
		return modelAndView;
	}

	
	@PostMapping("/sendotp.do")
	public ModelAndView sendOTP(String email, String username, HttpSession session) {
		LOGGER.info("sendOTP method invoked");
		ModelAndView modelAndView = new ModelAndView();
		String otp = resetPasswordService.validateAndSendOTP(email);
		if (otp != null) {
			session.setAttribute(email, otp);
			modelAndView.addObject("email", email);
			modelAndView.setViewName("resetpassword");
		} else {
			String msg = "Entered Email is invalid";
			modelAndView.setViewName("sendotp");
			modelAndView.addObject("msg", msg);
		}
		return modelAndView;
	}
	
	@PostMapping("/reset.do")
	public ModelAndView resetPassword(ResetPasswordDTO dto, HttpSession session) {
		LOGGER.info("resetPassword method invoked");
		String sessionOtp = (String)session.getAttribute(dto.getEmail());
		ModelAndView modelAndView = new ModelAndView();
		if (resetPasswordService.validateOTP(dto, sessionOtp)) {
			modelAndView.setViewName("PasswordResetSuccess");
		} else {
			String msg = "OTP is incorrect";
			modelAndView.setViewName("resetpassword");
			modelAndView.addObject("msg", msg);
		}
		return modelAndView;
	}

}
