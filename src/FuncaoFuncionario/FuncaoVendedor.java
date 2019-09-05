package FuncaoFuncionario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Entidades.Item;
import Entidades.Loja;
import Interface.VendendorInterface;
import Pessoas.Cliente;
import Pessoas.Pessoa;
import Pessoas.Vendedor;

public class FuncaoVendedor extends Vendedor implements VendendorInterface {

	Scanner input = new Scanner(System.in);
	Loja loja = new Loja();
	
	public FuncaoVendedor() {
		
	}
	public FuncaoVendedor(String cpf, String nome, Date dataDeNascimento, String email, int codigoFuncionario) {
		super(cpf, nome, dataDeNascimento, email, codigoFuncionario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cadastrarCliente() {
		//cadastro de cliente
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
	public void listarPordutoporCategoria() {
		// Lista Produtos Por categoria
		String categoria = input.next();
		loja.listarProdutosporCategoria2(categoria);
	}

	@Override
	public void listarPromocoes() {
		// Ainda vamos implementar

	}

	@Override
	public String listarProdutosCadastrados() {
		//Lista Produtos Cadastrados
		return loja.listarProdutosCadastrados();
	}

        
        

	@Override
	public void vender() {
		// Fazendo a venda
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
							
						}else {
							System.out.println("Quantidade de produtos indisponivel no estoque");
							break;
						}

					}	
				}

				if(verificaAchaProduto == 0)
					System.out.println("Produto inexistente no sistema");;
				
				// verifica se quer mais algum item
				System.out.println("Deseja cadastrar mais algum item, digite sim para continuar: ");
				verificarVenda = input.next();

			}
			// Verifica Cadastro de Cliente;
			System.out.println("Digite o codigo do cliente");
			String codigoCliente = input.next();
			int verificadorCliente = 0;
			
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
    public String ListarProdutosDisponiveis() {
        return loja.listarProdutoDisponivelNoEstoque();//To change body of generated methods, choose Tools | Templates.
    }

}
