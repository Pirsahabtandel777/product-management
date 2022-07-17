package com.cart.productmanagement.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cart.productmanagement.model.Product;
import com.cart.productmanagement.model.UserDTO;

@Repository
public class JdbcUserRepository implements UserRepository {

	Logger logger =  LoggerFactory.getLogger(JdbcUserRepository.class);

	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<UserDTO> fetchAll() {

		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user_t");

		List<UserDTO> users = new ArrayList<>();

		if (list != null && list.size() > 0) {
			for (Map<String, Object> map : list) {

				UserDTO userDTO = new UserDTO();
				userDTO.setUserId((Integer) map.get("userid"));
				userDTO.setUserName((String) map.get("username"));
				userDTO.setUserRole((String) map.get("userrole"));

				users.add(userDTO);
			}
		}

		return users;
	}

	@Override
	public UserDTO fetchById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO save(Product user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> save(List<UserDTO> users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(UserDTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDTO fetchByUserName(String username) {
				
		 Map<String, Object> map = jdbcTemplate.queryForMap("select * from user_t where username=?",username);
		 		 
		return new UserDTO((Integer)map.get("userid"),(String)map.get("username"), (String)map.get("userrole"), (String)map.get("pass"));
	}

}
