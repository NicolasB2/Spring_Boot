package co.edu.icesi.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.*;

@Repository
public class RepositorioServicios implements IRepositorioServicios{
	
	Map<Integer, Tmio1Servicio> servicios;

	public RepositorioServicios() {
		servicios = new HashMap<Integer, Tmio1Servicio>();
	}
	
	@Override
	public Tmio1Servicio agregarServicio(Tmio1Servicio servicio) {
		servicios.put(servicio.getServiceId(), servicio);
		return servicio;
	}

	@Override
	public Tmio1Servicio consultarServicio(int id) {
		Tmio1Servicio servicio = servicios.get(id);
		return servicio;
	}

	@Override
	public void eliminarServicio(int id) {
		servicios.remove(id);
	}

	@Override
	public  Tmio1Servicio actualizarServicio(Tmio1Servicio servicio) {
		servicios.put(servicio.getServiceId(), servicio);
		return servicio;
	}
	
	
}
