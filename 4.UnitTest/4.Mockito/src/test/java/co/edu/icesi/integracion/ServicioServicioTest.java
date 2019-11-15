package co.edu.icesi.integracion;

import org.testng.Assert;
import org.testng.AssertJUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import co.edu.icesi.model.Tmio1Bus;
import co.edu.icesi.model.Tmio1Conductore;
import co.edu.icesi.model.Tmio1Ruta;
import co.edu.icesi.model.Tmio1Servicio;
import co.edu.icesi.repository.*;
import co.edu.icesi.service.*;

@SpringBootTest
@Test
public class ServicioServicioTest extends AbstractTestNGSpringContextTests {

	private Tmio1Bus bus;
	private Tmio1Conductore conductor;
	private Tmio1Ruta ruta;
	
	@Autowired
	private RepositorioBuses repositorioBuses;
	
	@Autowired
	private RepositorioConductores repositorioConductores;
	
	@Autowired
	private RepositorioRutas repositorioRutas;
	
	@Autowired
	private ServiciosServicios serviceServicios;
	
	@BeforeTest
	public void setuUP() {

		bus = new Tmio1Bus();
		bus.setId(0);
		bus.setTipo("T");
		bus.setCapacidad(new BigDecimal(12));
		
		conductor = new Tmio1Conductore();
		conductor.setCedula("123");
		SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");
		try {
			Date dateC = (Date) parseador.parse("10-01-2018");
			Date dateN = (Date) parseador.parse("29-03-1999");
			conductor.setFechaContratacion(dateC);
			conductor.setFechaNacimiento(dateN);
		}catch (Exception e) {}
		
		
		ruta = new Tmio1Ruta();
		ruta.setId("A11");
		ruta.setHoraInicio(new BigDecimal(35800));
		ruta.setHoraFin(new BigDecimal(70000));
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(1));	
	}
	
	@Test
	public void testCreateFechaInicioConsistente() {
		
		Tmio1Servicio servicio = new Tmio1Servicio();
		servicio.setServiceId(11);
		
		SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");

		
		try {
		
			Tmio1Bus b1 = repositorioBuses.agregarBus(bus);
			Tmio1Conductore c1 = repositorioConductores.agregarConductor(conductor);
			Tmio1Ruta r1 = repositorioRutas.agregarRuta(ruta);
			
			servicio.setTmio1Bus(b1);
			servicio.setTmio1Conductore(c1);
			servicio.setTmio1Ruta(r1);
			
			//La fecha de contratacion esta para el año 2018
			Date dateI = (Date) parseador.parse("29-03-2019");
			Date dateF = (Date) parseador.parse("19-09-2019");
			
			servicio.setFechaInicio(dateI);
			servicio.setFechaFin(dateF);

			AssertJUnit.assertEquals(serviceServicios.agregarServicio(servicio), servicio);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	@Test
	public void testCreatFechaInicioInconsistente() {

		Tmio1Servicio servicio = new Tmio1Servicio();
		servicio.setServiceId(11);
		servicio.setTmio1Bus(repositorioBuses.agregarBus(bus));
		servicio.setTmio1Conductore(repositorioConductores.agregarConductor(conductor));
		servicio.setTmio1Ruta(repositorioRutas.agregarRuta(ruta));

		SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");

		try {

			// La fecha de contratacion esta para el año 2018
			Date dateI = (Date) parseador.parse("29-03-2015");
			Date dateF = (Date) parseador.parse("19-09-2015");

			servicio.setFechaInicio(dateI);
			servicio.setFechaFin(dateF);

			serviceServicios.agregarServicio(servicio);
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAddRutaValido() {
		
		Tmio1Servicio servicio = new Tmio1Servicio();
		servicio.setServiceId(11);
		
		SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");

		try {
		
			Tmio1Bus b1 = repositorioBuses.agregarBus(bus);
			Tmio1Conductore c1 = repositorioConductores.agregarConductor(conductor);
			Tmio1Ruta r1 = repositorioRutas.agregarRuta(ruta);
			
			servicio.setTmio1Bus(b1);
			servicio.setTmio1Conductore(c1);
			servicio.setTmio1Ruta(r1);
			
			Date dateI = (Date) parseador.parse("29-03-2019");
			Date dateF = (Date) parseador.parse("19-09-2019");
			
			servicio.setFechaInicio(dateI);
			servicio.setFechaFin(dateF);
			
			
			Tmio1Servicio answer = serviceServicios.agregarServicio(servicio);
			
			AssertJUnit.assertEquals(answer, servicio);
			AssertJUnit.assertEquals(answer.getTmio1Bus(), repositorioBuses.consultarBus(0));
			AssertJUnit.assertEquals(answer.getTmio1Conductore(), repositorioConductores.consultarConductor("123"));
			AssertJUnit.assertEquals(answer.getTmio1Ruta(),repositorioRutas.consultarRuta("A11"));

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testAddRutaInvalido() {
		
		Tmio1Servicio servicio = new Tmio1Servicio();
		servicio.setServiceId(11);
		servicio.setTmio1Bus(repositorioBuses.agregarBus(bus));
		servicio.setTmio1Conductore(repositorioConductores.agregarConductor(conductor));
		servicio.setTmio1Ruta(repositorioRutas.agregarRuta(ruta));
		
		SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");

		try {
		
			Date dateI = (Date) parseador.parse("29-03-2019");
			Date dateF = (Date) parseador.parse("19-09-2019");
			
			servicio.setFechaInicio(dateI);
			servicio.setFechaFin(dateF);
		
			serviceServicios.agregarServicio(servicio);
			
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
}
