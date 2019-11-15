package co.edu.icesi.integracion;

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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import co.edu.icesi.model.Tmio1Bus;
import co.edu.icesi.repository.IRepositorioBuses;
import co.edu.icesi.service.IServiciosRutas;
import co.edu.icesi.service.ServiciosBuses;

@SpringBootTest
@Test
public class BusServiceTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private ServiciosBuses serviceBuses;
	
	@BeforeTest
	public void setUP() {
		
	}
	
	@Test
	public void testCapacidadValidaTipoT() {		
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("T");
		bus.setCapacidad(new BigDecimal(12));
		
		try {
			assertEquals(serviceBuses.agregarBus(bus),bus);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCapacidadCeroTipoP() {	
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("P");
		bus.setCapacidad(new BigDecimal(0));
		
		try {
			assertEquals(serviceBuses.agregarBus(bus),bus);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}	
}
