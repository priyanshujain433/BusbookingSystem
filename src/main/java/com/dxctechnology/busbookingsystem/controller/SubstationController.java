package com.dxctechnology.busbookingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.dxctechnology.busbookingsystem.dao.SubstationDAO;
import com.dxctechnology.busbookingsystem.dto.SubStationDTO;
import com.dxctechnology.busbookingsystem.entity.SubStation;
import com.dxctechnology.busbookingsystem.service.SubstationService;


@Controller
public class SubstationController {

	@Autowired
	SubstationService substationService;
	
	@Autowired
	SubstationDAO substationDAO;
	
	
	private static final Logger LOGGER = LogManager.getLogger();
	

	@GetMapping("/addsubstation")
	public ModelAndView addsubstationpage(HttpSession session) {
		LOGGER.info("addsubstationpage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		String terminal = (String) session.getAttribute("terminal");
		modelAndView.setViewName("addsubstation");
		modelAndView.addObject("terminal", terminal);
		return modelAndView;
	}
	
	@RequestMapping(value = "substations/{name}", method = RequestMethod.GET)
	public String substationsDetails(@PathVariable("name") String name, HttpSession session) {
		LOGGER.info("substationsDetails method invoked");
		session.setAttribute("terminal", name);
		return "redirect:/sub";
	}
	
	@RequestMapping(value = "/sub", method = RequestMethod.GET)
	public ModelAndView substationsDetailspage(HttpSession session) {
		LOGGER.info("substationsDetailspage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		String name = (String) session.getAttribute("terminal");
		List<SubStation> stations = substationDAO.getByTerminal(name);
		modelAndView.addObject("stations", stations);
		modelAndView.setViewName("substations");
		return modelAndView;
	}
	
	@PostMapping("/savesubstation")
	public ModelAndView saveSubstationInfo(SubStationDTO dto) {
		LOGGER.info("saveSubstationInfo method invoked");
		ModelAndView modelAndView = new ModelAndView();
		if (substationService.validateAndSaveSubstation(dto)!=null) {
			String msg = "Substation added successfully";
			modelAndView.setViewName("addsubstation");
			modelAndView.addObject("msg", msg);
		} else {
			String msg = "Unsuccessful Substation addition";
			modelAndView.setViewName("addsubstation");
			modelAndView.addObject("emsg", msg);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "deletestation/{id}", method = RequestMethod.GET)
	public String deleteStation(@PathVariable("id") int id) {
		LOGGER.info("deleteStation method invoked");
		substationService.delete(id);
		return "redirect:/sub";
	}
	

}
