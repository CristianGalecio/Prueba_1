       package com.proyecto.siswebastec.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.siswebastec.DAO.CategoriaDAO;
import com.proyecto.siswebastec.DAO.DiagnosticoDAO;
import com.proyecto.siswebastec.DAO.SolicitudDAO;
import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.model.Categoria;
import com.proyecto.siswebastec.model.Diagnostico;
import com.proyecto.siswebastec.model.Estado;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.model.Solucion;
import com.proyecto.siswebastec.services.SolicitudService;

public class SolicitudServiceImpl implements SolicitudService{

	SolicitudDAO solicitudDAO;
	DiagnosticoDAO diagnosticoDAO;
	CategoriaDAO categoriaDAO;
	JPAUtil objJpaUtil;
	Solicitud solicitud;
	Categoria categoria;
	
	public SolicitudServiceImpl() {
		super();
		objJpaUtil = new JPAUtil();
		solicitudDAO =  new SolicitudDAO(objJpaUtil.getEntityManager());
		solicitud = new Solicitud();
		objJpaUtil = new JPAUtil();
		categoriaDAO =  new CategoriaDAO(objJpaUtil.getEntityManager());
		categoria = new Categoria();		
	}
	
	public void addSolicitud(Solicitud solicitud) {
		objJpaUtil = new JPAUtil();
		solicitudDAO = new SolicitudDAO(objJpaUtil.getEntityManager());
		solicitudDAO.insertarSolicitud(solicitud);
		
	}

	public void updateSolicitud(Solicitud solicitud) {
		objJpaUtil = new JPAUtil();
		solicitudDAO = new SolicitudDAO(objJpaUtil.getEntityManager());
		solicitudDAO.update(solicitud);		
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

	public List<Solicitud> getSolicitudesProcesoPendientes() {
		List<Solicitud> todos=getSolicitudes();
		List<Solicitud> propend=new ArrayList<>();
		//Estado pend=new Estado(1);
		for(int i=0;i<todos.size();i++){
			if(todos.get(i).getIdEstado()!= null){
				if(todos.get(i).getIdEstado().getIdEstado()==1 || todos.get(i).getIdEstado().getIdEstado()==2){
					propend.add(todos.get(i));
				}
			}
		}
		return propend;
	}
	
	public boolean verificaSolicitud(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void addDiagnostico(Diagnostico diag) {
		// TODO Auto-generated method stub
		objJpaUtil = new JPAUtil();
		diagnosticoDAO = new DiagnosticoDAO(objJpaUtil.getEntityManager());
		diagnosticoDAO.insertarDiagnostico(diag);
		System.out.println("addDiagnostico()");
		
	}

	@Override
	public void addSolucion(Solucion sol) {
		objJpaUtil = new JPAUtil();
		solicitudDAO = new SolicitudDAO(objJpaUtil.getEntityManager());
		solicitudDAO.insertarSolucion(sol);
		System.out.println("addSolicitud()");
	}

	@Override
	public List<String> getListaCat() {
		System.out.println("SolicitudServiceImpl.getListaCat()");
		objJpaUtil = new JPAUtil();
		categoriaDAO = new CategoriaDAO(objJpaUtil.getEntityManager());
		
		List<Categoria> pri = categoriaDAO.listarTodos();
		List<String> ars = new ArrayList<>();
		for(int i=0; i<pri.size();i++){
			ars.add(pri.get(i).getNombreCategoria());
			System.out.println(pri.get(i).getNombreCategoria());
		}
		return ars;
	}

	@Override
	public void actualizarCat(Solicitud sasig) {
		objJpaUtil = new JPAUtil();
		solicitudDAO = new SolicitudDAO(objJpaUtil.getEntityManager());
		solicitudDAO.update(sasig);		
	}

}
