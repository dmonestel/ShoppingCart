package com.cart.data;

import com.ts.commons.FirefoxDriver;

public class DeviceData {
	
	private String hostname;
	private FirefoxDriver driver;

	public static DeviceData getNew()
	{
		return new DeviceData();
	}

	public String getHostname(){
        return this.hostname ;
 }
 
  public DeviceData setHostname(String hostname){
        this.hostname = hostname;
        return this ;
}

	
	
	 		

}
