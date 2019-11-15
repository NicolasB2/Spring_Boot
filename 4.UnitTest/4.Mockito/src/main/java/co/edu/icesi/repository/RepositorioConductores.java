package co.edu.icesi.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import co.edu.icesi.model.*;
import lombok.Data;

@Repository
@Data
public class RepositorioConductores implements IRepositorioConductores{

	Map<String, Tmio1Conductore> conductores;
	
	public RepositorioConductores() {
		conductores = new HashMap<String, Tmio1Conductore>();
	}
	
	@Override
	public Tmio1Conductore agregarConductor(Tmio1Conductore conductor)
	{
		conductores.put(conductor.getCedula(), conductor);
		return conductor;
	}
	
	@Override
	public Tmio1Conductore consultarConductor(String cedula)
	{
		Tmio1Conductore conductor = conductores.get(cedula);
		return conductor;
	}

	@Override
	public void eliminarConductores(String cedula)
	{
		conductores.remove(cedula);
	}
	
	@Override
	public Tmio1Conductore actualizarConductor(Tmio1Conductore conductor)
	{
		conductores.put(conductor.getCedula(), conductor);
		return conductor;
	}

}
