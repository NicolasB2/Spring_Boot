package co.edu.icesi.repository;

import co.edu.icesi.model.Tmio1Ruta;

public interface IRepositorioRutas {

	public Tmio1Ruta agregarRuta(Tmio1Ruta ruta);
	public Tmio1Ruta consultarRuta(String id);
	public void eliminarRuta(String id);
	public Tmio1Ruta actualizarRuta(Tmio1Ruta ruta);
}
