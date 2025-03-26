package com.dxctechnology.busbookingsystem.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechnology.busbookingsystem.dao.TerminalDAO;
import com.dxctechnology.busbookingsystem.dto.TerminalDTO;
import com.dxctechnology.busbookingsystem.entity.Terminal;

@Service
public class TerminalService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private TerminalDAO impl;

	public Terminal validateAndSaveTerminal(TerminalDTO dto) {
		LOGGER.info("validateAndSaveTerminal method invoked");
		Terminal terminal = null;
		if (validateTerminal(dto.getTerminalid(),dto.getTerminalname(),dto.getTerminalcontact())) {
			terminal = new Terminal();
			BeanUtils.copyProperties(dto, terminal);
			impl.save(terminal);
			return terminal;
		}
		return terminal;
	}

	public boolean validateTerminal(int terminalid, String terminaname, long terminalcontact) {
		LOGGER.info("TerminalService - validateTerminal method invoked");
		if ((Objects.nonNull(terminalid) && terminalid != 0) && (Objects.nonNull(terminalcontact) && terminalcontact != 0)
				&& (Objects.nonNull(terminaname) && !terminaname.isEmpty()))
			return true;

		return false;
	}
	public void delete(int id) {
		impl.deleteById(id);
	}

}
