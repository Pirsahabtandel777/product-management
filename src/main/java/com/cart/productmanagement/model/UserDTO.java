package com.cart.productmanagement.model;

public class UserDTO {

	public static final String SELLER = "SELLER";
	public static final String CUSTOMER = "CUSTOMER";

	private Integer userId;
	private String userName;
	private String userRole;
	private String pass;

	public UserDTO() {

	}

	public UserDTO(Integer userId, String userName, String userRole, String pass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.pass = pass;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", userRole=" + userRole + "]";
	}

}
