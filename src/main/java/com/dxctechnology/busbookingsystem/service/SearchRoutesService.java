package com.dxctechnology.busbookingsystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechnology.busbookingsystem.dao.RouteDAO;
import com.dxctechnology.busbookingsystem.entity.Route;

@Service
public class SearchRoutesService {
	private static final Logger LOGGER = LogManager.getLogger();
	@Autowired
	private RouteDAO impl;

	public List<Route> validateSearch(String from,String to,String date) {
		LOGGER.info("validateSearch method invoked");
		List<Route> searchroutes = null;
		LocalDate parsedate = LocalDate.parse(date);
		if(parsedate.isBefore(LocalDate.now())) {
			searchroutes = null;
		}else if (validateSearchValues(from,to,date)) {
			searchroutes = impl.getByDestinationOriginAndDate(from, to, parsedate);
		}
		return searchroutes;
	}

	public boolean validateSearchValues(String from, String to, String date) {
		LOGGER.info("validateSearchValues method invoked");
		if ((Objects.nonNull(from) && !from.isEmpty()) && (Objects.nonNull(to) && !to.isEmpty()) && (Objects.nonNull(date) && !date.isEmpty())) {
			return true;
		}
		return false;
	}
}
