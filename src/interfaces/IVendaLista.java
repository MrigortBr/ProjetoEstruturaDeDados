package interfaces;

import java.util.ArrayList;

import entidades.Venda;

public interface IVendaLista {
	public boolean adicionar(Venda venda);
	public ArrayList<Venda> listar();
}
