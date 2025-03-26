package com.dxctechnology.busbookingsystem.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechnology.busbookingsystem.dao.UserDAO;
import com.dxctechnology.busbookingsystem.dto.ResetPasswordDTO;
import com.dxctechnology.busbookingsystem.entity.User;
import com.dxctechnology.busbookingsystem.util.MD5Util;
import com.dxctechnology.busbookingsystem.util.MailSenderUtil;
import com.dxctechnology.busbookingsystem.util.OTPGenerator;

@Service
public class ResetPasswordService {

	@Autowired
	private UserDAO impl;
	@Autowired
	private MailSenderUtil util;
	private static final Logger LOGGER = LogManager.getLogger();

	public String validateAndSendOTP(String email) {
		LOGGER.info("validateAndSendOTP method invoked");
		if (Objects.nonNull(email) && !email.isEmpty()) {
			User user = impl.getByEmail(email);
			if (user != null) {
				if (user.getEmail().equals(email)) {
					String otp = OTPGenerator.GetOTP();
					util.sendMail(email, "OTP", otp);
					return otp;
				}
			}else {
				return null;
			}
		}
		return null;
	}

	public boolean validateOTP(ResetPasswordDTO dto, String otpFromSession) {
		LOGGER.info("validatePassword method invoked");
		if (dto.getOtp().equals(otpFromSession)) {
			if (Objects.nonNull(dto.getPassword()) && Objects.nonNull(dto.getCnfpassword())
					&& !dto.getPassword().isEmpty() && !dto.getCnfpassword().isEmpty()) {
				String encryptedPassword = MD5Util.getMd5(dto.getPassword());
				impl.updatePassword(encryptedPassword, dto.getEmail());
				return true;
			}
		}
		return false;
	}

}
