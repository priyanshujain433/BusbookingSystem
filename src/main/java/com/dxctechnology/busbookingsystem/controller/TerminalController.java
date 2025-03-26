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

import com.dxctechnology.busbookingsystem.dao.RouteDAO;
import com.dxctechnology.busbookingsystem.dao.SubstationDAO;
import com.dxctechnology.busbookingsystem.dao.TerminalDAO;
import com.dxctechnology.busbookingsystem.dto.TerminalDTO;
import com.dxctechnology.busbookingsystem.entity.Terminal;
import com.dxctechnology.busbookingsystem.service.RouteService;
import com.dxctechnology.busbookingsystem.service.SubstationService;
import com.dxctechnology.busbookingsystem.service.TerminalService;


@Controller
public class TerminalController {

	@Autowired
	TerminalService terminalService;
	
	@Autowired
	TerminalDAO terminalDAO;
	
	@Autowired
	RouteDAO routeDAO;
	
	@Autowired
	RouteService routeService;
	
	@Autowired
	SubstationDAO substationDAO;
	
	@Autowired
	SubstationService substationService;
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@GetMapping("/terminal")
	public ModelAndView allTerminalDetails() {
		LOGGER.info("allTerminalDetails method invoked");
		ModelAndView modelAndView = new ModelAndView();
		List<Terminal> terminals = terminalDAO.findAll();
		modelAndView.addObject("terminals", terminals);
		modelAndView.setViewName("terminal");
		return modelAndView;
	}

	
	@GetMapping("/addterminal")
	public ModelAndView addterminalpage() {
		LOGGER.info("addterminalpage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addterminal");
		return modelAndView;
	}
	

	@PostMapping("/saveterminal.do")
	public ModelAndView saveTerminalInfo(TerminalDTO dto) {
		LOGGER.info("saveBusInfo method invoked");
		ModelAndView modelAndView = new ModelAndView();
		if (terminalService.validateAndSaveTerminal(dto)!=null) {
			modelAndView.setViewName("terminal_success");
			modelAndView.addObject("name", dto.getTerminalname());
		} else {
			modelAndView.setViewName("addterminal");
		}
		return modelAndView;
	}

	
	@RequestMapping(value = "deleteterminal/{id}", method = RequestMethod.GET)
	public String deleteterminal(@PathVariable("id") int id) {
		LOGGER.info("deleteterminal method invoked");
		Terminal terminal = terminalDAO.getById(id);
		terminalService.delete(id);
		substationDAO.deleteByTerminal(terminal.getTerminalname());
		return "redirect:/terminal";
	}

	

}
