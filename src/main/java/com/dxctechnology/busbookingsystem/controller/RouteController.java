package com.dxctechnology.busbookingsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechnology.busbookingsystem.dao.BusDAO;
import com.dxctechnology.busbookingsystem.dao.RouteDAO;
import com.dxctechnology.busbookingsystem.dao.TerminalDAO;
import com.dxctechnology.busbookingsystem.dto.RouteDTO;
import com.dxctechnology.busbookingsystem.entity.Bus;
import com.dxctechnology.busbookingsystem.entity.Route;
import com.dxctechnology.busbookingsystem.entity.Terminal;
import com.dxctechnology.busbookingsystem.service.RouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class RouteController {

	@Autowired
	RouteService routeService;
	@Autowired
	RouteDAO routeDAO;
	@Autowired
	BusDAO busDAO;
	@Autowired
	TerminalDAO terminalDAO;

	private static final Logger LOGGER = LogManager.getLogger();

	@GetMapping("/route")
	public ModelAndView allRouteDetails() {
		LOGGER.info("allRouteDetails method invoked");
		ModelAndView modelAndView = new ModelAndView();
		List<Route> routes = routeDAO.findAll();
		modelAndView.addObject("routes", routes);
		modelAndView.setViewName("routes");
		return modelAndView;
	}

	@GetMapping("/addroute")
	public ModelAndView addroutepage() {
		LOGGER.info("addroutepage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		List<Bus> buses = busDAO.findAll();
		List<Terminal> terminals = terminalDAO.findAll();
		modelAndView.addObject("terminals", terminals);
		modelAndView.addObject("buses", buses);
		modelAndView.setViewName("addroute");
		return modelAndView;
	}
	
	@GetMapping("loadbusinfo/{id}")
	@ResponseBody
	public String loadbusinfo(@PathVariable("id") int busid) throws JsonProcessingException {
		LOGGER.info("loadbusinfo method invoked");
		Bus bus = busDAO.findById(busid).get();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(bus); 
		return json;
	}

	@PostMapping("/saveroute.do")
	public ModelAndView saveRouteInfo(RouteDTO dto) {

		LOGGER.info("saveRouteInfo method invoked");
		ModelAndView modelAndView = new ModelAndView();
		  if (routeService.validateAndSaveRoute(dto) != null) {
		  modelAndView.setViewName("route_success");
		  } else {
			  modelAndView.setViewName("addroute");
		  }
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteroute/{id}", method = RequestMethod.GET)
	public String deleteroue(@PathVariable("id") int id) {
		LOGGER.info("deleteroute method invoked");
		routeService.delete(id);
		return "redirect:/route";
	}
	@RequestMapping(value = "selectbus/{id}", method = RequestMethod.GET)
	public String selectBus(@PathVariable("id") int id, ModelMap model) {
		LOGGER.info("selectBus method invoked");
		Bus bus = busDAO.getById(id);
		model.addAttribute("bus", bus);
		return "redirect:/route";
	}

}
