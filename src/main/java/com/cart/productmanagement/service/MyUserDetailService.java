package com.cart.productmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cart.productmanagement.model.UserDTO;

@Service
public class MyUserDetailService implements UserDetailsService {

	Logger logger =  LoggerFactory.getLogger(MyUserDetailService.class);
			
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.info("Usename: "+username);
		UserDTO userDTO = userService.getUserByUserName(username);
		return new User(userDTO.getUserName(), userDTO.getUserName(), new ArrayList<>());
	}

}
