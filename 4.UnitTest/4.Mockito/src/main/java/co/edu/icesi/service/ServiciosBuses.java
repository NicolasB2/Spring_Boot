package co.edu.icesi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.model.*;
import co.edu.icesi.repository.*;

@Service
public class ServiciosBuses implements IServiciosBuses{

	@Autowired
	private IRepositorioBuses buses;
	
	@Override
	public Tmio1Bus agregarBus(Tmio1Bus bus) throws Exception {
		
		if(bus==null) {
			throw new Exception("El bus que se ingreso es nulo");
		}else if (bus.getCapacidad().signum()<0) {
			throw new Exception("La capsaidad del bus es menor a cero");
		}else if (bus.getId() == null|| bus.getTipo() == null){
			throw new Exception("Faltan algun dato para crear el bus");
		}else if(!bus.getTipo().equals("T")&&!bus.getTipo().equals("P")&&!bus.getTipo().equals("A")) {
			throw new Exception("El tipo del bus es invalido");
		}
		
		buses.agregarBus(bus);
		return bus;
	}

	@Override
	public Tmio1Bus consultarBus(int id) throws Exception {
		return buses.consultarBus(id);
	}

	@Override
	public void eliminarBus(int id) throws Exception {
		buses.eliminarBus(id);
	}

	@Override
	public Tmio1Bus actualizarBus(Tmio1Bus bus) throws Exception {
		
		if(bus==null || bus.getCapacidad().signum()<0|| bus.getId() == null|| bus.getTipo() == null||
				(!bus.getTipo().equals("T")&&!bus.getTipo().equals("P")&&!bus.getTipo().equals("A"))) {
				throw new Exception();
			}
			
			buses.agregarBus(bus);
			return bus;
	}
	
}
