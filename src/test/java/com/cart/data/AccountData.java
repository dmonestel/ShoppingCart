package com.cart.data;

public class AccountData {

	private String username;
	private String password;
	private String email;
	
	public static AccountData getNew()
	{
		return new AccountData();
	}
	
	public String getUsername(){
        return this.username ;
	}
	
	public String getEmail(){
        return this.email ;
	}
	
	public String getPassword(){
        return this.password ;
	}
	
	public AccountData setUsername(String username){
        this.username = username;
        return this ;
	}
	
	public AccountData setEmail(String email){
        this.email = email;
        return this ;
	}
	
	public AccountData setPassword(String password){
        this.password = password;
        return this ;
	}
}