package listaEncadeada;

import entidades.Produto;

public class NoProduto {
	private Produto elemento;
	private NoProduto proximo;
	
	public NoProduto(Produto elemento) {
		super();
		this.elemento = elemento;
		this.proximo = null;
	}

	public NoProduto(Produto elemento, NoProduto proximo) {
		super();
		this.elemento = elemento;
		this.proximo = proximo;
	}

	public Produto getElemento() {
		return elemento;
	}
	public void setElemento(Produto elemento) {
		this.elemento = elemento;
	}
	public NoProduto getProximo() {
		return proximo;
	}
	public void setProximo(NoProduto proximo) {
		this.proximo = proximo;
	}
}
