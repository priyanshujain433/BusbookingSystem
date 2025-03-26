package com.dxctechnology.busbookingsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechnology.busbookingsystem.dao.BusDAO;
import com.dxctechnology.busbookingsystem.dao.RouteDAO;
import com.dxctechnology.busbookingsystem.dto.BusDTO;
import com.dxctechnology.busbookingsystem.entity.Bus;
import com.dxctechnology.busbookingsystem.service.BusService;
import com.dxctechnology.busbookingsystem.service.RouteService;


@Controller
public class BusController {

	@Autowired
	BusService busService;
	
	@Autowired
	BusDAO busDAO;
	
	@Autowired
	RouteService routeService;
	@Autowired
	RouteDAO routeDAO;
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@GetMapping("/busdetail")
	public ModelAndView allBusDetails() {
		LOGGER.info("allBusDetails method invoked");
		ModelAndView modelAndView = new ModelAndView();
		List<Bus> buses = busDAO.findAll();
		modelAndView.addObject("buses", buses);
		modelAndView.setViewName("bus");
		return modelAndView;
	}
	@GetMapping("/addbus")
	public ModelAndView addbuspage() {
		LOGGER.info("addbuspage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addbus");
		return modelAndView;
	}
	
	@GetMapping("/admin")
	public ModelAndView adminpage() {
		LOGGER.info("adminpage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	
	@PostMapping("/savebus.do")
	public ModelAndView saveBusInfo(BusDTO dto) {
		
		LOGGER.info("saveBusInfo method invoked");

		ModelAndView modelAndView = new ModelAndView();
		if (busService.validateAndSaveBus(dto)!=null) {
			modelAndView.setViewName("addbus_success");
			modelAndView.addObject("regno", dto.getRegno());
		} else {
			modelAndView.setViewName("addbus");
		}
		return modelAndView;
	}

	@RequestMapping(value = "deletebus/{id}", method = RequestMethod.GET)
	public String deletebus(@PathVariable("id") int id) {
		LOGGER.info("deletebus method invoked");
		busService.delete(id);
		if(routeDAO.getByBusid(id)!=null){
			routeService.delete(id);
		}
		return "redirect:/busdetail";
	}
	
	

}
