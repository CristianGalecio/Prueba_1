package com.proyecto.siswebastec.servicesImpl;

import java.util.List;

import com.proyecto.siswebastec.DAO.AtencionDAO;
import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.DAO.SolicitudDAO;
import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.services.AtencionService;

public class AtencionServiceImpl implements AtencionService{

	AtencionDAO atencionDAO;
	JPAUtil objJpaUtil;
	Atencion atencion;
	
	public AtencionServiceImpl() {
		super();
		objJpaUtil = new JPAUtil();
		atencionDAO =  new AtencionDAO(objJpaUtil.getEntityManager());
		atencion = new Atencion();
	}

	@Override
	public void addAtencion(Atencion atencion) {
		objJpaUtil = new JPAUtil();
		atencionDAO = new AtencionDAO(objJpaUtil.getEntityManager());
		atencionDAO.insertarAtencion(atencion);
		
	}

	@Override
	public void updateAtencion(Atencion atencion) {
		objJpaUtil = new JPAUtil();
		atencionDAO = new AtencionDAO(objJpaUtil.getEntityManager());
		atencionDAO.update(atencion);
		
	}

	@Override
	public void deleteAtencion(Atencion atencion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Atencion getAtencionById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atencion> getAtenciones() {
		// TODO Auto-generated method stub
		return null;
	}

}
