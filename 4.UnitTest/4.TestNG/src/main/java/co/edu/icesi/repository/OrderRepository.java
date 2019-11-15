package co.edu.icesi.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.annotation.Order;

import co.edu.icesi.exception.GuardadoDeOrdenException;
import co.edu.icesi.exception.OrdenNoEncontradaException;
import co.edu.icesi.model.Orden;

public class OrderRepository implements IOrderRepository {

	private Map<String, Orden> orders;

	public OrderRepository() {
		orders = new HashMap<String, Orden>();
	}

	public void guardarOrden(Orden orden) throws GuardadoDeOrdenException {

		if (orders.containsKey(orden.getIdentificador()) && orden != null) {
			orders.put(orden.getIdentificador(), orden);
		} else {
			throw new GuardadoDeOrdenException();
		}

	}

	public void actualizar(Orden orden) throws OrdenNoEncontradaException{
		if (orden != null && !orders.containsKey(orden.getIdentificador())) {
			orders.put(orden.getIdentificador(), orden);			
		}else {
			throw new OrdenNoEncontradaException();
		}
	}
}
