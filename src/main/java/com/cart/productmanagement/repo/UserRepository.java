package com.cart.productmanagement.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cart.productmanagement.model.Product;
import com.cart.productmanagement.model.UserDTO;

public interface UserRepository {

	List<UserDTO> fetchAll();
	UserDTO fetchById(int userId);
	UserDTO save(Product user);
	List<UserDTO> save(List<UserDTO> users);
	Product update(UserDTO user);
	void remove(UserDTO user);
	UserDTO fetchByUserName(String username);
	
}
