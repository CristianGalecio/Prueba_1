package com.proyecto.siswebastec.services;

import java.util.List;

import com.proyecto.siswebastec.model.Usuario;

public interface UsuarioService {
	
	public void addUsuario(Usuario usuario);	
	public void updateUsuario(Usuario usuario);
	public void deleteUsuario(Usuario usuario);	
	public Usuario getUsuarioById(int id);	
	public List<Usuario> getUsuarios();	
	public Boolean verificarUsuario(int id, String password);

}
