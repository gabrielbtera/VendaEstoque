package Entidades;

public class Produto {
	private int codigoLote;
	private String validadeLote;// IMPLEMENTAR CALENDAR!
	private int quantidadeLote;
	private String categoria;
	private int codigoProduto;
	private String marca;
	private String nome;
	private double precoVenda;
	private int quantidadeDoProduto;

	public Produto() {
	}

	public Produto(int codigoLote, String validadeLote, int quantidadeLote, String categoria, int codigoProduto,
			String marca, String nome, double precoVenda, int quantidadeDoProduto) {
		this.codigoLote = codigoLote;
		this.validadeLote = validadeLote;
		this.quantidadeLote = quantidadeLote;
		this.categoria = categoria;
		this.codigoProduto = codigoProduto;
		this.marca = marca;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.quantidadeDoProduto = quantidadeDoProduto;
	}

	public int getCodigo() {
		return codigoProduto;
	}

	public String getMarca() {
		return this.marca;
	}

	public String getNome() {
		return nome;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQuantidadeDoProduto() {
		return quantidadeDoProduto;
	}

	public void setQuantidadeDoProduto(int quantidade) {
		this.quantidadeDoProduto = quantidade;
	}

	public void addQuantidadeDoProduto(int quantidadeAdicionada) {
		this.quantidadeDoProduto += quantidadeAdicionada;
	}

	public int getCodigoLote() {
		return codigoLote;
	}

	public void setCodigoLote(int codigoLote) {
		this.codigoLote = codigoLote;
	}

	public String getValidadeLote() {
		return validadeLote;
	}

	public void setValidadeLote(String validadeLote) {
		this.validadeLote = validadeLote;
	}

	public int getQuantidadeLote() {
		return quantidadeLote;
	}

	public void setQuantidadeLote(int quantidadeLote) {
		this.quantidadeLote = quantidadeLote;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String toString() {
		return "Codigo do lote: " + codigoLote + "\nValidade do Lote: " + validadeLote + "\nQuantidade do Lote: "
				+ quantidadeLote + "\nCategoria: " + categoria + "\nCodigo do Produto: " + codigoProduto
				+ "\nMarca do Produto: " + marca + "\nNome do Produto: " + nome + "\nPreco de Venda: " + precoVenda
				+ "\nQuantidade em estoque do Produto: " + quantidadeDoProduto;
	}

}
