package com.proyecto.siswebastec.servicesImpl;

import com.proyecto.siswebastec.model.Cliente;
import com.proyecto.siswebastec.model.Trabajador;
import com.proyecto.siswebastec.services.ClienteService;
import com.proyecto.siswebastec.services.LoginService;
import com.proyecto.siswebastec.services.TrabajadorService;
import com.proyecto.siswebastec.services.UsuarioService;

public class LoginServiceImpl implements LoginService{

	TrabajadorService trabajadorService;
	ClienteService clienteService;
	
	
	public LoginServiceImpl() {
		super();
		trabajadorService = new TrabajadorServiceImpl();
		clienteService = new ClienteServiceImpl();
	}

	public String DevolverTipoUsuario(String usuario, String password){
		Trabajador trabajador = trabajadorService.getTrabajadorById(usuario);
		Cliente cliente = clienteService.getClienteById(usuario);
		if (trabajador != null){
			return "trabajador";
		}
		if(cliente != null){
			return "cliente";
		}else{
			
			return "ninguno";
		}
	}

}
