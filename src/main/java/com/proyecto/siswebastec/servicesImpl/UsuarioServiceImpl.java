package com.proyecto.siswebastec.servicesImpl;

import java.util.List;

import com.proyecto.siswebastec.model.Usuario;
import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.DAO.UsuarioDAO;
import com.proyecto.siswebastec.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{
	
	UsuarioDAO usuarioDAO;
	JPAUtil objJpaUtil;
	Usuario usuario;
	
	public UsuarioServiceImpl() {
		super();
		objJpaUtil = new JPAUtil();
		usuarioDAO = new UsuarioDAO(objJpaUtil.getEntityManager());
		usuario = new Usuario();
	}

	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return getUsuarioDAO().listarTodos();
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Usuario getUsuarioById(int id) {		
		usuario = usuarioDAO.getUsuarioById(id);		
		System.out.println(" usuario: " + id);
		return usuario;
	}

	public void addUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	public Boolean verificarUsuario(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
