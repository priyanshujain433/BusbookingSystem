package com.dxctechnology.busbookingsystem.dto;

import lombok.Data;

@Data
public class PassangerDTO {

	String passangerName1;
	String passangernumber1;
	String passangerName2;
	String passangernumber2;
	String passangerName3;
	String passangernumber3;
	String pickup;
	String drop;
	int ticketcount;
	int totalfare;
}
