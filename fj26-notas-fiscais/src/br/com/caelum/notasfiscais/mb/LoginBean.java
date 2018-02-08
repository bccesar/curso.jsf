package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Event<Usuario> eventoLogin;
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	private UsuarioDao dao;
	
	public String efetuaLogin(){
		
		boolean loginValido = dao.existe(usuario);
		System.out.println("O login era valido ? " + loginValido );
		
		if(loginValido){
			usuarioLogado.logar(usuario);
			eventoLogin.fire(usuario);
			return "produto?faces-redirect=true";
		}
		else{
			this.usuario = new Usuario();
			usuarioLogado.deslogar();
			return "login";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	
}
