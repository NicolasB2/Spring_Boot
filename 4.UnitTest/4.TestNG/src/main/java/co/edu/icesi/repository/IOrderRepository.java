package co.edu.icesi.repository;

import co.edu.icesi.exception.GuardadoDeOrdenException;
import co.edu.icesi.exception.OrdenNoEncontradaException;
import co.edu.icesi.model.Orden;

public interface IOrderRepository {

	public void guardarOrden(Orden orden) throws GuardadoDeOrdenException;
	public void actualizar(Orden orden) throws OrdenNoEncontradaException;
}
