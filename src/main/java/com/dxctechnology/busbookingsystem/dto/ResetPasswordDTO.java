package com.dxctechnology.busbookingsystem.dto;

import lombok.Data;

@Data
public class ResetPasswordDTO {
	
	private String email;
	private String otp;
	private String password;
	private String cnfpassword;

}
