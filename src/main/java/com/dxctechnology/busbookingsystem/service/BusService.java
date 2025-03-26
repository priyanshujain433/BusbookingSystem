package com.dxctechnology.busbookingsystem.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechnology.busbookingsystem.dao.BusDAO;
import com.dxctechnology.busbookingsystem.dto.BusDTO;
import com.dxctechnology.busbookingsystem.entity.Bus;

@Service
public class BusService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private BusDAO impl;

	public Bus validateAndSaveBus(BusDTO dto) {
		LOGGER.info("validateAndSaveBus method invoked");

		Bus bus = null;
		if (validateBus(dto.getBusid(),dto.getType(),dto.getSeats(),dto.getRegno())) {
			bus = new Bus();
			BeanUtils.copyProperties(dto, bus);
			bus = impl.save(bus);
			return bus;
		}
		return bus;
	}

	public boolean validateBus(int busid, String type, int seats, String regno) {
		LOGGER.info("BusService - validateBus method invoked");
		if ((Objects.nonNull(busid) && busid != 0) && (Objects.nonNull(seats) && seats != 0)
				&& (Objects.nonNull(type) && !type.isEmpty()) && (Objects.nonNull(regno) && !regno.isEmpty()))
			return true;

		return false;
	}
	public void delete(int id) {
		impl.deleteById(id);
	}

}
