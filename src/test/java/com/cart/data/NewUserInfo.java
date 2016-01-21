package com.cart.data;

public class NewUserInfo {
	
	private String first_name;
	private String last_name;
	private String company;
	private String address;
	private String city;
	private String postal_code;
	private String phone;
	private String username;
	private String password;
	private String confirm_password;
	private String signature;
	private String country;
	private String state;
	
	public static NewUserInfo getNew()
	{
		return new NewUserInfo();
	}
//
	public String getCountry() {
		return this.country;
	}

	public NewUserInfo setCountry(String country) {
		this.country = country;
		return this;
	}
	
//
	public String getState() {
		return this.state;
	}

	public NewUserInfo setstate(String state) {
		this.state = state;
		return this;
	}
	
//
	public String getFirst_name() {
		return this.first_name;
	}

	public NewUserInfo setFirstname(String first_name) {
		this.first_name = first_name;
		return this;
	}

	
//
	public String getLast_name() {
		return this.last_name;
	}

	public NewUserInfo setLastname(String last_name) {
		this.last_name = last_name;
		return this;
	}
//	
	public String getCompany() {
		return this.company;
	}

	public NewUserInfo setCompany(String company) {
		this.company = company;
		return this;
	}
//	
	public String getAddress() {
		return this.address;
	}

	public NewUserInfo setAddress(String address) {
		this.address = address;
		return this;
	}
//
	public String getCity() {
		return this.city;
	}

	public NewUserInfo setCity(String city) {
		this.city = city;
		return this;
	}
//	
	public String getPostal_code() {
		return this.postal_code;
	}

	public NewUserInfo setPostal_code(String postal_code) {
		this.postal_code = postal_code;
		return this;
	}
//
	public String getPhone() {
		return this.phone;
	}

	public NewUserInfo setPhone(String phone) {
		this.phone = phone;
		return this;
	}
//	
	public String getUsername() {
		return this.username;
	}

	public NewUserInfo setUsername(String username) {
		this.username = username;
		return this;
	}
//
	public String getPassword() {
		return this.password;
	}

	public NewUserInfo setPassword(String password) {
		this.password = password;
		return this;
	}
//
	public String getConfirm_password() {
		return this.confirm_password;
	}

	public NewUserInfo setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
		return this;
	}
//
	public String getSignature() {
		return this.signature;
	}

	public NewUserInfo setSignature(String signature) {
		this.signature = signature;
		return this;
	}
//	
}