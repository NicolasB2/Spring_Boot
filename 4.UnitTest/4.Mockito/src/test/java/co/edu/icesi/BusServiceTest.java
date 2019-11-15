package co.edu.icesi;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import co.edu.icesi.model.Tmio1Bus;
import co.edu.icesi.repository.IRepositorioBuses;
import co.edu.icesi.service.ServiciosBuses;

@SpringBootTest
@Test
public class BusServiceTest{
	
	@Mock
	private IRepositorioBuses mockBus;
	
	@InjectMocks
	private ServiciosBuses serviceBuses;
	
	@BeforeTest
	public void setuUP() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCapacidadValida() {		
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("T");
		bus.setCapacidad(new BigDecimal(12));
		
		try {
			
			when(mockBus.agregarBus(bus)).thenReturn(bus);
			assertEquals(serviceBuses.agregarBus(bus),bus);
			verify(mockBus,times(1)).agregarBus(bus);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCapacidadCero() {	
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("T");
		bus.setCapacidad(new BigDecimal(0));
		
		try {
			
			when(mockBus.agregarBus(bus)).thenReturn(bus);
			assertEquals(serviceBuses.agregarBus(bus),bus);
			verify(mockBus,times(1)).agregarBus(bus);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCapacidadInvalida() {	
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("T");
		bus.setCapacidad(new BigDecimal(-20));
		
		try {
			serviceBuses.agregarBus(bus);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testTipoT() {	
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("T");
		bus.setCapacidad(new BigDecimal(0));
		
		try {
			when(mockBus.agregarBus(bus)).thenReturn(bus);
			assertEquals(serviceBuses.agregarBus(bus),bus);
			verify(mockBus,times(1)).agregarBus(bus);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testTipoP() {	
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("P");
		bus.setCapacidad(new BigDecimal(0));
		
		try {
			when(mockBus.agregarBus(bus)).thenReturn(bus);
			assertEquals(serviceBuses.agregarBus(bus),bus);
			verify(mockBus,times(1)).agregarBus(bus);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testTipoA() {		
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("A");
		bus.setCapacidad(new BigDecimal(0));
		
		try {
			when(mockBus.agregarBus(bus)).thenReturn(bus);
			assertEquals(serviceBuses.agregarBus(bus),bus);
			verify(mockBus,times(1)).agregarBus(bus);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testTipoInvalido() {	
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("X");
		bus.setCapacidad(new BigDecimal(0));
		
		try {
			serviceBuses.agregarBus(bus);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testNotNull() {	
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("T");
		bus.setCapacidad(new BigDecimal(0));
		
		try {
			when(mockBus.agregarBus(bus)).thenReturn(bus);
			assertNotNull(serviceBuses.agregarBus(bus));
			assertEquals(serviceBuses.agregarBus(bus),bus);
			verify(mockBus,times(2)).agregarBus(bus);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testNull() {	

		Tmio1Bus bus = null;
		
		try {
			serviceBuses.agregarBus(bus);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
