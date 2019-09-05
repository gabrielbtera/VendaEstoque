package Interface;

import java.util.Date;

public interface GerenteInterface {

	public void cadastrarProduto();

	public void cadastrarVenda();

	void cadastrarCliente();

	public void excluirProduto();

	public void excluirCliente();

	public String listarProdutoPorCategoria();

	public String listarPromocoes();

	public String listarProdutosCadastrados();

	public String listarProdutosExcluidos();

	public String listarClientesExcluidos();

	public String listarCompraPorNotaFiscal();

	public String listarVendas();
        
        public String listarCliente();

	public void verificarVendas();

	public String listarProdutosDisponiveisNoEstoque();

}
