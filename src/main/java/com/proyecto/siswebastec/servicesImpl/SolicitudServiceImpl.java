package com.proyecto.siswebastec.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.siswebastec.DAO.SolicitudDAO;
import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.model.Estado;
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
	
	public List<Solicitud> getSolicitudesPendientes() {
		List<Solicitud> todos=getSolicitudes();
		List<Solicitud> pendientes=new ArrayList<>();
		//Estado pend=new Estado(1);
		for(int i=0;i<todos.size();i++){
			
			if(todos.get(i).getIdEstado()!= null){
				System.out.println(todos.get(i).getIdEstado().getIdEstado());
				if(todos.get(i).getIdEstado().getIdEstado()==1){				
					pendientes.add(todos.get(i));
				}
			}
		}
		return pendientes;
	}

	public List<Solicitud> getSolicitudesProceso() {
		List<Solicitud> todos=getSolicitudes();
		List<Solicitud> proceso=new ArrayList<>();
		//Estado pend=new Estado(1);
		for(int i=0;i<todos.size();i++){
			if(todos.get(i).getIdEstado()!= null){
				if(todos.get(i).getIdEstado().getIdEstado()==2){
					proceso.add(todos.get(i));
				}
			}
		}
		return proceso;
	}
	
	public List<Solicitud> getSolicitudesFinalizadas() {
		List<Solicitud> todos=getSolicitudes();
		List<Solicitud> finalizadas=new ArrayList<>();
		//Estado pend=new Estado(1);
		for(int i=0;i<todos.size();i++){
			if(todos.get(i).getIdEstado()!= null){
				if(todos.get(i).getIdEstado().getIdEstado()==3){
					finalizadas.add(todos.get(i));
				}
			}
		}
		return finalizadas;
	}
	
	public boolean verificaSolicitud(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
