package com.cart.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.productmanagement.model.UserDTO;
import com.cart.productmanagement.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAllUsers() {

		return userRepository.fetchAll();

	}

	public UserDTO getUserByUserName(String username) {
		return userRepository.fetchByUserName(username);
	}

}
