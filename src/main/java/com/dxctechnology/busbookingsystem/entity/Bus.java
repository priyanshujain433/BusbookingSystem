package com.dxctechnology.busbookingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bus_details")
public class Bus {
	
	@Id
	@Column(name = "bus_id")
	private int busid;
	@Column(name = "bus_type")
	private String type;
	@Column(name = "no_of_seats")
	private int seats;
	@Column(name = "bus_reg_no")
	private String regno;
}
