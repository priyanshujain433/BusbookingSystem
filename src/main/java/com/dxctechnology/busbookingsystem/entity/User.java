package com.dxctechnology.busbookingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class User {

	@Id
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_firstname")
	private String firstName;
	@Column(name = "user_lastname")
	private String lastName;
	@Column(name = "user_mobile")
	private long mobile;
	@Column(name = "user_city")
	private String city;
	@Column(name = "user_password")
	private String password;
	
}
