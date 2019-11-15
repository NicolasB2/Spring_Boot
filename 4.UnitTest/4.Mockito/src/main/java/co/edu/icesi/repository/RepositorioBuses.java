package co.edu.icesi.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import co.edu.icesi.model.*;
import lombok.Data;

@Repository
@Data
public class RepositorioBuses implements IRepositorioBuses{


	Map<Integer, Tmio1Bus> buses;
	
	public RepositorioBuses() {
		buses = new HashMap<Integer, Tmio1Bus>();
	}
	
	@Override
	public Tmio1Bus agregarBus(Tmio1Bus bus)
	{
		buses.put(bus.getId(), bus);
		return bus;
	}
	
	@Override
	public Tmio1Bus consultarBus(int id)
	{
		Tmio1Bus bus = buses.get(id);
		return bus;
	}
	
	@Override
	public void eliminarBus(int id)
	{
		buses.remove(id);
	}
	
	@Override
	public Tmio1Bus actualizarRuta(Tmio1Bus bus)
	{
		buses.put(bus.getId(), bus);
		return bus;
	}
}
