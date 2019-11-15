package co.edu.icesi.repository;

import co.edu.icesi.model.*;
public interface IRepositorioConductores {

	public Tmio1Conductore agregarConductor(Tmio1Conductore conductor);	
	public Tmio1Conductore consultarConductor(String cedula);
	public void eliminarConductores(String cedula);	
	public Tmio1Conductore actualizarConductor(Tmio1Conductore conductor);
}
