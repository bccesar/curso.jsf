package br.com.caelum.notasfiscais.listener;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.util.EmailComercial;
import br.com.caelum.notasfiscais.util.EmailFinanceiro;


public class LoginListener {

	@Inject @EmailComercial
	private String emailC;
	
	@Inject @EmailFinanceiro
	private String emailF;
	
	
	public void onLogin(@Observes Usuario usuario){
		System.out.printf("Usuario [%s] se logou no sistema, email para [%s]", usuario.getLogin(), emailC);
		System.out.printf("Usuario [%s] se logou no sistema, email para [%s]", usuario.getLogin(), emailF);
	}
	
}
