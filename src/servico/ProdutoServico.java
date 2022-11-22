package servico;

import java.util.ArrayList;

import entidades.Produto;
import interfaces.IProdutoLista;
import interfaces.IProdutoServico;
import listaEncadeada.ListaProduto;

public class ProdutoServico implements IProdutoServico{
	IProdutoLista repositorio = new ListaProduto();
	
	
	@Override
	public boolean adicionar(String nome, String peso, String validade, String producao, float preco, float desconto,int estoque) {
		int id = criarId(repositorio.listar());
	
		Produto produto = new Produto(id, nome, peso, validade, producao, preco, desconto, estoque);
		System.out.println(produto);
		repositorio.adicionar(produto);
		return true;
	}
	
	private int criarId(ArrayList<Produto> produtos) {
		int id = 0;
		try {
			for (Produto produto: produtos) {
				id = produto.getId()+1;
			}
		} catch (Exception e) {
			id = 1;
		}

		
		return id;
	}

	@Override
	public ArrayList<Produto> listar() {
		return repositorio.listar();
	}

	@Override
	public boolean deletar() {
		return repositorio.deletar();
	}

	@Override
	public void atualizar(int id, Produto produto) {
		
	}

	@Override
	public ArrayList<Produto> listarPorNome(String nome) {
		return repositorio.listarPorNome(nome);
	}

	@Override
	public Produto listarPorId(int id) {
		return repositorio.listarPorId(id);
	}

	@Override
	public boolean deletarEspecifico(int id) {
		return repositorio.deletarEspecifico(id);
	}


	
	
}
