package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@ConversationScoped
public class NotaFiscalBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Conversation conversation;
	@Inject
	private NotaFiscal notaFiscal;
	@Inject
	private NotaFiscalDao nfDAO;
	@Inject
	private ProdutoDao prodDAO;
	
	private Long idProduto;
	@Inject
	private Item item;
	
	
	
	public Long getIdProduto() {
		return idProduto;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public void grava(){
		
		nfDAO.adiciona(notaFiscal);
		notaFiscal = new NotaFiscal();
		
	}
	
	public String finaliza(){
		
		nfDAO.adiciona(notaFiscal);
		notaFiscal = new NotaFiscal();
		conversation.end();
		return "notafiscal-wizard?=face-redirect=true";
		
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	
	
	public void adicionaItem(){
		
		Produto produto = prodDAO.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		item = new Item();
		idProduto = null;
	}
	
	public String avanca(){
		
		conversation.begin();
		return "item-wizard";
	
	}
	
}
