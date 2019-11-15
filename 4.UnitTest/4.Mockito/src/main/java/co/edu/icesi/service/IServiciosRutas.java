package co.edu.icesi.service;
import co.edu.icesi.model.*;

public interface IServiciosRutas {

	public Tmio1Ruta agregarRuta(Tmio1Ruta ruta)throws Exception;
	public Tmio1Ruta consultarRuta(String id)throws Exception;
	public void eliminarRuta(String id)throws Exception;
	public Tmio1Ruta actualizarRuta(Tmio1Ruta ruta)throws Exception;
}
