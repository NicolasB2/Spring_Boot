package co.edu.icesi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.model.*;
import co.edu.icesi.repository.IRepositorioServicios;

@Service
public class ServiciosServicios implements IServiciosServicios {

	@Autowired
	private IRepositorioServicios servicios;
	
	@Override
	public Tmio1Servicio agregarServicio(Tmio1Servicio servicio)throws Exception {
		
		if(servicio.getTmio1Bus()==null) {
			throw new Exception("El bus es nulo");
		}else if(servicio.getTmio1Conductore()==null) {
			throw new Exception("El conductor es nulo");
		}else if(servicio.getTmio1Ruta()==null) {
			throw new Exception("La fecha es nula");
		}else if(servicio.getFechaFin()==null && servicio.getFechaInicio()==null) {
			throw new Exception("Falta alguna fecha");
		}else if(servicio.getFechaFin().compareTo(servicio.getFechaInicio())<=0) {
			throw new Exception("Las fechas del servicio son inconsistentes");
		}else if(servicio.getTmio1Conductore().getFechaContratacion().compareTo(servicio.getFechaFin())>0) {
			throw new Exception("Las fechas del servicio son inconsistentes con la fecha de contratacion del conductor");
		}
			
		servicios.agregarServicio(servicio);
		return servicio;
	}

	@Override
	public Tmio1Servicio consultarServicio(int id)throws Exception{
		return servicios.consultarServicio(id);
	}

	@Override
	public void eliminarServicio(int id)throws Exception{
		servicios.eliminarServicio(id);
	}

	@Override
	public Tmio1Servicio actualizarServicio(Tmio1Servicio servicio)throws Exception{
		servicios.agregarServicio(servicio);
		return servicio;
	}

	
}
