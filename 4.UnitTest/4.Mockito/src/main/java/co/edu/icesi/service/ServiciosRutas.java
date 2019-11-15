package co.edu.icesi.service;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.model.Tmio1Ruta;
import co.edu.icesi.repository.IRepositorioRutas;

@Service
public class ServiciosRutas implements IServiciosRutas {

	@Autowired
	private IRepositorioRutas rutas;

	private boolean verifyDia(BigDecimal diaFin,BigDecimal diaInicio) {
		if(diaFin.subtract(diaInicio).compareTo(new BigDecimal(0))>=0) {
			return true;
		}
		return false;
	}
	
	private boolean verifyHora(BigDecimal horaFin,BigDecimal horaInicio) {
		if(horaFin.subtract(horaInicio).compareTo(new BigDecimal(0))>0) {
			return true;
		}
		return false;
	}
	
	@Override
	public Tmio1Ruta agregarRuta(Tmio1Ruta ruta) throws Exception {
		
		if(ruta.getId() == null || ruta.getDiaFin()==null || ruta.getDiaInicio()==null || ruta.getHoraFin() == null || ruta.getHoraInicio()==null) {
			throw new Exception("Faltan datos para crear la ruta");
		}else if (!verifyDia(ruta.getDiaFin(), ruta.getDiaInicio())) {
			throw new Exception("Los dias no son consistentes");
		}else if (!verifyHora(ruta.getHoraFin(), ruta.getHoraInicio())) {
			throw new Exception("Las horas no son consistentes");
		}

		rutas.agregarRuta(ruta);
		return ruta;
	}

	@Override
	public Tmio1Ruta consultarRuta(String id)throws Exception {
		return rutas.consultarRuta(id);
	}

	@Override
	public void eliminarRuta(String id) throws Exception{
		rutas.eliminarRuta(id);

	}

	@Override
	public Tmio1Ruta actualizarRuta(Tmio1Ruta ruta) throws Exception {
		
		if(ruta.getId() == null || ruta.getDiaFin()==null || ruta.getDiaInicio()==null || ruta.getHoraFin() == null || ruta.getHoraInicio()==null 
				||!verifyDia(ruta.getDiaFin(), ruta.getDiaInicio())||!verifyHora(ruta.getDiaFin(), ruta.getHoraInicio())) {
			throw new Exception();
		}

		rutas.agregarRuta(ruta);
		return ruta;
	}
}
