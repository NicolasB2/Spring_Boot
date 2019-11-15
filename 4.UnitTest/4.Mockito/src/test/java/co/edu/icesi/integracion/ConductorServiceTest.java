package co.edu.icesi.integracion;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import co.edu.icesi.model.Tmio1Conductore;
import co.edu.icesi.repository.*;
import co.edu.icesi.service.*;

@SpringBootTest
public class ConductorServiceTest extends AbstractTestNGSpringContextTests{

	@Autowired
	private ServiciosConductores conductorService;

	@BeforeTest
	public void setUp() {
		
	}

	@Test
	public void testConductorContratoValido() {

		Tmio1Conductore conductor = new Tmio1Conductore();
		conductor.setCedula("123");
		SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");

		try {
			Date dateC = (Date) parseador.parse("22-09-2019");
			Date dateN = (Date) parseador.parse("29-03-1999");
			conductor.setFechaContratacion(dateC);
			conductor.setFechaNacimiento(dateN);

			assertEquals(conductorService.agregarConductor(conductor), conductor);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Test
	public void testConductorNonNull() {

		Tmio1Conductore conductor = new Tmio1Conductore();
		conductor.setCedula("123");

		SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");

		try {
			Date dateC = (Date) parseador.parse("23-03-2019");
			Date dateN = (Date) parseador.parse("29-03-1999");
			conductor.setFechaContratacion(dateC);
			conductor.setFechaNacimiento(dateN);

			
			assertEquals(conductorService.agregarConductor(conductor),conductor);
			assertNotNull(conductorService.agregarConductor(conductor));

			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

}
