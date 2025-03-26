package com.dxctechnology.busbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "route_details")
public class Route {
	
	@Id
	@Column(name = "bus_id")
	private int busid;
	@Column(name = "bus_type")
	private String type;
	@Column(name = "no_of_seats")
	private int seats;
	@Column(name = "bus_reg_no")
	private String regno;
	private String origin;
	private String destination;
	private LocalDate dateoftravel;
	private LocalTime departuretime;
	private LocalTime arrivaltime;
	@Column(name = "ticket_fare")
	private int fare;

}
