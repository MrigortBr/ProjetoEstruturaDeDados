package interfaces;

import java.util.ArrayList;

import entidades.Produto;

public interface IProdutoLista {
	public boolean adicionar(Produto produto);
	public ArrayList<Produto> listar();
	public boolean deletar();
	public Produto listarPorId(int id);
	public ArrayList<Produto> listarPorNome(String nome);
	public boolean deletarEspecifico(int id);
	
}
