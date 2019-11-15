package co.edu.icesi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.model.*;
import co.edu.icesi.repository.IRepositorioConductores;

@Service
public class ServiciosConductores implements IServiciosConductores{

	@Autowired
	private IRepositorioConductores conductores;


	
	@Override
	public Tmio1Conductore agregarConductor(Tmio1Conductore conductore) throws Exception {
		
		if (conductore == null) {
			throw new Exception("El conductor el nulo");
		}else if(conductore.getCedula() == null) {
			throw new Exception("Falta la cedula");
		}else if(conductore.getFechaNacimiento().compareTo(conductore.getFechaContratacion())>0) {
			throw new Exception("Las fechas no son consistentes");
		}
		
		conductores.agregarConductor(conductore);
		return conductore;		
	}

	@Override
	public Tmio1Conductore consultarConductor(String cedula)throws Exception {
		Tmio1Conductore conductor = conductores.consultarConductor(cedula);
		return conductor;
	}

	@Override
	public void eliminarConductores(String cedula)throws Exception {
		conductores.eliminarConductores(cedula);
		
	}

	@Override
	public Tmio1Conductore actualizarConductor (Tmio1Conductore conductore)throws Exception {
		
		if (conductore == null) {
			throw new Exception("El conductor el nulo");
		}else if(conductore.getFechaNacimiento().compareTo(conductore.getFechaContratacion())>0) {
			throw new Exception("Las fechas no son consistentes");
		}
		
		conductores.agregarConductor(conductore);
		return conductore;		
	}
	
}