package Entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Pessoas.*;
import Utilitarios.ValidarCpf;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;
//import entities.Product;

public class Loja {

    Scanner input = new Scanner(System.in);
    Item item = new Item();
    //Cliente cliente1 = new Cliente();

    public List<Venda> venda = new ArrayList<>();
    public List<Integer> codigosProdutos = new ArrayList<Integer>();
    public List<String> codigoVerificarCliente = new ArrayList<>();

    public List<Cliente> cliente = new ArrayList<>();
    public List<Cliente> excluirCliente = new ArrayList<>();
    public List<Cliente> clienteExcluidos = new ArrayList<>();

    public List<Produto> produto = new ArrayList<>();
    public List<Produto> excluirProduto = new ArrayList<Produto>();
    public List<Produto> produtosExcluidos = new ArrayList<>();
    public List<Produto> produtoMudarQuantidade = new ArrayList<>();
    public List<Produto> promocaoProduto = new ArrayList<>();

    Date d = new Date();
    private String dataVenda = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

    public Loja() {
    }

    // Cadastro e Listagem dos Produtos
    public void adicionarProdutos(int codigoLote, String validadeLote, int quantidadeLote, String categoria,
            int codigoProduto, String marca, String nome, double precoVenda, int quantidadeDoProduto) {
        int z = 0;

        codigosProdutos.clear();
        produto.clear();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Produto.csv")))) {

            String itemCsv = br.readLine();
            while (itemCsv != null) {

                String[] fields = itemCsv.split(",");
                Integer codigoProdutoVerificar = Integer.parseInt(fields[4]);
                // DA PARA MELHORAR USANDO O CODIGO DO LOTE COMO REFERENCIA/ FAZER TESTES DEPOIS
                codigosProdutos.add(codigoProdutoVerificar);

                itemCsv = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        for (Integer x : codigosProdutos) {
            if (codigoProduto == x) {
                z++;
                break;
            }
        }

        if (z == 0) {
            produto.add(new Produto(codigoLote, validadeLote, quantidadeLote, categoria, codigoProduto, marca, nome,
                    precoVenda, quantidadeDoProduto));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Produto.csv", true))) {
                for (Produto item : produto) {
                    bw.write(item.getCodigoLote() + "," + item.getValidadeLote() + "," + item.getQuantidadeLote() + ","
                            + item.getCategoria() + "," + item.getCodigo() + "," + item.getMarca() + ","
                            + item.getNome() + "," + item.getPrecoVenda() + "," + item.getQuantidadeDoProduto());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
            System.out.println("Produto com Codigo " + codigoProduto + " Realizado Com Sucesso");
        } else {
            System.out.println("Codigo do Produto ja existe no sitema, Cadastro nao Realizado");
        }

    }

    public String listarProdutosCadastrados() {

        System.out.println("Produtos disponiveis na loja:\n");

        String saida = "";
        try {
            BufferedReader buff = new BufferedReader(new FileReader("Produto.csv"));
            List<String> testeAL = new ArrayList<String>();
            String texto = "";
            while (buff.ready()) {
                texto = texto + buff.readLine() + "\n\n";
            }
            buff.close();
            testeAL = Arrays.asList(texto.split(""));
            for (int i = 0; i < testeAL.size(); i++) {
                saida = saida + testeAL.get(i);
            }
        } catch (Exception error) {
            System.out.print("ERRO DURANTE A MANIPULAcao DO ARQUIVO");
        }

        System.out.println(saida);
        return saida;
    }

    /*System.out.println("Produtos disponiveis na loja:\n");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Produto.csv")))) {
			String itemCsv = br.readLine();

			if (itemCsv == null)
				System.out.println("Ainda nao ha produtos cadastrados");
			else
				while (itemCsv != null) {
					System.out.println(itemCsv);
					itemCsv = br.readLine();
					// itemCsv = br.readLine();
				}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());*\
		}

		/*
		 * for (Produto x : produto) {
		 * 
		 * if (x.getQuantidadeDoProduto() > 0) { System.out.println(x +
		 * "\nProduto Disponivel no estoque");
		 * System.out.println("\n=================================="); } else {
		 * System.out.println(x + "\nProduto Indisponivel no estoque");
		 * System.out.println("\n=================================="); }
		 * 
     */
    public String listarProdutoDisponivelNoEstoque() {

        int verificaQuantidade;
        System.out.println("Produtos Disponiveis:\n");
        String saida = "";
        try (BufferedReader br = new BufferedReader(new FileReader("Produto.csv"))) {
            String texto = "";
            String itemCsv = br.readLine();
            List<String> testeAL = new ArrayList<String>();

            if (itemCsv == null) {
                System.out.println("Ainda nao ha produtos fora do estoque");
            } else {
                while (itemCsv != null) {
                    String[] fields = itemCsv.split(",");
                    verificaQuantidade = Integer.parseInt(fields[8]);
                    if (verificaQuantidade > 0) {
                        texto = texto + itemCsv + "\n\n";
                        itemCsv = br.readLine();
                    } else {
                        itemCsv = br.readLine();
                    }
                    // itemCsv = br.readLine();
                }

                testeAL = Arrays.asList(texto.split(""));

                for (int i = 0; i < testeAL.size(); i++) {
                    saida = saida + testeAL.get(i);
                }

            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println(saida);
        return saida;
    }

//int verificaQuantidade;
    /*	
        System.out.println("Produtos disponiveis na loja:\n");

        String saida = "";
        try {
            BufferedReader buff = new BufferedReader(new FileReader("Produto.csv"));
            List<String> testeAL = new ArrayList<String>();
            String texto = "";
            while (buff.ready()) {
                texto = texto + buff.readLine() + "\n\n";
            }
            buff.close();
            testeAL = Arrays.asList(texto.split(""));
            for (int i = 0; i < testeAL.size(); i++) {
                saida = saida + testeAL.get(i) ;
            }
        } catch (Exception error) {
            System.out.print("ERRO DURANTE A MANIPULAcao DO ARQUIVO");
        }
        return saida;*/
 /*
		System.out.println("Produtos Disponiveis:\n");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Produto.csv")))) {

			String itemCsv = br.readLine();

			if (itemCsv == null)
				System.out.println("Ainda nao ha produtos fora do estoque");
			else
				while (itemCsv != null) {
					String[] fields = itemCsv.split(",");
					verificaQuantidade = Integer.parseInt(fields[8]);
					if (verificaQuantidade > 0) {
						System.out.println(itemCsv);
						itemCsv = br.readLine();
					} else
						itemCsv = br.readLine();
					// itemCsv = br.readLine();
				}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		/*
		 * for (Produto x : produto) { if (x.getQuantidadeDoProduto() > 0) {
		 * System.out.println(x + "\nProduto Disponivel no estoque");
		 * System.out.println("\n=================================="); } }
     */
    // LISTAR POR CATEGORIA PELA PROPRIA CATEGORIA
    public String listarProdutosporCategoria2(String categoria) {
        //LEMBRAR DE ALTERAAAAAAAAAAAAAAAAAAAAAA

        System.out.println("Produto por categoria: ");
        String saida = "";

        String verificaCategoria;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Produto.csv")))) {
            String texto = "";
            List<String> testeAL = new ArrayList<String>();
            String itemCsv = br.readLine();

            if (itemCsv == null) {
                System.out.println("Ainda nao ha estoque");
            } else {
                while (itemCsv != null) {
                    String[] fields = itemCsv.split(",");
                    System.out.println(fields[3]);
                    verificaCategoria = fields[3];
                    if (verificaCategoria.equalsIgnoreCase(categoria)) {
                        // System.out.println(itemCsv);
                        texto += itemCsv + "\n\n";
                        itemCsv = br.readLine();
                    } else {
                        itemCsv = br.readLine();
                    }
                    // itemCsv = br.readLine();
                }
                
                testeAL = Arrays.asList(texto.split(""));
                for (int i = 0; i < testeAL.size(); i++) {
                    saida = saida + testeAL.get(i);
                }
                
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        
        System.out.println(saida);
        return saida;

        /*
		 * for (Produto x : produto) { if
		 * (x.getCategoria().equalsIgnoreCase("BEBIDAS")){
		 * System.out.println("BEBIDAS"); System.out.println(x); } if
		 * (x.getCategoria().equalsIgnoreCase("CARNES")){ System.out.println("CARNES");
		 * System.out.println(x); } if (x.getCategoria().equalsIgnoreCase("CEREAIS")){
		 * System.out.println("CEREAIS"); System.out.println(x); }
		 * 
		 * if (x.getCategoria().equalsIgnoreCase("HIGIENE")){
		 * System.out.println("HIGIENE"); System.out.println(x); }
		 * 
		 * if (x.getCategoria().equalsIgnoreCase("LEITE E DERIVADOS")){
		 * System.out.println("LEITE E DERIVADOS"); System.out.println(x); }
		 * 
		 * if (x.getCategoria().equalsIgnoreCase("LIMPEZA")){
		 * System.out.println("LIMPEZA"); System.out.println(x); }
         */
    }

    public String listarProdutosEsgotados() {
        System.out.println("Produtos esgotados:\n");

        int verificaQuantidade;

        System.out.println("Produtos Esgotados:\n");
        String saida = "";
        try (BufferedReader br = new BufferedReader(new FileReader("Produto.csv"))) {
            String texto = "";
            String itemCsv = br.readLine();
            List<String> testeAL = new ArrayList<String>();

            if (itemCsv == null) {
                System.out.println("Ainda nao ha produtos fora do estoque");
            } else {
                while (itemCsv != null) {
                    String[] fields = itemCsv.split(",");
                    verificaQuantidade = Integer.parseInt(fields[8]);
                    if (verificaQuantidade == 0) {
                        texto = texto + itemCsv + "\n\n";
                        itemCsv = br.readLine();
                    } else {
                        itemCsv = br.readLine();
                    }
                    // itemCsv = br.readLine();
                }

                testeAL = Arrays.asList(texto.split(""));

                for (int i = 0; i < testeAL.size(); i++) {
                    saida = saida + testeAL.get(i);
                }

            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println(saida);
        return saida;
        /*
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Produto.csv")))) {

            String itemCsv = br.readLine();

            if (itemCsv == null) {
                System.out.println("Ainda nao ha produtos fora do estoque");
            } else {
                while (itemCsv != null) {
                    String[] fields = itemCsv.split(",");
                    verificaQuantidade = Integer.parseInt(fields[4]);
                    if (verificaQuantidade == 0) {
                        System.out.println(itemCsv);
                        itemCsv = br.readLine();
                    } else {
                        itemCsv = br.readLine();
                    }
                    // itemCsv = br.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        /*
		 * for (Produto x : produto) { if (x.getQuantidadeDoProduto() == 0) {
		 * 
		 * System.out.println(x);
		 * System.out.println("\n=================================="); } }
         */

    }

    // CONFERIR ESTE METODO
    public void addQuantidadeDeProdutos(Produto produto, int addQuantidade) {
        produto.addQuantidadeDoProduto(addQuantidade);
    }

    // Cadastrar clientes
    public void cadastrarCliente(String codigoCliente, String nome, Date dataDeNascimento, String email) {
        int y = 0;
        cliente.clear();
        codigoVerificarCliente.clear();
        String verificaCliente;

        if (ValidarCpf.isCPF(codigoCliente)) {

            int z = 0;

            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Cliente.csv")))) {

                String itemCsv = br.readLine();
                while (itemCsv != null) {

                    String[] fields = itemCsv.split(",");
                    verificaCliente = fields[0];
                    // DA PARA MELHORAR USANDO O CODIGO DO LOTE COMO REFERENCIA/ FAZER TESTES DEPOIS
                    codigoVerificarCliente.add(verificaCliente);
                    itemCsv = br.readLine();
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            for (String x : codigoVerificarCliente) {
                if (x.equalsIgnoreCase(codigoCliente)) {
                    z++;
                    break;
                }
            }

            if (z == 0) {
                cliente.add(new Cliente(codigoCliente, nome, dataDeNascimento, email));
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("Cliente.csv", true))) {
                    for (Cliente x : cliente) {
                        bw.write(x.getCpf() + "," + x.getNome() + "," + x.getDataDeNascimento() + "," + x.getEmail());
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error writing file: " + e.getMessage());
                }
                System.out.println("Cadastro do Cliente com " + codigoCliente + " Realizado Com Sucesso");
            } else {
                System.out.println("Codigo do cliente ja existe no sistema, Cadastro nao Realizado");
            }

            /*
			 * for (Cliente x : cliente) if (codigoCliente.equalsIgnoreCase(x.getCpf())) {
			 * y++; break; }
			 * 
			 * if (y == 0) { cliente.add(new Cliente(codigoCliente, nome, dataDeNascimento,
			 * email)); System.out.println("Cadastro de " + nome +
			 * " Realizado com Sucesso");
			 * 
			 * } else System.out.
			 * println("Codigo do cliente ja existe no sitema, Cadastro Nao Realizado");
			 * 
             */
        } else {
            System.out.println("CPF INVALIDO");
        }
    }

    public String listarClienteCadastrados() {
        System.out.println("Produtos disponiveis na loja:\n");

        String saida = "";
        try (BufferedReader buff = new BufferedReader(new FileReader("Cliente.csv"));) {
            List<String> testeAL = new ArrayList<String>();
            String texto = "";
            while (buff.ready()) {
                texto = texto + buff.readLine() + "\n\n";
            }
            buff.close();
            testeAL = Arrays.asList(texto.split(""));
            for (int i = 0; i < testeAL.size(); i++) {
                saida = saida + testeAL.get(i);
            }
        } catch (Exception error) {
            System.out.print("ERRO DURANTE A MANIPULAcao DO ARQUIVO");
        }

        System.out.println(saida);
        return saida;
    }

    /*
		 * if (cliente.size() == 0) { System.out.
		 * println("Ainda nao ha clientes cadastrados, se deseja cadastrar digite sim "
		 * ); } else for (Cliente x : cliente) { System.out.println(x + "\n");
		 * 
		 * }
     */
    // Adicionar vendas
    public void cadastrarVenda(int codigo, Cliente cliente, List<Item> item) {
        int teste1 = 0;
        double quantidadeProdutos;
        String stringDeItens = " ";
        double valorTotalVenda = 0;

        for (int x = 0; x < item.size(); x++) {
            valorTotalVenda += item.get(x).getQuantidadeVendida() * item.get(x).getProduto().getPrecoVenda();
        }

        //System.out.println(item.get(0).getProduto().getCodigo());
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Produto.csv")))) {
            String itemCsv = br.readLine();

            while (itemCsv != null) {
                //teste1++;
                String[] fields = itemCsv.split(",");

                for (Item x : item) {
                    x.removerQuantidadeEstoque();
                    //System.out.println(item.get(x).getProduto().getQuantidadeDoProduto());
                    stringDeItens += "/ " + x.getProduto().getCodigo() + ", " + x.getProduto().getNome() + ", "
                            + x.getProduto().getPrecoVenda() + ", " + x.getQuantidadeVendida();
                }

                produtoMudarQuantidade.add(new Produto(Integer.parseInt(fields[0]),
                        fields[1], Integer.parseInt(fields[2]), fields[3], Integer.parseInt(fields[4]),
                        fields[5], fields[6], Double.parseDouble(fields[7]), Integer.parseInt(fields[8])));

                itemCsv = br.readLine();
            }

            for (Produto percorreProduto : produtoMudarQuantidade) {
                for (Item percorreItem : item) {
                    if (percorreProduto.getCodigo() == percorreItem.getProduto().getCodigo()) {
                        percorreProduto.setQuantidadeDoProduto(percorreItem.getProduto().getQuantidadeDoProduto());
                        System.out.println(percorreProduto.getQuantidadeDoProduto());
                    }
                }

            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Produto.csv"))) {

            //int codigoLote, String validadeLote, int quantidadeLote, String categoria, int codigoProduto,
            //String marca, String nome, double precoVenda, int quantidadeDoProduto
            for (Produto teste : produtoMudarQuantidade) {
                bw.write(teste.getCodigoLote() + ","
                        + teste.getValidadeLote() + ","
                        + teste.getQuantidadeLote() + ","
                        + teste.getCategoria() + ","
                        + teste.getCodigo() + ","
                        + teste.getMarca() + ","
                        + teste.getNome() + ","
                        + teste.getPrecoVenda() + ","
                        + teste.getQuantidadeDoProduto());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Venda.csv", true))) {

            bw.write(codigo + "," + cliente.getCpf() + "," + cliente.getNome() + "," + stringDeItens + "," + valorTotalVenda);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        this.cliente.clear();
        item.clear();
        venda.clear();
        produtoMudarQuantidade.clear();

    }

    // Listar Vendas
    public String listarVendas() {

        String saida = "";
        try (BufferedReader buff = new BufferedReader(new FileReader("Venda.csv"));) {
            List<String> testeAL = new ArrayList<String>();
            String texto = "";
            while (buff.ready()) {
                texto = texto + buff.readLine() + "\n\n";
            }
            buff.close();
            testeAL = Arrays.asList(texto.split(""));
            for (int i = 0; i < testeAL.size(); i++) {
                saida = saida + testeAL.get(i);
            }
        } catch (Exception error) {
            System.out.print("ERRO DURANTE A MANIPULAcao DO ARQUIVO");
        }

        System.out.println(saida);
        return saida;
    }

    // listar vendas por clientes
    public String listarVendaCliente(String codigoDoCliente) {

        String verificaCpf;
        System.out.println("Venda pelo cliente:\n");
        String saida = "";

        try (BufferedReader br = new BufferedReader(new FileReader("Venda.csv"))) {
            String texto = "";
            String itemCsv = br.readLine();
            List<String> testeAL = new ArrayList<String>();

            if (itemCsv == null) {
                System.out.println("Ainda nao ha produtos fora do estoque");
            } else {
                while (itemCsv != null) {
                    String[] fields = itemCsv.split(",");
                    verificaCpf = fields[1];
                    if (verificaCpf.equalsIgnoreCase(codigoDoCliente)) {

                        texto = texto + itemCsv + "\n\n";
                        itemCsv = br.readLine();
                    } else {
                        itemCsv = br.readLine();
                    }
                }

                testeAL = Arrays.asList(texto.split(""));

                for (int i = 0; i < testeAL.size(); i++) {
                    saida = saida + testeAL.get(i);
                }

            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println(saida);
        produtoMudarQuantidade.clear();
        return saida;

    }

    // Excluir cliente
    public void excluirCliente(String codigoCliente) throws ParseException {
        String verificaCliente;
        int z = 0;
        int teste = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Cliente.csv")))) {
            String itemCsv = br.readLine();
            while (itemCsv != null) {
                teste++;
                String[] fields = itemCsv.split(",");
                //DateFormat df = new SimpleDateFormat(pattern);

                String data1 = new SimpleDateFormat("dd/MM/yyyy")
                        .format(new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US).parse(fields[2]));
                Date date = new Date(data1);

                //System.out.println(fields[0]);
                excluirCliente.add(new Cliente(fields[0], fields[1], date, fields[3]));

                if (codigoCliente.equalsIgnoreCase(fields[0])) {
                    z++;
                    int verifica = teste;
                }

                itemCsv = br.readLine();
            }

            System.out.println(z);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        if (z == 1) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Cliente.csv"))) {
                for (Cliente f : excluirCliente) {
                    if (f.getCpf().equalsIgnoreCase(codigoCliente)) {
                        clienteExcluidos.add(f);
                        excluirCliente.remove(f);
                        break;

                    }
                }

                for (Cliente x : excluirCliente) {
                    System.out.println(x.getCpf());
                    bw.write(x.getCpf() + "," + x.getNome() + "," + x.getDataDeNascimento() + "," + x.getEmail());
                    bw.newLine();
                }

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

            try (BufferedWriter excluir = new BufferedWriter(new FileWriter("ClientesExcluidos\\ClientesExcluidos.csv", true))) {
                excluir.write(clienteExcluidos.get(0).getCpf() + "," + clienteExcluidos.get(0).getNome() + "," + clienteExcluidos.get(0).getDataDeNascimento() + "," + clienteExcluidos.get(0).getEmail());
                excluir.newLine();
                clienteExcluidos.clear();
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            System.out.println("Exclusao do Cliente com " + codigoCliente + " Realizado Com Sucesso");
        } else {
            System.out.println("Codigo do cliente nao existe no sistema, Exclusao nao Realizado");
        }

    }

    // Lista Cliente Excluido
    public String listarClientesExcluidos() {
        String saida = "";
        try (BufferedReader buff = new BufferedReader(new FileReader("ClientesExcluidos\\ClientesExcluidos.csv"));) {
            List<String> testeAL = new ArrayList<String>();
            String texto = "";
            while (buff.ready()) {
                texto = texto + buff.readLine() + "\n\n";
            }
            buff.close();
            testeAL = Arrays.asList(texto.split(""));
            for (int i = 0; i < testeAL.size(); i++) {
                saida = saida + testeAL.get(i);
            }
        } catch (Exception error) {
            System.out.print("ERRO DURANTE A MANIPULAcao DO ARQUIVO");
        }

        System.out.println(saida);
        return saida;
    }

    // Excluir Produto
    public void excluirProduto(int codigoProduto) {
        int z = 0;
        int teste = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Produto.csv")))) {
            String itemCsv = br.readLine();
            while (itemCsv != null) {
                teste++;
                String[] fields = itemCsv.split(",");

                excluirProduto.add(new Produto(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), fields[3], Integer.parseInt(fields[4]), fields[5], fields[6], Double.parseDouble(fields[7]), Integer.parseInt(fields[8])));

                if (Integer.parseInt(fields[4]) == codigoProduto) {
                    z++;
                    int verifica = teste;
                }

                itemCsv = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        if (z == 1) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Produto.csv"))) {
                for (Produto f : excluirProduto) {
                    if (f.getCodigo() == codigoProduto) {
                        produtosExcluidos.add(f);
                        excluirProduto.remove(f);
                        break;

                    }
                }

                for (Produto x : excluirProduto) {

                    bw.write(x.getCodigoLote() + "," + x.getValidadeLote() + "," + x.getQuantidadeLote()
                            + "," + x.getCategoria() + "," + x.getCodigo() + "," + x.getMarca() + ","
                            + x.getNome() + "," + x.getPrecoVenda() + "," + x.getQuantidadeDoProduto());
                    bw.newLine();
                }

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

            try (BufferedWriter excluir = new BufferedWriter(new FileWriter("ProdutosExcluidos\\ProdutosExcluidos.csv", true))) {
                excluir.write(produtosExcluidos.get(0).getCodigoLote() + "," + produtosExcluidos.get(0).getValidadeLote() + ","
                        + produtosExcluidos.get(0).getQuantidadeLote() + "," + produtosExcluidos.get(0).getCategoria() + "," + produtosExcluidos.get(0).getCodigo()
                        + "," + produtosExcluidos.get(0).getMarca() + "," + produtosExcluidos.get(0).getNome() + "," + produtosExcluidos.get(0).getPrecoVenda()
                        + "," + produtosExcluidos.get(0).getQuantidadeDoProduto());
                excluir.newLine();
                produtosExcluidos.clear();
                excluirProduto.clear();
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            System.out.println("Exclusao do Produto com " + codigoProduto + " Realizado Com Sucesso");
        } else {
            System.out.println("Codigo do cliente nao existe no sistema, Exclusao nao Realizado");
        }
    }

    // Lista Produto Excluido
    public String listarProdutoExcluido() {
        String saida = "";
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream("ProdutosExcluidos\\ProdutosExcluidos.csv")))) {
            List<String> testeAL = new ArrayList<String>();
            String texto = "";
            while (buff.ready()) {
                texto = texto + buff.readLine() + "\n\n";
            }
            buff.close();
            testeAL = Arrays.asList(texto.split(""));
            for (int i = 0; i < testeAL.size(); i++) {
                saida = saida + testeAL.get(i);
            }
        } catch (Exception error) {
            System.out.print("ERRO DURANTE A MANIPULAcao DO ARQUIVO");
        }

        System.out.println(saida);
        return saida;
    }

    //Realizando Promocao
    public void verificaValidade() {
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream("Produto.csv")))) {
            String itemCsv = buff.readLine();
            while (itemCsv != null) {
                String[] fields = itemCsv.split(",");

                String[] dataValidade = fields[1].split("/");
                int dia = Integer.parseInt(dataValidade[0]);
                int mes = Integer.parseInt(dataValidade[1]);
                int ano = Integer.parseInt(dataValidade[2]);

                SimpleDateFormat dataSistema1 = new SimpleDateFormat("dd/MM/yyyy");
                String dataSistema = dataSistema1.format(new Date());
                String[] dataSistema2 = dataSistema.split("/");
                int diaSistema = Integer.parseInt(dataSistema2[0]);
                int mesSistema = Integer.parseInt(dataSistema2[1]);
                int anoSistema = Integer.parseInt(dataSistema2[2]);

                LocalDate inicio = LocalDate.of(ano, mes, dia);
                LocalDate fim = LocalDate.of(anoSistema, mesSistema, diaSistema);
                long intervalo = ChronoUnit.DAYS.between(fim, inicio);

                if (intervalo <= 10) {
                    promocaoProduto.add(new Produto(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), fields[3], Integer.parseInt(fields[4]), fields[5], fields[6], Double.parseDouble(fields[7]), Integer.parseInt(fields[8])));
                }
                itemCsv = buff.readLine();
            }
        } catch (IOException error) {
            System.out.println("Erro durante a manipulacao do arquivo");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("PromocaoProduto\\PromocaoProduto.csv", true))) {
            for (Produto x : promocaoProduto) {
                x.setPrecoVenda(x.getPrecoVenda() * 0.10);
                bw.write(x.getCodigoLote() + "," + x.getValidadeLote() + "," + x.getQuantidadeLote()
                        + "," + x.getCategoria() + "," + x.getCodigo() + "," + x.getMarca() + ","
                        + x.getNome() + "," + x.getPrecoVenda() + "," + x.getQuantidadeDoProduto());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

    }

}
