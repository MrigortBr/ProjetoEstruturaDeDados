package entidades;

import java.util.Date;

public class Produto {
	private int id;
	private String nome;
	private String peso;
	private String validade;
	private String producao;
	private float preco;
	private float desconto;
	private int estoque;
	
	public Produto(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	public Produto(int id, String nome, String peso, String validade, String producao, float preco, float desconto,int estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.validade = validade;
		this.producao = producao;
		this.preco = preco;
		this.desconto = desconto;
		this.estoque = estoque;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public String getProducao() {
		return producao;
	}
	public void setProducao(String producao) {
		this.producao = producao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
}
