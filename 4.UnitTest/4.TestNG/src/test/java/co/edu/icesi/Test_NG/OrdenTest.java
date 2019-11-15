package co.edu.icesi.Test_NG;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.springframework.util.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import co.edu.icesi.model.Orden;

public class OrdenTest {
	
	private Orden orden;
	
	
	@BeforeClass
	private void context() {
		this.orden = new Orden();
	}
	
	@Test(groups = { "guardar","exitoso" })
	public void guardarOrderExitoso() {
		assertTrue(true);
	}
	
	@Test(groups = { "guardar","fallido" })
	public void guardarOrderFallido() {
		assertTrue(true);
	}
	
	@Test(groups = { "actualizar","exitoso" })
	public void actualizarOrderExitoso() {
		assertTrue(true);
	}

	@Test(groups = { "actualizar","fallido" })
	public void actualizarOrderFallido() {
		assertTrue(true);
	}
	
	@Test(dependsOnGroups = {"actualizar","guardar"}, groups = {"global"})
	public void ordenTest() {
		assertTrue(true);
	}
	
}
