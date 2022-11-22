package listaEncadeada;

import java.util.ArrayList;

import entidades.Venda;
import interfaces.IVendaLista;

public class ListaVenda implements IVendaLista{
	private NoVenda inicio;
	private NoVenda fim;
	private int tamanho;
	
	@Override
	public boolean adicionar(Venda venda) {
		NoVenda no = new NoVenda(venda);
		try {
			if (this.tamanho == 0) {
				this.inicio = no;
			}else {
				this.fim.setProximo(no);
			}
			System.out.println(tamanho);
			this.fim = no;
			this.tamanho++;		
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Venda> listar() {
		NoVenda atual = inicio;
		ArrayList<Venda> resposta = new ArrayList<Venda>();
		System.out.println(tamanho);
		if (this.tamanho ==0) {
			return null;
		}
		
		for (int i = 0; i < this.tamanho; i++) {
			Venda venda = atual.getElemento();
			resposta.add(venda);
			atual = atual.getProximo();
		}
			
		return resposta;
	}

}
