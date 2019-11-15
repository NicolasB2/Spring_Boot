package co.edu.icesi.service;
import co.edu.icesi.model.*;

public interface IServiciosBuses {

	public Tmio1Bus agregarBus(Tmio1Bus bus) throws Exception;
	public Tmio1Bus consultarBus(int id) throws Exception;
	public void eliminarBus(int id) throws Exception;
	public Tmio1Bus actualizarBus(Tmio1Bus bus) throws Exception;
}
