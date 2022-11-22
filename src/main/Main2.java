package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import entidades.Produto;
import entidades.Venda;
import interfaces.IProdutoServico;
import interfaces.IVendaLista;
import listaEncadeada.ListaVenda;
import servico.ProdutoServico;

public class Main {
	private static String inputA = " ";
	private static String inputB = " ";
	private static String inputC = " ";
	private static Scanner input = new Scanner(System.in);
	private static IProdutoServico produtoServico = new ProdutoServico();
	private static IVendaLista vendaLista = new ListaVenda();

	public static void main(String[] args) {
		produtoServico.adicionar("Produto", "15ml", "10/12/2022", "10/12/2022", 10, 0, 40);
		produtoServico.adicionar("Produto2", "15ml", "10/12/2022", "10/12/2022", 10, 0, 40);

		Produto produto = produtoServico.listarPorId(1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar dataAtual = Calendar.getInstance();
		
		String data = formatter.format(dataAtual.getTime());

		Venda venda = new Venda(produto, 40, 50, 30, 10, data);
		Venda venda2 = new Venda(produto, 40, 31313113, 30, 10, data);
		
		vendaLista.adicionar(venda2);
		vendaLista.adicionar(venda);
		
		ArrayList<Venda> ve = vendaLista.listar();
		
		for (Venda venda3 : ve) {
			System.out.println(venda3.getDesconto());
		}

	}
}