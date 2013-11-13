package com.proyecto.siswebastec.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.siswebastec.DAO.AreaDAO;
import com.proyecto.siswebastec.DAO.AulaDAO;
import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.DAO.LaboratorioDAO;
import com.proyecto.siswebastec.DAO.UbicacionDAO;
import com.proyecto.siswebastec.model.Area;
import com.proyecto.siswebastec.model.Aula;
import com.proyecto.siswebastec.model.Laboratorio;
import com.proyecto.siswebastec.model.Ubicacion;
import com.proyecto.siswebastec.services.UbicacionService;

public class UbicacionServiceImpl implements UbicacionService{

	UbicacionDAO ubicacionDAO;
	AreaDAO areaDAO;
	AulaDAO aulaDAO;
	LaboratorioDAO laboratorioDAO;
	JPAUtil objJpaUtil;
	Ubicacion ubicacion;
	
	public UbicacionServiceImpl() {
		super();
		objJpaUtil = new JPAUtil();
		ubicacionDAO =  new UbicacionDAO(objJpaUtil.getEntityManager());
		areaDAO = new AreaDAO(objJpaUtil.getEntityManager());
		aulaDAO = new AulaDAO(objJpaUtil.getEntityManager());
		laboratorioDAO = new LaboratorioDAO(objJpaUtil.getEntityManager());
		ubicacion = new Ubicacion();
		
	}
	
	public UbicacionDAO getUbicacionDAO() {
		return ubicacionDAO;
	}

	public AreaDAO getAreaDAO(){
		objJpaUtil = new JPAUtil();
		areaDAO = new AreaDAO(objJpaUtil.getEntityManager());
		return areaDAO;
	}
	
	public AulaDAO getAulaDAO(){
		objJpaUtil = new JPAUtil();
		aulaDAO = new AulaDAO(objJpaUtil.getEntityManager());
		return aulaDAO;
	}
	
	public LaboratorioDAO getLaboratorioDAO(){
		objJpaUtil = new JPAUtil();
		laboratorioDAO = new LaboratorioDAO(objJpaUtil.getEntityManager());
		return laboratorioDAO;
	}
	public void setUbicacionDAO(UbicacionDAO ubicacionDAO) {
		this.ubicacionDAO = ubicacionDAO;
	}

	public void addUbicacion(Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		
	}

	public void updateUbicacion(Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUbicacion(Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		
	}

	public Ubicacion getUbicacionById(int id) {
		objJpaUtil =  new JPAUtil();
		ubicacionDAO = new UbicacionDAO(objJpaUtil.getEntityManager());
		ubicacion = ubicacionDAO.getUbicacionByIdubicacion(id);
		return ubicacion;
	}
	
	@Override
	public Ubicacion getNombreByNombre(String nombre) {
		objJpaUtil =  new JPAUtil();
		ubicacionDAO = new UbicacionDAO(objJpaUtil.getEntityManager());
		ubicacion = ubicacionDAO.getUbicacionByNombre(nombre);
		return ubicacion;
	}

	public List<String> getNombreUbi() {
		List<Ubicacion> ubs = getUbicaciones();
		List<String> ubn = new ArrayList<>();
		for (int i=0; i<ubs.size(); i++){			
			ubn.add(ubs.get(i).getNombreUbicacion());
		}
		return ubn;
	}
	
	public List<Ubicacion> getUbicaciones() {		
		return getUbicacionDAO().listarTodos();
	}

	public List<String> getNombreAreas() {
		List<Area> areas = getAreas();
		List<String> ars = new ArrayList<>();
		for(int i=0; i<areas.size();i++){
			ars.add(areas.get(i).getNombreArea());
		}
		return ars;
	}
	
	public List<Area> getAreas() {
		return getAreaDAO().listarTodos();
	}
	
	public List<String> getNombreAulas() {
		List<Aula> aulas = getAulas();
		List<String> ars = new ArrayList<>();
		for(int i=0; i<aulas.size();i++){
			ars.add(aulas.get(i).getNumeroAula());
		}
		return ars;
	}
	
	public List<Aula> getAulas() {
		return getAulaDAO().listarTodos();
	}
	
	public List<String> getNombreLabos() {
		List<Laboratorio> labos = getLabos();
		List<String> ars = new ArrayList<>();
		for(int i=0; i<labos.size();i++){
			ars.add(labos.get(i).getNombreLaboratorio());
		}
		return ars;
	}
	
	public List<Laboratorio> getLabos(){
		return getLaboratorioDAO().listarTodos();
	}

	
	
}
