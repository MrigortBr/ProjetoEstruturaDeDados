package interfaces;

import java.util.ArrayList;

import entidades.Produto;
import entidades.Venda;

public interface IVendaServico {
	public boolean adicionar(Produto produto, float preco, float desconto, float precofinal, int quantidade);
	public ArrayList<Venda> listar();
}
