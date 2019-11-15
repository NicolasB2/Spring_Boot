package co.edu.icesi.repository;

import co.edu.icesi.model.Tmio1Bus;


public interface IRepositorioBuses {
	
	public Tmio1Bus agregarBus(Tmio1Bus bus);
	public Tmio1Bus consultarBus(int id);
	public void eliminarBus(int id);
	public Tmio1Bus actualizarRuta(Tmio1Bus bus);
}
