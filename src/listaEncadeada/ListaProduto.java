package listaEncadeada;

import java.util.ArrayList;

import entidades.Produto;
import interfaces.IProdutoLista;

public class ListaProduto implements IProdutoLista{
	private NoProduto inicio;
	private NoProduto fim;
	private int tamanho;

	public boolean adicionar(Produto produto) {
		try {
			NoProduto no = new NoProduto(produto);
			if (this.tamanho == 0) {
				this.inicio = no;
			}else {
				this.fim.setProximo(no);
			}
			this.fim = no;
			this.tamanho++;
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public ArrayList<Produto> listar(){
		NoProduto atual = inicio;
		ArrayList<Produto> resposta = new ArrayList<Produto>();
		if (tamanho == 0) {
			return null;
		}
		
		for (int i = 0; i < this.tamanho; i++) { 
			Produto produto = atual.getElemento();
			resposta.add(produto);
			atual = atual.getProximo();
		}
		return resposta;
	}
	
	public boolean deletar() {
		NoProduto atual = inicio;
		NoProduto proximo = null;
		for (int i = 0; i < this.tamanho; i++) {
			proximo = atual.getProximo();
			atual.setElemento(null);
			atual.setProximo(null);
			atual = proximo;
		}
		this.tamanho = 0;
		this.inicio = null;
		this.fim = null;
		System.out.println("Todos os produtos foram deletados");	
		return true;
	}
	
	public void atualizar(int id, Produto produto) {
		NoProduto atual = inicio;
		for (int i = 0; i < this.tamanho; i++) {
			if (atual.getElemento().getId() == id) {
				atual.setElemento(produto);
			}
			atual = atual.getProximo();
		}
	}


	@Override
	public Produto listarPorId(int id) {
		NoProduto atual = inicio;
		
		if (tamanho == 0) {
			System.out.println("Não existe produtos registrados");
		}
		
		for (int i = 0; i < this.tamanho; i++) {
			Produto produto = atual.getElemento();
			if (produto.getId() == id) {
				return produto;
			}
			atual = atual.getProximo();
		}
		
		return null;
	}

	@Override
	public ArrayList<Produto> listarPorNome(String nome) {
		NoProduto atual = inicio;
		ArrayList<Produto> resposta = new ArrayList<Produto>();
		
		if (tamanho == 0) {
			System.out.println("Não existe produtos registrados");
		}
		
		for (int i = 0; i < this.tamanho; i++) {
			Produto produto = atual.getElemento();
			System.out.println(produto.getNome());
			System.out.println(nome);
			if (produto.getNome().indexOf(nome) != -1) {
				resposta.add(produto);
			}
			atual = atual.getProximo();
		}
		
		return resposta;	
	}

	@Override
	public boolean deletarEspecifico(int id) {
		try {
			NoProduto atual = inicio;
			NoProduto anterior = null;
			for (int i = 0; i < this.tamanho;i++) {
				if (atual.getElemento().getId() == id) {
					NoProduto apagar = atual;
					//Apenas altero as variaveis do ListaEncadeada
					if (atual == inicio) {
						this.inicio = atual.getProximo();
						atual = atual.getProximo();
					}else if (atual == fim) {
						this.fim = anterior;
						anterior.setProximo(null);

					}else {
						anterior.setProximo(atual.getProximo());
						atual = atual.getProximo();
					}	
					apagar.setElemento(null);
					apagar.setProximo(null);
					this.tamanho--;
				}else {
					anterior = atual;
					atual = atual.getProximo();				
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
