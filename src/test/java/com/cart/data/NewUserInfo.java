package com.cart.data;

import com.ts.commons.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class newuserInfo {
	
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
	
	public static newuserInfo getNew()
	{
		return new newuserInfo();
	}
//
	public String getCountry() {
		return this.country;
	}

	public newuserInfo setCountry(String country) {
		this.country = country;
		return this;
	}
	
//
	public String getState() {
		return this.state;
	}

	public newuserInfo setstate(String state) {
		this.state = state;
		return this;
	}
	
//
	public String getFirst_name() {
		return this.first_name;
	}

	public newuserInfo setFirstname(String first_name) {
		this.first_name = first_name;
		return this;
	}

	
//
	public String getLast_name() {
		return this.last_name;
	}

	public newuserInfo setLastname(String last_name) {
		this.last_name = last_name;
		return this;
	}
//	
	public String getCompany() {
		return this.company;
	}

	public newuserInfo setCompany(String company) {
		this.company = company;
		return this;
	}
//	
	public String getAddress() {
		return this.address;
	}

	public newuserInfo setAddress(String address) {
		this.address = address;
		return this;
	}
//
	public String getCity() {
		return this.city;
	}

	public newuserInfo setCity(String city) {
		this.city = city;
		return this;
	}
//	
	public String getPostal_code() {
		return this.postal_code;
	}

	public newuserInfo setPostal_code(String postal_code) {
		this.postal_code = postal_code;
		return this;
	}
//
	public String getPhone() {
		return this.phone;
	}

	public newuserInfo setPhone(String phone) {
		this.phone = phone;
		return this;
	}
//	
	public String getUsername() {
		return this.username;
	}

	public newuserInfo setUsername(String username) {
		this.username = username;
		return this;
	}
//
	public String getPassword() {
		return this.password;
	}

	public newuserInfo setPassword(String password) {
		this.password = password;
		return this;
	}
//
	public String getConfirm_password() {
		return this.confirm_password;
	}

	public newuserInfo setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
		return this;
	}
//
	public String getSignature() {
		return this.signature;
	}

	public newuserInfo setSignature(String signature) {
		this.signature = signature;
		return this;
	}
//	
}
