package FuncaoFuncionario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Entidades.Item;
import Entidades.Loja;
import Interface.GerenteInterface;
import Pessoas.Cliente;
import Pessoas.Gerente;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenteFuncoes extends Gerente implements GerenteInterface {

	Scanner input = new Scanner(System.in);
	Loja loja = new Loja();

	public GerenteFuncoes() {
	}

	@Override
	public void cadastrarProduto() {
		for (String verificarCadastroDeProduto = "sim"; verificarCadastroDeProduto.equalsIgnoreCase("sim");) {
			System.out.print("Digite o c�digo de Lote: ");
			int codigoLote = input.nextInt();
			
			System.out.print("Digite a validade do Lote");
			String validadeLote = input.next();
			
			System.out.println("Digite a quantidade do Lote");
			int quantidadeLote = input.nextInt();
			
			System.out.println("Digite a quantidade do Lote");
			String categoria = input.next();
			
			System.out.print("Digite o Codigo para este produto: ");
			int codigoProduto = input.nextInt();

			System.out.print("Digite a marca deste produto: ");
			String marca = input.next();

			System.out.print("Digite o nome para este produto: ");
			String nome = input.next();

			System.out.print("Digite o preco de Venda para este produto: ");
			double precoVenda = input.nextDouble();
			System.out.print("Digite a quantidade em estoque: ");
			int quantidadeDoProduto = input.nextInt();

			loja.adicionarProdutos(codigoLote, validadeLote, quantidadeLote, categoria, codigoProduto, marca, nome,
					precoVenda, quantidadeDoProduto);

			System.out.println("Caso deseje cadastrar algum novo produto digite sim");
			verificarCadastroDeProduto = input.next();
		}

	}

	@Override
	public void cadastrarVenda() {
		int codigoVenda = 100;
		for (String verificarCadastroVendas = "sim"; verificarCadastroVendas.equalsIgnoreCase("sim");) {

			// Lista de itens de uma venda;
			List<Item> itemVenda = new ArrayList<>();

			// Cadastro dos itens de uma venda;
			int verificaSeAddProduto = 0;
			int verificaAchaProduto = 0;
			for (String verificarVenda = "sim"; verificarVenda.equalsIgnoreCase("sim");) {

				System.out.println("Digite o Codigo do produto a ser Vendido");
				int codigoProduto = input.nextInt();

				// Verifica se o produto esta no estoque e faz o cadastro de um item na venda
				for (int x = 0; x < loja.produto.size(); x++) {
					if ((loja.produto.get(x).getCodigo() == codigoProduto)) {
						verificaAchaProduto++;
						if ((loja.produto.get(x).getQuantidadeDoProduto() > 0)) {
							System.out.println("Digite a quantidade de itens deste produto: ");
							int quantidadeItensVendidos = input.nextInt();
							if (loja.produto.get(x).getQuantidadeDoProduto() >= quantidadeItensVendidos) {
								itemVenda.add(new Item(loja.produto.get(x), quantidadeItensVendidos));
								verificaSeAddProduto++;
							}

						} else {
							System.out.println("Quantidade de produtos indisponivel no estoque");
							break;
						}

					}
				}

				if (verificaAchaProduto == 0)
					System.out.println("Produto inexistente no sistema");
				;

				// verifica se quer mais algum item
				System.out.println("Deseja cadastrar mais algum item, digite sim para continuar: ");
				verificarVenda = input.next();

			}
			// Verifica Cadastro de Cliente;
			System.out.println("Digite o codigo do cliente");
			String codigoCliente = input.next();
			int verificadorCliente = 0;
			// LEMBRAR DA DATA _'OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO;
			// Date d= new Date();
			// String dataVenda =
			// java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
			for (Cliente cliente : loja.cliente) {
				if ((codigoCliente.equalsIgnoreCase(cliente.getCpf())) && (verificaSeAddProduto > 0)) {
					loja.cadastrarVenda(codigoVenda, cliente, itemVenda);
					loja.venda.get(loja.venda.size() - 1).setQuantidadeItensVendidos(itemVenda.size());
					verificadorCliente++;
					codigoVenda++;
				}
			}

			if (verificadorCliente == 0) {
				System.out.println(
						"Cliente ainda nao cadastrado, digite sim para cadastrar o cliente e volte ao Item Venda ou nao realiza a venda");

				if (verificaSeAddProduto == 0)
					System.out.println("Venda Nao Concluida ");

				String verificarCadastro = input.next();
				if (verificarCadastro.equalsIgnoreCase("sim"))
					cadastrarCliente();
				else
					System.out.println("E preciso cadastrar um cliente para realizar uma venda");
			}

			System.out.println("Deseja Continuar Adiiconando Vendas, digite sim para continuar:");
			verificarCadastroVendas = input.next();
		}
	}

	@Override
	public void cadastrarCliente() {
		System.out.println("Cadastro de  Cliente: ");
		for (String verificarCadastroCliente = "sim"; verificarCadastroCliente.equalsIgnoreCase("sim");) {
			System.out.println("Digite o Codigo do cliente: ");
			String codigoCliente = input.next();

			System.out.println("Digite o nome deste Cliente: ");
			String nome = input.next();

			System.out.println("Digite o dia");
			int dia = input.nextInt();

			System.out.println("Digite o mes(em algoritimo");
			int mes = input.nextInt();

			System.out.println("O ano de nascimento");
			int ano = input.nextInt();

			System.out.println("Digite o email do cliente");
			String email = input.next();
			// LEMBRAR DE ALTERAR TA ERRADOOOOOOOOOOOOOOOO
			Date dataNasc = new Date("Dia/mes/ano");
			loja.cadastrarCliente(codigoCliente, nome, dataNasc, email);

			System.out.println("Se desejar cadastrar mais algum cliente digite sim");
			verificarCadastroCliente = input.next();
		}

	}

	@Override
	public void excluirProduto() {
		System.out.println("Digite o codigo do produto a ser excluido");
		int produtoExcluir = input.nextInt();
		loja.excluirProduto(produtoExcluir);

	}

	@Override
	public void excluirCliente(){
		System.out.println("Digite o Cpf do cliente a ser excluido: ");
		String codigoVerificarCpfCliente = input.next();
            try {
                loja.excluirCliente(codigoVerificarCpfCliente);
            } catch (ParseException ex) {
                Logger.getLogger(GerenteFuncoes.class.getName()).log(Level.SEVERE, null, ex);
            }

	}

	@Override
	public void listarProdutoPorCategoria() {
		String categoria = input.next();
		loja.listarProdutosporCategoria2(categoria);

	}

	@Override
	public void listarPromocoes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarProdutosCadastrados() {
		loja.listarProdutosCadastrados();

	}

	@Override
	public void listarProdutosExcluidos() {
		loja.listarProdutoExcluido();

	}

	@Override
	public void listarProdutosDisponiveisNoEstoque() {
		loja.listarProdutoDisponivelNoEstoque();

	}

	@Override
	public void listarClientesExcluidos() {
		loja.listarClientesExcluidos();
	}

	@Override
	public void listarCompraPorNotaFiscal() {
		System.out.println("Digite o codigo do cliente a ser verificado");
		String codigoVerificarCliente = input.next();
		loja.listarVendaCliente(codigoVerificarCliente);

		System.out.println("===================");

	}

	@Override
	public void listarVendas() {
		loja.listarVendas();
	}

	@Override
	public void verificarVendas() {
		System.out.println("Deseja saber o informacoes de alguma venda, digite sim para continuar");
		String verificarInformacoesDaVenda = input.next();
		if (verificarInformacoesDaVenda.equalsIgnoreCase("sim")) {
			// Verifica Codigo Venda
			System.out.println("Digite o codigo da venda");
			int codigoTesteVenda = input.nextInt();
			int contarCodigoVenda = 0;
			for (int i = 0; i < loja.venda.size(); i++) {
				// Procura o codigo na lista, e printa quando encontrar
				if (loja.venda.get(i).getCodigoVenda() == codigoTesteVenda) {
					loja.venda.get(i).imprimir();
					contarCodigoVenda++;
				}

			}

			if (contarCodigoVenda == 0)
				System.out.println("Nao ha venda com esse codigo");
		}
	}

}
