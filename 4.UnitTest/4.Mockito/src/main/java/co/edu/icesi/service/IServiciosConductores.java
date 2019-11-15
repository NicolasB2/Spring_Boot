package co.edu.icesi.service;

import co.edu.icesi.model.*;

public interface IServiciosConductores {

	public Tmio1Conductore agregarConductor(Tmio1Conductore conductore)throws Exception;	
	public Tmio1Conductore consultarConductor(String cedula)throws Exception;
	public void eliminarConductores(String cedula)throws Exception;	
	public Tmio1Conductore actualizarConductor(Tmio1Conductore conductore)throws Exception;
}
