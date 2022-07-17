package com.cart.productmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.productmanagement.model.AuthenticationRequest;
import com.cart.productmanagement.model.AuthenticationResponse;
import com.cart.productmanagement.service.MyUserDetailService;
import com.cart.productmanagement.utils.JwtUtil;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	MyUserDetailService userDetailService;

	@Autowired
	JwtUtil jwtUtil;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			
			logger.info(authenticationRequest.toString());
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getPassword());

		String token = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(token));

	}

}
