package co.edu.icesi.service;

import co.edu.icesi.model.*;

public interface IServiciosServicios {

	public Tmio1Servicio agregarServicio(Tmio1Servicio servicio) throws Exception;
	public Tmio1Servicio consultarServicio(int id)throws Exception;
	public void eliminarServicio(int id)throws Exception;
	public Tmio1Servicio actualizarServicio(Tmio1Servicio servicio)throws Exception;
}
