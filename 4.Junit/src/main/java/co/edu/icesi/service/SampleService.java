package co.edu.icesi.service;

import co.edu.icesi.model.Order;

public interface SampleService {

	public String getOrderDescription(int id);
	public String getOrderStringCode(int id);
	public Order getOrder(int id);
	public Order createOrder(Order order);
	
	
}
