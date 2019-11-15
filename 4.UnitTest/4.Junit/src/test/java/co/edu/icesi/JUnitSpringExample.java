package co.edu.icesi;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import co.edu.icesi.main.AppConfig;
import co.edu.icesi.model.Order;
import co.edu.icesi.service.SampleService;
import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class,loader=AnnotationConfigContextLoader.class)
public class JUnitSpringExample {
	
	@Autowired
	private SampleService sampleService;
	private Order order;
	
	@Before
	public void before() {
		
		log.info("compile context");
		order = new Order();
		order.setDescription("");
		order.setOrderDate(new Date());
		order.setOrderId(0);
		order.setOrderStatus("INITIATED");
		order.setSecurityCode("XYZ");
		
		sampleService.createOrder(order);
	}
	
	@After
	public void after() {
		order = null;
	}
	
	@BeforeClass
	static public void print_before() {
		log.info("Before*********************************");
	}
	
	@AfterClass
	static public void print_after() {
		log.info("After**********************************");
	}
	
	@Test
	public void test_getOrderDescription() {
		assertTrue(sampleService.getOrderDescription(0).startsWith("Description:"));
	}
	
	@Test 
	public void test_getOrderStringCode() {
		assertTrue(sampleService.getOrderStringCode(0).startsWith("Account Code:"));
	}
	
	@Test
	public void test_createOrder() {

		assertSame(order, sampleService.createOrder(order));
		assertNotNull(order.getDescription());
		assertNotNull(order.getOrderId());
	}
	
	@Test
	public void test_getOrder() {
		
		order = sampleService.getOrder(0);
		
		assertNotNull(order.getDescription());
		assertNotNull(order.getOrderDate());
		assertNotNull(order.getOrderId());
		assertNotNull(order.getOrderStatus());
		assertNotNull(order.getSecurityCode());
	}
	
}
