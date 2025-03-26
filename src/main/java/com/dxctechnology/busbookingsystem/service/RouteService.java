package com.dxctechnology.busbookingsystem.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechnology.busbookingsystem.dao.RouteDAO;
import com.dxctechnology.busbookingsystem.dto.RouteDTO;
import com.dxctechnology.busbookingsystem.entity.Route;

@Service
public class RouteService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private RouteDAO impl;
	@Autowired
	BusService busService;

	public Route validateAndSaveRoute(RouteDTO dto) {
		LOGGER.info("validateAndSaveRoute method invoked");
		Route route = null;
		if (busService.validateBus(dto.getBusid(), dto.getType(), dto.getSeats(), dto.getRegno())
				&& validateTerminalAndFare(dto.getOrigin(), dto.getDestination(), dto.getFare())
				&& !dto.getOrigin().equals(dto.getDestination())) {
			route = new Route();
			route.setDateoftravel(LocalDate.parse(dto.getDateoftravel()));
			route.setDeparturetime(LocalTime.parse(dto.getDeparturetime()));
			route.setArrivaltime(LocalTime.parse(dto.getArrivaltime()));
			BeanUtils.copyProperties(dto, route);
			impl.save(route);
			return route;
		}
		return route;
	}

	public boolean validateTerminalAndFare(String origin, String destination, int fare) {
		LOGGER.info("validateTerminalAndFare method invoked");
		if ((Objects.nonNull(fare) && fare != 0) && (Objects.nonNull(destination) && !destination.isEmpty())
				&& (Objects.nonNull(origin) && !origin.isEmpty()))
			return true;

		return false;
	}

	public void delete(int id) {
		impl.deleteById(id);
	}
	
}
