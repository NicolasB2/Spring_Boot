package co.edu.icesi.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.*;
import lombok.Data;

@Repository
@Data
public class RepositorioRutas implements IRepositorioRutas{

	Map<String, Tmio1Ruta> rutas;
	
	public RepositorioRutas() {
		rutas = new HashMap<String, Tmio1Ruta>();
	}
	
	@Override
	public Tmio1Ruta agregarRuta(Tmio1Ruta ruta)
	{
		rutas.put(ruta.getId(), ruta);
		return ruta;
	}
	
	@Override
	public Tmio1Ruta consultarRuta(String id)
	{
		Tmio1Ruta ruta = rutas.get(id);
		return ruta;
	}

	@Override
	public void eliminarRuta(String id)
	{
		rutas.remove(id);
	}
	
	@Override
	public Tmio1Ruta actualizarRuta(Tmio1Ruta ruta)
	{
		rutas.put(ruta.getId(), ruta);
		return ruta;
	}
}
