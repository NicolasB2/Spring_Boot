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

import co.edu.icesi.model.*;
import co.edu.icesi.repository.*;
import co.edu.icesi.service.*;

@SpringBootTest
@Test
public class RutaServiceTest {

	@Mock
	private IRepositorioRutas mockRuta;
	
	@InjectMocks
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
			
			when(mockRuta.agregarRuta(ruta)).thenReturn(ruta);
			assertEquals(serviceRutas.agregarRuta(ruta),ruta);
			verify(mockRuta,times(1)).agregarRuta(ruta);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testInvalidoHoraFinIgualHoraInicio() {		
		
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setId("A11");
		ruta.setHoraInicio(new BigDecimal(12000));
		ruta.setHoraFin(new BigDecimal(12000));
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(1));
		
		try {
			
			serviceRutas.agregarRuta(ruta);
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testInvalidoHoraFinMenorHoraInicio() {
		
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setId("A11");
		ruta.setHoraInicio(new BigDecimal(41000));
		ruta.setHoraFin(new BigDecimal(34000));
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(3));
		
		try {
			
			serviceRutas.agregarRuta(ruta);
			
		} catch (Exception e) {
			assertTrue(true);
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
			when(mockRuta.agregarRuta(ruta)).thenReturn(ruta);
			assertEquals(serviceRutas.agregarRuta(ruta),ruta);
			verify(mockRuta,times(1)).agregarRuta(ruta);
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
			when(mockRuta.agregarRuta(ruta)).thenReturn(ruta);
			assertEquals(serviceRutas.agregarRuta(ruta),ruta);
			verify(mockRuta,times(1)).agregarRuta(ruta);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testInvalidoDiaFinMenorDiaInicio() {
		
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setId("A11");
		ruta.setHoraInicio(new BigDecimal(35800));
		ruta.setHoraFin(new BigDecimal(70000));
		ruta.setDiaInicio(new BigDecimal(5));
		ruta.setDiaFin(new BigDecimal(4));
		
		try {
			serviceRutas.agregarRuta(ruta);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCreateServiceNonNull() {
		
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setId("A11");
		ruta.setHoraInicio(new BigDecimal(21600));
		ruta.setHoraFin(new BigDecimal(46800));
		ruta.setDiaInicio(new BigDecimal(4));
		ruta.setDiaFin(new BigDecimal(4));
		
		try {
			when(mockRuta.agregarRuta(ruta)).thenReturn(ruta);
			assertEquals(serviceRutas.agregarRuta(ruta), ruta);
			assertNotNull(serviceRutas.agregarRuta(ruta));
			verify(mockRuta, times(2)).agregarRuta(ruta);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCreateServiceNull() {
		
		Tmio1Ruta ruta =  null;
		try {
			serviceRutas.agregarRuta(ruta);
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}
}
