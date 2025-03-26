package com.dxctechnology.busbookingsystem.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechnology.busbookingsystem.dao.UserDAO;
import com.dxctechnology.busbookingsystem.entity.User;
import com.dxctechnology.busbookingsystem.util.MD5Util;


@Service
public class LoginService {

	@Autowired
	UserDAO daoImpl;
	
	 @Autowired
	 ApplicationProperties properties;
	 
	
	private static final Logger LOGGER = LogManager.getLogger();

	public User validateUser(String email, String password) {
		LOGGER.info("LoginService - validateUser method invoked");
		if ((Objects.nonNull(email) && !email.isEmpty()) && Objects.nonNull(password) && !password.isEmpty()) {
			String encryptedPassword = MD5Util.getMd5(password);
			User user = daoImpl.getByEmail(email);
			if (user == null) {
				return null;
			}
			if (user.getEmail().equals(email) && user.getPassword().equals(encryptedPassword)) {
				return user;
			}
		}
		return null;
	}
	
	public boolean validateAdmin(String email,String password) {
		LOGGER.info("LoginService - validateAdmin method invoked");
		if ((Objects.nonNull(email) && !email.isEmpty()) && Objects.nonNull(password) && !password.isEmpty()) {
			if (email.equals(properties.getConfigValue("admin.mail")) && password.equals(properties.getConfigValue("admin.password"))) {
				return true;
			}
		}
		return false;
	}

}
