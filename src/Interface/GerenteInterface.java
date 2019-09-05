package Interface;

import java.util.Date;

public interface GerenteInterface {

	public void cadastrarProduto();

	public void cadastrarVenda();

	void cadastrarCliente();

	public void excluirProduto();

	public void excluirCliente();

	public void listarProdutoPorCategoria();

	public void listarPromocoes();

	public void listarProdutosCadastrados();

	public void listarProdutosExcluidos();

	public void listarClientesExcluidos();

	public void listarCompraPorNotaFiscal();

	public void listarVendas();

	public void verificarVendas();

	void listarProdutosDisponiveisNoEstoque();

}
