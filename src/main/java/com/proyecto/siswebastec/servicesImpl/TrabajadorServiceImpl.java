package com.proyecto.siswebastec.servicesImpl;

import java.util.List;

import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.DAO.TrabajadorDAO;
import com.proyecto.siswebastec.DAO.UsuarioDAO;
import com.proyecto.siswebastec.model.Trabajador;
import com.proyecto.siswebastec.model.Usuario;
import com.proyecto.siswebastec.services.TrabajadorService;

public class TrabajadorServiceImpl implements TrabajadorService{

	TrabajadorDAO trabajadorDAO;
	JPAUtil objJpaUtil;
	Trabajador trabajador;
	
	public TrabajadorServiceImpl() {
		super();
		objJpaUtil = new JPAUtil();
		trabajadorDAO =  new TrabajadorDAO(objJpaUtil.getEntityManager());
		trabajador = new Trabajador();
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
	
	public Boolean verificarTrabajador(String id, String password) {
		if(getTrabajadorById(id).getClaveUsuario().equals(password)){
			return true;
		}else{
			return false;
		}			
	}
}
