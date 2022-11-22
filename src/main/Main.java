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
import interfaces.IVendaServico;
import listaEncadeada.ListaVenda;
import servico.ProdutoServico;
import servico.VendaServico;

public class Main {
	private static String inputA = " ";
	private static String inputB = " ";
	private static String inputC = " ";
	private static Scanner input = new Scanner(System.in);
	private static IProdutoServico produtoServico = new ProdutoServico();
	private static IVendaServico vendaServico = new VendaServico();


	public static void main(String[] args) {
		produtoServico.adicionar("Produto", "15ml", "10/12/2022", "10/12/2022", 10, 0, 40);
		Produto produto = produtoServico.listarPorId(1);
	
		vendaServico.adicionar(produto, produto.getPreco(),  produto.getDesconto(), produto.getPreco() * (produto.getDesconto()/100), 5);

		menuPrincipal();
	}
	private static void menuPrincipal() {
		inputA = " ";
		inputB = " ";
		inputC = " ";
		ArrayList<String> respostaMenu = new ArrayList<String>();
		System.out.println("----------------MENU MERCADO----------------");
		System.out.println("1 - Produto");
		respostaMenu.add("1");
		respostaMenu.add("produto");
		System.out.println("2 - Venda");
		respostaMenu.add("2");
		respostaMenu.add("venda");
		pedirOpcaoA(respostaMenu);
		
		switch (inputA) {
		case "1", "produto": {
			menuProduto();
			break;
		}
		case "2", "venda": {
			menuVenda();
			break;
		}

		}
		
		
		
	}	
	
	//Funções do menu Produto	
	private static void menuProduto() {
		System.out.println("----------------MENU PRODUTO----------------");
		System.out.println("1 - Adicionar");
		System.out.println("2 - Listar");
		System.out.println("3 - Deletar");
		System.out.println("4 - Atualizar");
		System.out.println("5 - Proucurar por id");
		System.out.println("6 - Proucurar por nome");
		System.out.println("7 - Voltar");
		ArrayList<String> respostaMenu = new ArrayList<String>();
		respostaMenu.add("1");
		respostaMenu.add("2");
		respostaMenu.add("3");
		respostaMenu.add("4");
		respostaMenu.add("5");
		respostaMenu.add("6");
		respostaMenu.add("7");
		pedirOpcaoA(respostaMenu);
		
		switch(inputA) {
			case "1":{
				adicionarProduto();
				break;
			}
			case "2":{
				listaProdutos(1);
				break;
			}
			case "3":{
				deletar();
				break;
			}
			case "4":{
				atualizar();
				break;
			}
			case "5":{
				proucurarPorId();
				break;
			}
			case "6":{
				proucurarPorNome();
				break;
			}
			
			case "7":{
				voltar(1);
				break;
			}
			
		}
		menuPrincipal();

		
	}
	private static void proucurarPorNome() {
		System.out.println("----------------Busca de Produtos----------------");
		ArrayList<Produto> produtos = produtoServico.listar();
		ArrayList<String> resposta = new ArrayList<String>();
		if (produtos != null) {
			for (Produto produto: produtos) {
				resposta.add((produto.getNome()));	
			}
			System.out.println("Escolha o nome do produto");
			pedirOpcaoA(resposta);
			produtos = produtoServico.listarPorNome(inputA);
			if(produtos != null) {
				for (Produto produto: produtos) {
					String resultado = String.format("Id: %s Nome: %s Peso: %s Preço: %s Desconto: %s % Data de validade: %s Data de produção %s Estoque: %s", produto.getId(), produto.getNome(), produto.getPeso(), produto.getPreco(), produto.getDesconto(), produto.getValidade(), produto.getProducao(), produto.getEstoque());
					System.out.println(resultado);
				}
			}else {
				System.out.println("Não existe produtos registrados com este nome");
			}
		}else {
			System.out.println("Não existe produtos registrados");
		}
	}
	private static void proucurarPorId() {
		System.out.println("----------------Busca de Produtos----------------");
		ArrayList<Produto> produtos = produtoServico.listar();
		ArrayList<String> resposta = new ArrayList<String>();
		if (produtos != null) {
			for (Produto produto: produtos) {
				resposta.add(Integer.toString(produto.getId()));	
			}
			System.out.println("Escolha o Id do produto");
			pedirOpcaoA(resposta);
			Produto produto = produtoServico.listarPorId(Integer.parseInt(inputA));
			String resultado = String.format("Id: %s Nome: %s Peso: %s Preço: %s Desconto: %s  Data de validade: %s Data de produção %s Estoque: %s", produto.getId(), produto.getNome(), produto.getPeso(), produto.getPreco(), produto.getDesconto(), produto.getValidade(), produto.getProducao(), produto.getEstoque());
			System.out.println(resultado);
		}else {
			System.out.println("Não existe produtos registrados");
		}
	}
	private static void atualizar() {
		System.out.println("----------------Atualizar Produto----------------");
		ArrayList<Produto> produtos = produtoServico.listar();
		ArrayList<String> resposta = new ArrayList<String>();
		if (produtos != null) {
			for (Produto produto: produtos) {
				String resultado = String.format("Id: %s Nome: %s Peso: %s Preço: %s Desconto: %s  Data de validade: %s Data de produção %s Estoque: %s", produto.getId(), produto.getNome(), produto.getPeso(), produto.getPreco(), produto.getDesconto(), produto.getValidade(), produto.getProducao(), produto.getEstoque());
				System.out.println(resultado);
				resposta.add(Integer.toString(produto.getId()));
			}
		}else {
			System.out.println("Não existe produtos registrados");
		}
		System.out.println("Escolha o produto pelo id");
		pedirOpcaoA(resposta);
		
		Produto produto = produtoServico.listarPorId(Integer.parseInt(inputA));
		while (!inputA.equals("8")) {
			System.out.println("Escolha qual campo deseja alterar: ");
			System.out.println("1- Nome:"+ produto.getNome());
			System.out.println("2- Peso/Tamamho:" + produto.getPeso());
			System.out.println("3- data de Validade:" + produto.getValidade());
			System.out.println("4- Data de Producao:" + produto.getProducao());
			System.out.println("5- Preco:" + produto.getPreco());
			System.out.println("6- desconto:" + produto.getDesconto());
			System.out.println("7- estoque:" + produto.getEstoque());
			System.out.println("8- Concluir");
			
			resposta.add("1");
			resposta.add("2");
			resposta.add("3");
			resposta.add("4");
			resposta.add("5");
			resposta.add("6");
			resposta.add("7");
			resposta.add("8");
			
			pedirOpcaoA(resposta);
			
			switch(inputA) {
			case "1":{			
				pedirOpcaoC("String");
				produto.setNome(inputC);
				break;
	
			}
			case "2":{
				pedirOpcaoC("String");
				produto.setPeso(inputC);
				break;
	
			}
			case "3":{
				pedirOpcaoC("String");
				produto.setValidade(inputC);
				break;
	
			}
			case "4":{
				pedirOpcaoC("String");
				produto.setProducao(inputC);
				break;
	
			}
			case "5":{
				pedirOpcaoC("String");
				produto.setPreco(Float.parseFloat(inputC));
	
				break;
	
			}
			case "6":{
				pedirOpcaoC("String");
				produto.setDesconto(Float.parseFloat(inputC));
	
				break;
	
			}	
			case "7":{
				pedirOpcaoC("String");
				produto.setEstoque(Integer.parseInt(inputC));
	
				break;
			}
			case "8":{
				voltar(2);
				break;
	
			}
			}
		}
		
	}
	private static void deletar() {
		ArrayList<String> resposta = new ArrayList<String>();
		System.out.println("----------------Deletar Produtos----------------");
		System.out.println("1 - Deletar todos produtos");
		System.out.println("2 - Deletar produto Especifico");
		resposta.add("1");
		resposta.add("2");
		pedirOpcaoA(resposta);
		switch (inputA) {
		case "1": {
			produtoServico.deletar();
			break;
			}
		case "2":{
			ArrayList<Produto> produtos = produtoServico.listar();
			resposta = new ArrayList<String>();
			if (produtos != null) {
				for (Produto produto: produtos) {
					resposta.add(Integer.toString(produto.getId()));	
				}
				System.out.println("Escolha o Id do produto");
			}
			pedirOpcaoA(resposta);
			if (produtoServico.deletarEspecifico(Integer.parseInt(inputA)) == true) {
				System.out.println("Produto deletado com sucesso");
			}else {
				System.out.println("Produto não deletado tente novamente");
			}	
		}
		}		
	}
	private static void listaProdutos(int i) {
		if (i == 1){
			
			System.out.println("----------------Lista de produtos----------------");
			ArrayList<Produto> produtos = produtoServico.listar();
			if (produtos != null) {
				for (Produto produto: produtos) {
					String resultado = String.format("Id: %s Nome: %s Peso: %s Preço: %s Desconto: %s Data de validade: %s Data de produção %s Estoque: %s", produto.getId(), produto.getNome(), produto.getPeso(), produto.getPreco(), produto.getDesconto(), produto.getValidade(), produto.getProducao(), produto.getEstoque());
					System.out.println(resultado);
				}
			}else {
				System.out.println("Não existe produtos registrados");
			}
		}
	}
	private static void adicionarProduto() {
		System.out.println("----------------Adicionar Produto----------------");
		
		System.out.println("Nome:");
		pedirOpcaoC("string");
		String nome = inputC;
		
		System.out.println("Peso/Tamamho:");
		inputC = "";
		pedirOpcaoC("string");
		String peso = inputC;
		
		System.out.println("data de Validade:");
		inputC = "";
		pedirOpcaoC("string");
		String validade =inputC;
		
		System.out.println("Data de Producao:");
		inputC = "";
		pedirOpcaoC("string");
		String producao =inputC;
		
		System.out.println("Preco:");
		inputC = "";
		pedirOpcaoC("string");
		float preco = Float.parseFloat(inputC);
		
		System.out.println("desconto:");
		inputC = "";
		pedirOpcaoC("string");
		float desconto = Float.parseFloat(inputC);
		
		System.out.println("estoque:");
		inputC = "";
		pedirOpcaoC("string");
		int estoque = Integer.parseInt(inputC);
		
		boolean resultado = produtoServico.adicionar(nome, peso, validade, producao, preco, desconto, estoque);
		if (resultado == true) {
			System.out.println("Produto Registrado com sucesso.");
			inputA = "";
			inputB = "";
			inputC = "";
			menuPrincipal();
		}else {
			System.out.println("erro ao registrar produto tente novamente.");
			inputA = "";
			inputB = "";
			inputC = "";
			menuPrincipal();

		}
	}
	
	//Funções do menu Venda	
	private static void menuVenda() {
		System.out.println("----------------MENU VENDA----------------");
		System.out.println("1 - Realizar Venda");
		System.out.println("2 - Listar Vendas");
		ArrayList<String> respostaMenu = new ArrayList<String>();
		respostaMenu.add("1");
		respostaMenu.add("2");
		pedirOpcaoA(respostaMenu);
		
		switch (inputA) {
			case "1":{
				realizarVenda();
				break;
			}
			case "2":{
				listarVendas();
				break;
			}
			case "3":{
				voltar(1);
				break;
			}
		}
		menuPrincipal();
	}

	
	private static void realizarVenda() {
		System.out.println("----------------Realizar Venda----------------");
		System.out.println("Digite o id do produto da venda: ");
		float precoFinal = 0;
		ArrayList<Venda> venda = new ArrayList<Venda>();
		boolean finalizado = false;
		pedirOpcaoC("int");

		while (finalizado == false) {
			Produto produto = produtoServico.listarPorId(Integer.parseInt(inputC));
			System.out.println("Digite a quantidade: ");
			pedirOpcaoC("int");
			
			vendaServico.adicionar(produto, produto.getPreco(),  produto.getDesconto(), produto.getPreco() * (produto.getDesconto()/100), Integer.parseInt(inputC));
					
			System.out.println("Caso Deseje colocar mais um produto na compra Digite seu id caso contrario digite 0");
			pedirOpcaoC("int");
			
			switch(inputC) {
				case "0":{
					finalizado = true;
				}
			}
		}

		
		
		
	}
	private static void listarVendas() {
		System.out.println("----------------Listando Vendas----------------");
		ArrayList<Venda> vendas = vendaServico.listar();
		
		for (Venda venda : vendas) {
			String resposta = String.format("Produto %s, preco %s, desconto %s, preco Final %s, quantidade %s, data da compra %s", venda.getProduto().getNome(), venda.getPreco(), venda.getDesconto(), venda.getPrecofinal(), venda.getQuantidade(), venda.getDataCompra());
			System.out.println(resposta);
		}

	}
	
	
	//Funções principais	
	private static void voltar(int i) {
		inputA = "";
		inputB = "";
		inputC = "";
		System.out.println(i);
		if (i == 1) {
			menuPrincipal();
		}else if(i == 2){
			menuProduto();
		}else if (i == 3) {
			menuVenda();
		}	
	}
	
	private static void pedirOpcaoA(ArrayList<String> patterns) {
		boolean result = false;
		
		while (result == false) {
			System.out.print("Opção: ");
			String respostaUsuario = input.next();
			for (String pattern: patterns) {
				
				if (respostaUsuario.toLowerCase().equals(pattern)) {
					inputA = respostaUsuario.toLowerCase();
					result = true;
				}
			}
			
			if (result == false) {
				System.out.println("Valor incorreto digite o valor correto: ");
			}
		}

	}

	
	private static void pedirOpcaoB() {
		boolean result = false;
		
		while (result == false) {
			System.out.print("Opção: ");
			String respostaUsuario = input.next();
				if (!respostaUsuario.isBlank()) {
					inputB = respostaUsuario;
					result = true;
			}	
			if (result == false) {
				System.out.println("Valor incorreto digite o valor correto: ");
			}
		}

	}
	
	private static void pedirOpcaoC(String type) {
		boolean result = false;
		while (result == false) {
			System.out.print("Opção: ");
			String respostaUsuario = input.next();

				if (type.toLowerCase().equals("string")) {
						inputC = respostaUsuario.toLowerCase();
						result = true;
					
				}else if (type.toLowerCase().equals("float")) {
					try {
						float teste =Float.parseFloat(respostaUsuario);
						inputC = respostaUsuario;
						result = true;
					} catch (Exception e) {	
					}

				}else if (type.toLowerCase().equals("int")) {
					try {
						int teste =Integer.parseInt(respostaUsuario);
						inputC = respostaUsuario;
						result = true;
					} catch (Exception e) {
					}
				}
					
			
			if (result == false) {
				System.out.println("Valor incorreto digite o valor correto: ");
			}
		}
	}
}
