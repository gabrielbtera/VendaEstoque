package Entidades;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Pessoas.Cliente;
import Utilitarios.ValidarCpf;

;

public class CadastroDados {

    Scanner input = new Scanner(System.in);
    Loja loja = new Loja();
    List<Integer> codigosProdutos = new ArrayList<Integer>();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    List<Produto> produto = new ArrayList<>();

    public CadastroDados() {
    }

    public void ImprimeMenu() {
        System.out.println();
        System.out.println("BEM VINDO A LOJA SHOSTNERS CABLE");
        System.out.println("========================================================");
        System.out.println("========================= MENU =========================");
        System.out.println("========================================================");
        System.out.println();
        System.out.println("1. Listar todos os produtos cadastrados\r\n"
                + "2. Listar os produtos dispon�veis no estoque\r\n"
                + "3. Listar todos os produtos esgotados no estoque\r\n"
                + "4. Aumentar a quantidade de produtos no estoque\r\n" + "5. Cadastrar um cliente\r\n"
                + "6. Listar os clientes cadastrados\r\n" + "7. Cadastrar vendas\r\n" + "8. Listar todas as vendas\r\n"
                + "9. Listar compras de um determinado cliente\r\n" + "10. Cadastrar Produtos\r\n"
                + "11. Verificar informacoes de determinada Venda\r\n" + "12. Encerrar Menu\r\n");
    }

    public void cadastroAutoClienteEProdutos() {
        Date testeData = new Date("10/10/2000");
        //loja.cadastrarCliente("89711231093", "Gabriel", testeData, "vitorti");
        //loja.cadastrarCliente("35164946033", "vitor", testeData, "Vitorteste");
        //loja.adicionarProdutos(123, "12/2019", 10, "BEBIDAS", 123, "CCE", "NotBook", 500, 50);
        //loja.adicionarProdutos(123, "12/2019", 10, "BEBIDAS", 122, "CCE", "NotBook", 500, 50);
        //loja.adicionarProdutos(123, "12/2019", 10, "BEBIDAS", 124, "CCE", "NotBook", 500, 50);
        //loja.adicionarProdutos(123, "12/2019", 10, "teste", 125, "CCE", "NotBook", 500, 50);
        // loja.adicionarProdutos(123, "CCE", "NotBook", 500, 50);
        // loja.adicionarProdutos(122, "Acer", "NotBook", 1590.90, 50);
        // loja.adicionarProdutos(124, "Azus", "NotBook", 1000, 0);
    }

    // Cadastrar Produtos;
    public void cadastroDeProdutoInput() {
        for (String verificarCadastroDeProduto = "sim"; verificarCadastroDeProduto.equalsIgnoreCase("sim");) {
            System.out.print("Digite o c�digo de Lote: ");
            int codigoLote = input.nextInt();

            System.out.print("Digite a validade do Lote");
            String validadeLote = input.next();

            System.out.println("Digite a quantidade do Lote");
            int quantidadeLote = input.nextInt();

            System.out.println("Digite a categoria");
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

    // Adicionar Produtos
    public void adicionarQuantidadeDeProdutoInput() {
        System.out.println("Digite o Codigo do produto a ser adicionado");
        int testeCodigoAdicionar = input.nextInt();
        System.out.println("Digite a quantidade de Produtos a serem adicionadas");
        int adicionarQuantidadeNoEstoque = input.nextInt();

        int verificadorProduto = 0;
        for (Produto testeCodigo : loja.produto) {
            if (testeCodigo.getCodigo() == testeCodigoAdicionar) {
                loja.addQuantidadeDeProdutos(testeCodigo, adicionarQuantidadeNoEstoque);
                System.out.println("Quantidade Adicionada Com Sucesso");
                verificadorProduto++;
            }
        }

        if (verificadorProduto == 0) {
            System.out.println("Produto nao Encontrado no Estoque");
        }
    }

    // Listagem de Produtos;
    public void listarProdutosCadastradosImput() {
        loja.listarProdutosCadastrados();
    }

    // Listar Produtos disponiveis no estoque;
    public void listarProdutosDisponiveisNoEstoqueInput() {
        loja.listarProdutoDisponivelNoEstoque();
    }

    // Listar Produtos Esgotados no Estoque;
    public void listarProdutosEsgotadosInput() {
        loja.listarProdutosEsgotados();
    }

    // Cadastro de Clientes;
    public void cadastroDeClienteImput() {
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
            // DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String pattern = "MMM dd HH:mm:ss zzzz yyyy";

            // DateFormat df = new SimpleDateFormat(pattern);
            // LocalDate data = LocalDate.parse("23/11/2015", formato);
            //String dataNasci = dia + "/" + mes + "/" + ano;
            // LocalDate date = new LocalDate.parse();

            Date dataNasc = new Date(dia + "/" + mes + "/" + ano);
            loja.cadastrarCliente(codigoCliente, nome, dataNasc, email);

            System.out.println("Se desejar cadastrar mais algum cliente digite sim");
            verificarCadastroCliente = input.next();
        }
    }

    // Listagem de Clientes;
    public void listarClienteInput() {
        loja.listarClienteCadastrados();
    }

    // Cadastro de Vendas;
    public void cadastroDasVendasInput() throws ParseException {
        int codigoVenda = 100;
        String verificaCliente;
        for (String verificarCadastroVendas = "sim"; verificarCadastroVendas.equalsIgnoreCase("sim");) {

            // Lista de itens de uma venda;
            List<Item> itemVenda = new ArrayList<>();

            // Verifica Cadastro de Cliente;
            System.out.println("Digite o codigo do cliente");
            String codigoCliente = input.next();
            int verificadorCliente = 1;

            if (ValidarCpf.isCPF(codigoCliente)) {

                int z = 0;

                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(new FileInputStream("Cliente.csv")))) {

                    String itemCsv = br.readLine();
                    while (itemCsv != null) {

                        String[] fields = itemCsv.split(",");
                        if (fields[0].equalsIgnoreCase(codigoCliente)) {
                            String data1 = new SimpleDateFormat("dd/MM/yyyy")
                                    .format(new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US).parse(fields[2]));
                            Date data = new Date(data1);
                            //Date data = formato.p;

                            loja.cliente.add(new Cliente(fields[0], fields[1], data, fields[3]));
                            z++;
                            System.out.println("aaa");
                            break;

                        }
                        //System.out.println("Cliente ainda nao cadastrado");
                        // verificaCliente = fields[0];
                        // codigoVerificarCliente.add(verificaCliente);
                        itemCsv = br.readLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }

                /*
				 * for (String x : codigoVerificarCliente) if
				 * (x.equalsIgnoreCase(codigoCliente)) { z++; break; }
                 */
                // LEMBRAR DA DATA _'OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO;
                // Date d= new Date();
                // String dataVenda =
                // java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
                /*
				 * for (Cliente cliente : loja.cliente) { if
				 * ((codigoCliente.equalsIgnoreCase(cliente.getCpf()))) {
				 * loja.cadastrarVenda(codigoVenda, cliente, itemVenda);
				 * loja.venda.get(loja.venda.size() -
				 * 1).setQuantidadeItensVendidos(itemVenda.size()); verificadorCliente++;
				 * codigoVenda++; } }
				 * 
				 * 
				 * if (verificadorCliente == 0) { System.out.println(
				 * "Cliente ainda nao cadastrado, digite sim para cadastrar o cliente e volte ao Item Venda ou nao realiza a venda"
				 * );
                 */
                // Cadastro dos itens de uma venda;
                int verificaSeAddProduto = 0;
                int verificaAchaProduto = 0;
                int x = 0;
                for (String verificarVenda = "sim"; verificarVenda.equalsIgnoreCase("sim");) {

                    System.out.println("Digite o Codigo do produto a ser Vendido");
                    int codigoProduto = input.nextInt();

                    // Verifica se o produto esta no estoque e faz o cadastro de um item na venda
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(new FileInputStream("Produto.csv")))) {

                        String itemCsv = br.readLine();
                        while (itemCsv != null) {

                            String[] fields = itemCsv.split(",");
                            Integer codigoProdutoVerificar = Integer.parseInt(fields[4]);
                            // DA PARA MELHORAR USANDO O CODIGO DO LOTE COMO REFERENCIA/ FAZER TESTES DEPOIS

                            if (z > 0) {

                                if (codigoProdutoVerificar == codigoProduto) {
                                       System.out.println("aaa");
                                    if (Integer.parseInt(fields[8]) > 0) {

                                        System.out
                                                .println("Digite a quantidade de itens deste Produto a ser vendida: ");
                                        int quantidadeItem = input.nextInt();
                                        System.out.println(Integer.parseInt(fields[8]));
                                        if (quantidadeItem <= Integer.parseInt(fields[8])) {
                                            System.out.println("teste");
                                            produto.add(new Produto(Integer.parseInt(fields[0]), fields[1],
                                                    Integer.parseInt(fields[2]), fields[3], Integer.parseInt(fields[4]),
                                                    fields[5], fields[6], Double.parseDouble(fields[7]),
                                                    Integer.parseInt(fields[8])));
                                            System.out.println("teste");
                                            itemVenda.add(new Item(produto.get(x), quantidadeItem));
                                            x++;
                                            verificaAchaProduto++;
                                        }
                                        verificaSeAddProduto++;
                                    } else {
                                        System.out.println("QUuantidade do produto nao tem no estoque");
                                    }
                                    break;

                                }
                            }
                            // codigosProdutos.add(codigoProdutoVerificar);
                            itemCsv = br.readLine();
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }

                    if (verificaAchaProduto == 0) {
                        System.out.println("Produto inexistente no sistema");
                    }

                    /*
					 * for (Integer x : codigosProdutos) if (codigoProduto == x) {
					 * 
					 * break; }
                     */
                    // while()

                    /*
					 * for (int x = 0; x < loja.produto.size(); x++) { if
					 * ((loja.produto.get(x).getCodigo() == codigoProduto)) { verificaAchaProduto++;
					 * if ((loja.produto.get(x).getQuantidadeDoProduto() > 0)) {
					 * System.out.println("Digite a quantidade de itens deste produto: "); int
					 * quantidadeItensVendidos = input.nextInt(); if
					 * (loja.produto.get(x).getQuantidadeDoProduto() >= quantidadeItensVendidos) {
					 * itemVenda.add(new Item(loja.produto.get(x), quantidadeItensVendidos));
					 * verificaSeAddProduto++; }
					 * 
					 * } else {
					 * System.out.println("Quantidade de produtos indisponivel no estoque"); break;
					 * }
					 * 
					 * } }
                     */
                    // verifica se quer mais algum item
                    System.out.println("Deseja cadastrar mais algum item, digite sim para continuar: ");
                    verificarVenda = input.next();

                }

                if (verificaSeAddProduto == 0) {
                    System.out.println("Venda Nao Concluida ");
                } else {
                    loja.cadastrarVenda(codigoVenda, loja.cliente.get(0), itemVenda);
                    System.out.println("Venda concluida");
                }

                /*
				 * // Verifica Cadastro de Cliente;
				 * System.out.println("Digite o codigo do cliente"); String codigoCliente =
				 * input.next(); int verificadorCliente = 0; // LEMBRAR DA DATA
				 * _'OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO; // Date d= new Date(); //
				 * String dataVenda = //
				 * java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d); for
				 * (Cliente cliente : loja.cliente) { if
				 * ((codigoCliente.equalsIgnoreCase(cliente.getCpf())) && (verificaSeAddProduto
				 * > 0)) { loja.cadastrarVenda(codigoVenda, cliente, itemVenda);
				 * loja.venda.get(loja.venda.size() -
				 * 1).setQuantidadeItensVendidos(itemVenda.size()); verificadorCliente++;
				 * codigoVenda++; } }
                 */
                if (verificadorCliente == 0) {
                    System.out.println(
                            "Cliente ainda nao cadastrado, digite sim para cadastrar o cliente e volte ao Item Venda ou nao realiza a venda");

                    String verificarCadastro = input.next();
                    if (verificarCadastro.equalsIgnoreCase("sim")) {
                        cadastroDeClienteImput();
                    } else {
                        System.out.println("E preciso cadastrar um cliente para realizar uma venda");
                    }
                }

                System.out.println("Deseja Continuar Adiiconando Vendas, digite sim para continuar:");
                verificarCadastroVendas = input.next();
            }
        }
    }

    // Listagem das vendas
    public void listarVendasInput() {
        loja.listarVendas();
    }

    // Verificar Informacoes da Venda;
    public void verificarInformacoesDeUmaVendaInput() {
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

            if (contarCodigoVenda == 0) {
                System.out.println("Nao ha venda com esse codigo");
            }
        }
    }

    // Listagem de Cliente Por Venda;
    public void listaClientePorVendaInput() {
        System.out.println("Digite o codigo do cliente a ser verificado");
        String codigoVerificarCliente = input.next();
        loja.listarVendaCliente(codigoVerificarCliente);

        System.out.println("===================");
    }

    // Excluir Cliente
    public void excluirCliente() throws ParseException {
        System.out.println("Digite o Cpf do cliente a ser excluido: ");
        String codigoVerificarCpfCliente = input.next();
        loja.excluirCliente(codigoVerificarCpfCliente);

    }

    public void listarClientesExcluidos() {
        loja.listarClientesExcluidos();
    }

    // listarProduto por categoria
    public void listarProdutoPorCategoria() {
        String categoria = input.next();
        loja.listarProdutosporCategoria2(categoria);

    }

    //ExcluirProduto
    public void excluirProduto() {
        System.out.println("Digite o codigo do produto a ser excluido");
        int codigoProduto = input.nextInt();
        loja.excluirProduto(codigoProduto);
    }

}
