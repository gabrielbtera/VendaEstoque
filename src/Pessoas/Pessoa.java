package Pessoas;

import java.util.Date;


public abstract class Pessoa{

	private String cpf;
	private String nome;
	private Date dataDeNascimento;
	private String email;
	//AINDA PODE ADD;
	
	public Pessoa() {}
	public Pessoa(String cpf, String nome, Date dataDeNascimento, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	
}
