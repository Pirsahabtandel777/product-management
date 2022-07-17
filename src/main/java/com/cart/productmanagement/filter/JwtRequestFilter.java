package com.cart.productmanagement.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cart.productmanagement.model.UserDTO;
import com.cart.productmanagement.service.MyUserDetailService;
import com.cart.productmanagement.service.UserService;
import com.cart.productmanagement.utils.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	@Autowired
	private UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwt = null;
		
		if(authHeader!=null && authHeader.startsWith("Bearer")){
			jwt = authHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}
		
		logger.info(jwt);
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = userDetailService.loadUserByUsername(username);
			
			UserDTO userDTO = userService.getUserByUserName(username);
			
			if(userDTO.getUserRole().equals(UserDTO.CUSTOMER) && !request.getMethod().equals("GET")) {
				response.sendError(401, "Unauthorized access to the resource");
			}
			
			if(jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
