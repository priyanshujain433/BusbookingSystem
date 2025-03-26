package com.dxctechnology.busbookingsystem.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dxctechnology.busbookingsystem.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {


	@Modifying
	@Transactional
	@Query("update User user set user.password = :password WHERE user.email = :email")
    void updatePassword(@Param(value = "password") String password, @Param("email") String email);
	
	User getByEmail(String email);
	

}
