package listaEncadeada;

import entidades.Venda;

public class NoVenda {
	private Venda elemento;
	private NoVenda proximo;
	

	public NoVenda(Venda elemento) {
		super();
		this.elemento = elemento;
		this.proximo = null;
	}

	public NoVenda(Venda elemento, NoVenda proximo) {
		super();
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public Venda getElemento() {
		return elemento;
	}

	public void setElemento(Venda elemento) {
		this.elemento = elemento;
	}

	public NoVenda getProximo() {
		return proximo;
	}

	public void setProximo(NoVenda proximo) {
		this.proximo = proximo;
	}
}
