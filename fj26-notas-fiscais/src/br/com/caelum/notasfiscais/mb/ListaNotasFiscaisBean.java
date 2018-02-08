package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@Named 
@ViewScoped
public class ListaNotasFiscaisBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private NotaFiscalDao daoNotaFiscal;
	
	private List<NotaFiscal> notasFiscais;

	
	
	public List<NotaFiscal> getNotasFiscais() {
		
		//if(notasFiscais == null){
			notasFiscais = daoNotaFiscal.listaTodos();
		//}
		
		return notasFiscais;
	}

	
	
	
}
