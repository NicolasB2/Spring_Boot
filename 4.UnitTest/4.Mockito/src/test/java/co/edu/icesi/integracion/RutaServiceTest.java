package co.edu.icesi.integracion;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import co.edu.icesi.model.*;
import co.edu.icesi.repository.*;
import co.edu.icesi.service.*;

@SpringBootTest
@Test
public class RutaServiceTest extends AbstractTestNGSpringContextTests{

	@Autowired
	private ServiciosRutas serviceRutas;
	
	@BeforeTest
	public void setuUP() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testHoraFinMayorHoraInicio() {		
		
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setId("A11");
		ruta.setHoraInicio(new BigDecimal(35800));
		ruta.setHoraFin(new BigDecimal(70000));
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(1));
		
		try {
			
			assertEquals(serviceRutas.agregarRuta(ruta),ruta);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	@Test
	public void testDiaFinMayorDiaInicio() {
		
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setId("A11");
		ruta.setHoraInicio(new BigDecimal(35800));
		ruta.setHoraFin(new BigDecimal(70000));
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(3));
		
		try {
			assertEquals(serviceRutas.agregarRuta(ruta),ruta);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDiaFinIgualDiaInicio() {
		
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setId("A11");
		ruta.setHoraInicio(new BigDecimal(35800));
		ruta.setHoraFin(new BigDecimal(70000));
		ruta.setDiaInicio(new BigDecimal(5));
		ruta.setDiaFin(new BigDecimal(5));
		
		try {
			assertEquals(serviceRutas.agregarRuta(ruta),ruta);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
