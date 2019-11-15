package co.edu.icesi.model;

import java.util.Date;

import lombok.Data;

@Data
public class Order {

	public int orderId;
	public String orderStatus;
	public String securityCode;
	public String description;
	public Date orderDate;	
	
	
	public Order() {
		
	}
}
