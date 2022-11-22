package interfaces;

import java.util.ArrayList;

import entidades.Produto;

public interface IProdutoServico {
	public boolean adicionar(String nome, String peso, String validade, String producao, float preco, float desconto,int estoque); 
	public ArrayList<Produto> listar(); 
	public boolean deletar(); 
	public void atualizar(int id, Produto produto);
	
	public ArrayList<Produto> listarPorNome(String nome);
	public Produto listarPorId(int id);
	
	public boolean deletarEspecifico(int id);

	
}
