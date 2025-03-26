package com.dxctechnology.busbookingsystem.dto;

import lombok.Data;

@Data
public class RouteDTO {
	
	private int busid;
	private String type;
	private String origin;
	private String destination;
	private int seats;
	private String regno;
	private int fare;
	private String dateoftravel;
	private String departuretime;
	private String arrivaltime;

}
