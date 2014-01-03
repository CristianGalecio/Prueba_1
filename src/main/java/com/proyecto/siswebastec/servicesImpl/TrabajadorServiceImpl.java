package com.proyecto.siswebastec.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.DAO.RolUsuarioDAO;
import com.proyecto.siswebastec.DAO.TrabajadorDAO;
import com.proyecto.siswebastec.DAO.UsuarioDAO;
import com.proyecto.siswebastec.model.Prioridad;
import com.proyecto.siswebastec.model.Rol;
import com.proyecto.siswebastec.model.RolUsuario;
import com.proyecto.siswebastec.model.Trabajador;
import com.proyecto.siswebastec.model.Usuario;
import com.proyecto.siswebastec.services.TrabajadorService;

public class TrabajadorServiceImpl implements TrabajadorService{

	TrabajadorDAO trabajadorDAO;
	JPAUtil objJpaUtil;
	Trabajador trabajador;
	RolUsuarioDAO rolUsuarioDAO;
	RolUsuario rolUsuario;
	
	public TrabajadorServiceImpl() {
		super();
		objJpaUtil = new JPAUtil();
		trabajadorDAO =  new TrabajadorDAO(objJpaUtil.getEntityManager());
		trabajador = new Trabajador();
		objJpaUtil = new JPAUtil();
		rolUsuarioDAO = new RolUsuarioDAO(objJpaUtil.getEntityManager());
		rolUsuario = new RolUsuario();
	}

	public void setTrabajadorDAO(TrabajadorDAO trabajadorDAO) {
		this.trabajadorDAO = trabajadorDAO;
	}
	
	public TrabajadorDAO getTrabajadorDAO() {
		return trabajadorDAO;
	}

	public void addTrabajador(Trabajador trabajador) {
		
	}

	public void updateTrabajador(Trabajador trabajador) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTrabajador(Trabajador rabajador) {
		// TODO Auto-generated method stub
		
	}

	public Trabajador getTrabajadorById(String id) {
		objJpaUtil =  new JPAUtil();
		trabajadorDAO = new TrabajadorDAO(objJpaUtil.getEntityManager());
		trabajador = trabajadorDAO.getTrabajadorByIdtrabajador(id);
		return trabajador;
	}

	public List<Trabajador> getTrabajadores() {
		return getTrabajadorDAO().listarTodos();
	}
	
	public List<String> getIdTrabajadores() {
		List<Trabajador> pri = getTrabajadores();
		List<String> ars = new ArrayList<>();
		for(int i=0; i<pri.size();i++){
			if(!verificarSecretaria(pri.get(i).getTrabajadorPK().getIdTrabajador())){
				ars.add(pri.get(i).getTrabajadorPK().getIdTrabajador());
			}
		}
		return ars;
		
	}
	public Boolean verificarTrabajador(String id, String password) {
		if(getTrabajadorById(id).getClaveUsuario().equals(password)){
			return true;
		}else{
			return false;
		}			
	}
	
	public Boolean verificarJefe(String id, String password) {
		if(getTrabajadorById(id).getClaveUsuario().equals(password)){
			return true;
		}else{
			return false;
		}			
	}
	
	public Boolean verificarSecretaria(String id) {
		if(getRol(getTrabajadorById(id).getUsuario().getIdUsuario()).getIdRol()==2){
			return true;
		}else{
			return false;
		}			
	}

	private Rol getRol(Integer idUsuario) {
		objJpaUtil =  new JPAUtil();
		rolUsuarioDAO = new RolUsuarioDAO(objJpaUtil.getEntityManager());
		rolUsuario = rolUsuarioDAO.getRolUsuariobyIdUsuario(idUsuario);
		return rolUsuario.getIdRol();
	}
}
