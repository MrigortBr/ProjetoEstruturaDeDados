package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
	private Produto produto;
	private float preco;
	private float desconto;
	private float precofinal;
	private int quantidade;
	private String dataCompra;
	

	public Venda(Produto produto, float preco, float desconto, float precofinal, int quantidade, String dataCompra) {
		super();
		this.produto = produto;
		this.preco = preco;
		this.desconto = desconto;
		this.precofinal = precofinal;
		this.quantidade = quantidade;
		this.dataCompra = dataCompra;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
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
	public float getPrecofinal() {
		return precofinal;
	}
	public void setPrecofinal(float precofinal) {
		this.precofinal = precofinal;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	
}
