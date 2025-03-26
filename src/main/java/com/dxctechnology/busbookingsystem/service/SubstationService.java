package com.dxctechnology.busbookingsystem.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechnology.busbookingsystem.dao.SubstationDAO;
import com.dxctechnology.busbookingsystem.dto.SubStationDTO;
import com.dxctechnology.busbookingsystem.entity.SubStation;

@Service
public class SubstationService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private SubstationDAO impl;

	public SubStation validateAndSaveSubstation(SubStationDTO dto) {
		LOGGER.info("validateAndSaveSubstation method invoked");
		SubStation station = null;
		if (validateSubStation(dto.getTerminal(),dto.getSubstationid(),dto.getSubstationname(),dto.getSubstationcontact())) {
			station = new SubStation();
			BeanUtils.copyProperties(dto, station);
			impl.save(station);
			return station;
		}
		return station;
	}

	public boolean validateSubStation(String terminal, int stationid, String stationname, long stationcontact) {
		LOGGER.info("SubstationService - validateSubStation method invoked");
		if ((Objects.nonNull(stationid) && stationid != 0) && (Objects.nonNull(stationcontact) && stationcontact != 0)
				&& (Objects.nonNull(stationname) && !stationname.isEmpty())&& (Objects.nonNull(terminal) && !terminal.isEmpty()))
			return true;

		return false;
	}
	
	
	public void delete(int id) {
		impl.deleteById(id);
	}

}
