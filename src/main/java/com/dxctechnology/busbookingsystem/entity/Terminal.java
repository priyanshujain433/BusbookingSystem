package com.dxctechnology.busbookingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "terminal_details")
public class Terminal {
	
	@Id
	@Column(name = "terminal_id")
	private int terminalid;
	@Column(name = "terminal_type")
	private String terminalname;
	@Column(name = "terminal_contact")
	private long terminalcontact;
}
