package com.proyecto.siswebastec.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.siswebastec.DAO.ClienteDAO;
import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.DAO.PrioridadDAO;
import com.proyecto.siswebastec.DAO.SolicitudDAO;
import com.proyecto.siswebastec.model.Cliente;
import com.proyecto.siswebastec.model.Prioridad;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.services.PrioridadService;

public class PrioridadServiceImpl implements PrioridadService {

	PrioridadDAO prioridadDAO;
	JPAUtil objJpaUtil;
	Prioridad prioridad;
	
	public PrioridadServiceImpl() {
		super();
		objJpaUtil = new JPAUtil();
		prioridadDAO =  new PrioridadDAO(objJpaUtil.getEntityManager());
		prioridad = new Prioridad();
	}
	
	public PrioridadDAO getPrioridadDAO() {
		return prioridadDAO;
	}

	public void setPrioridadDAO(PrioridadDAO prioridadDAO) {
		this.prioridadDAO = prioridadDAO;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public List<Prioridad> getPrioridades() {
		return getPrioridadDAO().listarTodos();
	}

	public List<String> getNombresPri() {
		List<Prioridad> pri = getPrioridades();
		List<String> ars = new ArrayList<>();
		for(int i=0; i<pri.size();i++){
			ars.add(pri.get(i).getNombrePrioridad());
		}
		return ars;
		
	}
}
