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
import com.dxctechnology.busbookingsystem.entity.Route;
import com.dxctechnology.busbookingsystem.service.SearchRoutesService;


@Controller
public class SearchRoutesController {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	SearchRoutesService searchRoutesService;
	@Autowired
	RouteDAO routeDAO;
	@Autowired
	SubstationDAO substationDAO;
	
	@GetMapping("/searchroutes")
	public ModelAndView searchroutespage() {
		LOGGER.info("searchroutespage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchroutes");
		return modelAndView;
	}
	
	@GetMapping("/searchroute.do")
	public ModelAndView AvialableRoutesDetails(String from, String to, String date) {
		LOGGER.info("AvialableRoutesDetails method invoked");
		ModelAndView modelAndView = new ModelAndView();
		List<Route> routes = searchRoutesService.validateSearch(from, to, date);
		if(routes!=null && !routes.isEmpty()) {
			modelAndView.addObject("routes", routes);
			modelAndView.setViewName("searchresults");
		}else {
			String msg = "Sorry! No buses availble";
			modelAndView.setViewName("searchroutes");
			modelAndView.addObject("msg", msg);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "selectroute/{id}", method = RequestMethod.GET)
	public String selectedRouteDetails(@PathVariable int id, HttpSession session) {
		LOGGER.info("selectedRouteDetails method invoked");
		session.setAttribute("routeid", id);
		return "redirect:/bookticketpage";
	}

}
