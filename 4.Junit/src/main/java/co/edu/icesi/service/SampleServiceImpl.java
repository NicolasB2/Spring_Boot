package co.edu.icesi.service;

import java.util.ArrayList;

import co.edu.icesi.model.Order;
import lombok.Data;

@Data
public class SampleServiceImpl implements SampleService {

	private ArrayList<Order> orders;
	
	public SampleServiceImpl(){
		orders = new ArrayList<Order>();
	}
	
	//dummy method
	public String getOrderDescription(int id) {
		Order existingOrder = getOrder(id);
		
		if(existingOrder!=null) {
			existingOrder.setDescription("Order for XYZ in units");
			return "Description: " + existingOrder.getDescription();
		}
		
		return "Description: ";	
	}

	//dummy method
	public String getOrderStringCode(int id) {
		Order existingOrder = getOrder(id);
		
		if(existingOrder!=null) {
			return "Account Code: " + existingOrder.getSecurityCode();
		}
		return "Account Code: ";
	}
	
	//dummy method
	public Order createOrder(Order order) {
		orders.add(order);
		return order;
	}
	
	//dummy method
	public Order getOrder(int id) {
		for (Order order : orders) {
			if (order.getOrderId()==id) {
				return order;
			}
		}
		return null;
	}
	
	

}
