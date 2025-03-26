package com.dxctechnology.busbookingsystem.dto;

import lombok.Data;

@Data
public class TicketDTO {

	private String type;
	private String regno;
	private String origin;
	private String destination;
	private String date;
	private String dtime;
	private int totalfare;
	private String pname1;
	private String pnum1;
	private String pname2;
	private String pnum2;
	private String pname3;
	private String pnum3;
	private String userid;
	private String tickettime;
	private String pickuppoint;
	private String droppoint;
	
}
