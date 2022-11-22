package servico;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import entidades.Produto;
import entidades.Venda;
import interfaces.IVendaLista;
import interfaces.IVendaServico;
import listaEncadeada.ListaVenda;

public class VendaServico implements IVendaServico{
	IVendaLista repositorio = new ListaVenda();
	
	@Override
	public boolean adicionar(Produto produto, float preco, float desconto, float precofinal, int quantidade) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar dataAtual = Calendar.getInstance();
		
		String data = formatter.format(dataAtual.getTime());
		
		Venda venda = new Venda(produto, preco, desconto, precofinal, quantidade, data);	
		return repositorio.adicionar(venda);

	}

	@Override
	public ArrayList<Venda> listar() {
		return repositorio.listar();
	}
	
}
