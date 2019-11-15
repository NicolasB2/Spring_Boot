package co.edu.icesi.repository;

import co.edu.icesi.model.Tmio1Servicio;

public interface IRepositorioServicios {

	public Tmio1Servicio agregarServicio(Tmio1Servicio servicio);
	public Tmio1Servicio consultarServicio(int id);
	public void eliminarServicio(int id);
	public Tmio1Servicio actualizarServicio(Tmio1Servicio servicio);
}
