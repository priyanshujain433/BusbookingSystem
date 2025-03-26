package com.dxctechnology.busbookingsystem.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechnology.busbookingsystem.dao.UserDAO;
import com.dxctechnology.busbookingsystem.dto.UserDTO;
import com.dxctechnology.busbookingsystem.entity.User;
import com.dxctechnology.busbookingsystem.util.MD5Util;
import com.dxctechnology.busbookingsystem.util.MailSenderUtil;


@Service
public class RegisterService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private UserDAO impl;

	@Autowired
	private MailSenderUtil util;

	public User validateAndSaveUser(UserDTO dto) {
		LOGGER.info("validateAndSaveUser method invoked");

		User user = null;
		if (validateUser(dto.getEmail()) && validatePassword(dto.getPassword(), dto.getConfirmPassword())) {
			/*
			 * util.sendMail(dto.getEmail(), "Hi " + dto.getFirstName() + " " +
			 * dto.getLastName() + " Thanks for signing up",
			 * "Welcome!  We are happy to have you on board. \n Username: " + dto.getEmail()
			 * + "\n Password: " + dto.getPassword());
			 */
			user = new User();
			BeanUtils.copyProperties(dto, user);
			String encryptedPassword = MD5Util.getMd5(dto.getPassword());
			user.setPassword(encryptedPassword);
			impl.save(user);
			return user;
		}
		return user;
	}

	public boolean validateUser(String email) {
		LOGGER.info("RegisterService - validateUser method invoked");
		if (Objects.nonNull(email) && !email.isEmpty())
			return true;

		return false;
	}

	public boolean validatePassword(String password, String cnfPassword) {
		LOGGER.info("validatePassword method invoked");
		if (Objects.nonNull(password) && Objects.nonNull(cnfPassword) && !password.isEmpty()
				&& !cnfPassword.isEmpty()) {
			if (password.equals(cnfPassword)) {
				return true;
			}
		}
		return false;
	}

}
