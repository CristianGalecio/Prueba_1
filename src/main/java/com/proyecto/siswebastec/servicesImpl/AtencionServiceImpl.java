package com.proyecto.siswebastec.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.siswebastec.DAO.AtencionDAO;
import com.proyecto.siswebastec.DAO.CalificacionDAO;
import com.proyecto.siswebastec.DAO.EvaluacionDAO;
import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.DAO.SolicitudDAO;
import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Calificacion;
import com.proyecto.siswebastec.model.Evaluacion;
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
	public Calificacion getCalificacionById(int id){
		objJpaUtil = new JPAUtil();
		CalificacionDAO cal = new CalificacionDAO(objJpaUtil.getEntityManager());
		return cal.getCalificacionByIdcalificacion(id);
	}
	
	public List<Calificacion> getCalificaciones() {
		objJpaUtil = new JPAUtil();
		CalificacionDAO cal= new CalificacionDAO(objJpaUtil.getEntityManager());
		return cal.listarTodos();
	}

	public List<String> getCalificacionesNombre(){
		List<String> cal = new ArrayList<>();
		List<Calificacion> calobj = getCalificaciones();
		for(int i=0;i<calobj.size();i++){
			cal.add(calobj.get(i).getNombreCalificacion());
		}
		return cal;
	}

	public Calificacion getCalificacionporNombre(String nombrecalf){
		objJpaUtil = new JPAUtil();
		CalificacionDAO cal= new CalificacionDAO(objJpaUtil.getEntityManager());
		return cal.getCalificacionByNombrecalificacion(nombrecalf);
	}
	
	@Override
	public void addEvaluacion(Evaluacion evaluacion) {
		objJpaUtil = new JPAUtil();
		EvaluacionDAO cal= new EvaluacionDAO(objJpaUtil.getEntityManager());
		cal.insertarEvaluacion(evaluacion);
	}

}
