package com.proyecto.siswebastec.servicesImpl;

import java.util.List;

import com.proyecto.siswebastec.DAO.SolicitudDAO;
import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.services.SolicitudService;

public class SolicitudServiceImpl implements SolicitudService{

	SolicitudDAO solicitudDAO;
	JPAUtil objJpaUtil;
	Solicitud solicitud;
	
	public SolicitudServiceImpl() {
		super();
		objJpaUtil = new JPAUtil();
		solicitudDAO =  new SolicitudDAO(objJpaUtil.getEntityManager());
		solicitud = new Solicitud();
	}
	
	public void addSolicitud(Solicitud solicitud) {
		objJpaUtil = new JPAUtil();
		solicitudDAO = new SolicitudDAO(objJpaUtil.getEntityManager());
		solicitudDAO.insertarSolicitud(solicitud);
		
	}

	public void updateSolicitud(Solicitud solicitud) {
		// TODO Auto-generated method stub
		
	}

	public void deleteSolicitud(Solicitud solicitud) {
		// TODO Auto-generated method stub
		
	}

	public Solicitud getSolicitudById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Solicitud> getSolicitudes() {
		objJpaUtil = new JPAUtil();
		solicitudDAO = new SolicitudDAO(objJpaUtil.getEntityManager());
		return solicitudDAO.listarTodos();
	}

	public boolean verificaSolicitud(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
