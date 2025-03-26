package com.dxctechnology.busbookingsystem.dto;

import lombok.Data;

@Data
public class UserDTO {

	private String firstName;
	private String lastName;
	private String email;
	private long mobile;
	private String password;
	private String confirmPassword;
	private String city;
}
