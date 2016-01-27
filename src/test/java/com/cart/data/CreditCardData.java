package com.cart.data;

public class CreditCardData {

	private String firstName;
	private String lastName;
	private String type;
	private String cardNumber;
	private String expirationMonth;
	private String expirationYear;
	private String securityCode;
	private String defaultCard;
	private String address;
	private String country;
	private String state;
	private String city;
	private String postalCode;
	
	public static CreditCardData getNew()
	{
		return new CreditCardData();
	}
	
	public CreditCardData setFirstName(String firstName){
		this.firstName = firstName;
		return this;
	}
	
	public CreditCardData setLastName(String lastName){
		this.lastName = lastName;
		return this;
	}
	
	public CreditCardData setCardNumber(String cardNumber){
		this.cardNumber = cardNumber;
		return this;
	}
	
	public CreditCardData setExpirationMonth(String expirationMonth){
		this.expirationMonth = expirationMonth;
		return this;
	}
	
	public CreditCardData setExpirationYear(String expirationYear){
		this.expirationYear = expirationYear;
		return this;
	}
	
	public CreditCardData setSecurityCode(String securityCode){
		this.securityCode = securityCode;
		return this;
	}
	
	public CreditCardData setDefaultCard(String defaultCard){
		this.defaultCard = defaultCard;
		return this;
	}
	
	public CreditCardData setAddress(String address){
		this.address = address;
		return this;
	}

	public CreditCardData setCountry(String country){
		this.country = country;
		return this;
	}
	
	public CreditCardData setState(String state){
		this.state = state;
		return this;
	}
	
	public CreditCardData setCity(String city){
		this.city = city;
		return this;
	}
	
	public CreditCardData setPostalCode(String postalCode){
		this.postalCode = postalCode;
		return this;
	}
	
	public CreditCardData setType(String type){
		this.postalCode = type;
		return this;
	}

	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getType(){
		return type;
	}
	
	public String getCardNumber(){
		return cardNumber;
	}
	
	public String getExpirationMonth(){
		return expirationMonth;
	}

	public String getExpirationYear(){
		return expirationYear;
	}

	public String getSecurityCode(){
		return securityCode;
	}

	public String getDefaultCard(){
		return defaultCard;
	}

	public String getAddress(){
		return address;
	}

	public String getCountry(){
		return country;
	}
	
	public String getState(){
		return state;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getPostalCode(){
		return postalCode;
	}
}