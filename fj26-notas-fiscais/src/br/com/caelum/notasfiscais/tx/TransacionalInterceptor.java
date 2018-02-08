package br.com.caelum.notasfiscais.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transacional
public class TransacionalInterceptor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	@AroundInvoke
	public Object controlaTransacao(InvocationContext ctx) throws Exception{
		
		manager.getTransaction().begin();
		System.out.println("abriu transacao");
		
		Object ret = ctx.proceed();
		
		manager.getTransaction().commit();
		System.out.println("comitou transacao");
		
		return ret;
	}
	
}
