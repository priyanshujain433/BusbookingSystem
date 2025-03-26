package com.dxctechnology.busbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dxctechnology.busbookingsystem.util.StringPrefixedSequenceIdGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "ticket_details")
public class Ticket {
	@Id
	@GenericGenerator(name = "tktid", strategy = "com.dxctechnology.busbookingsystem.util.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TKT_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d") })
	@GeneratedValue(generator = "tktid")
	@Column(name = "ticket_id")
	private String ticketid;
	@Column(name = "bus_type")
	private String type;
	@Column(name = "bus_reg_no")
	private String regno;
	private String origin;
	private String destination;
	private LocalDate date;
	private LocalTime dtime;
	@Column(name = "ticket_fare")
	private int totalfare;
	private String pname1;
	private String pnum1;
	private String pname2;
	private String pnum2;
	private String pname3;
	private String pnum3;
	private String userid;
	@Column(name = "ticket_generated_time")
	private LocalDateTime tickettime;
	private String pickuppoint;
	private String droppoint;
}
