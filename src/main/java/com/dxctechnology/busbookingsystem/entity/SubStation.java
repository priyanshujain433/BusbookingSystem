package com.dxctechnology.busbookingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "substation_details")
public class SubStation {
	
	@Id
	@Column(name = "substation_id")
	private int substationid;
	private String terminal;
	@Column(name = "substation_name")
	private String substationname;
	@Column(name = "substation_contact")
	private long substationcontact;
	
}
