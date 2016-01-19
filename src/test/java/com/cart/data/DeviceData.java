package com.cart.data;

import com.ts.commons.FirefoxDriver;

public class DeviceData {
	
	private String hostname;
	private int total;
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

  public int getTotal() {
	return total;
}

  public void setTotal(int total) {
	this.total = total;
}

	
	
	 		

}
