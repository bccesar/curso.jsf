package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named @RequestScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private List<Produto> produtos;
	private Double totalPreco = 0d;
	@Inject
	private ProdutoDao dao;
	

	public Double getTotalPreco() {
		
		totalPreco = 0d;
		if(produtos != null){
			for (Produto produto : produtos) {
				totalPreco += produto.getPreco();
			}
		}
		
		return totalPreco;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	public void grava(){
		
		System.out.println("sera q vai passar por aqui?");
		
		if(this.produto.getId() == null){
			dao.adiciona(produto);
		}
		else{
			dao.atualiza(produto);
		}
		
		this.produto = new Produto();
		produtos = dao.listaTodos();
		getTotalPreco();
	}
	
	
	public List<Produto> getProdutos(){
		
		System.out.println("chamou o getProdutos");

		if(produtos == null){
			produtos =  dao.listaTodos();
		}
		return produtos;
	}
	
	public void remove(Produto produto){
		
		dao.remove(produto);
		produtos = dao.listaTodos();
		getTotalPreco();
	}
	
	
}
