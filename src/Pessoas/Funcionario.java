package Pessoas;

import java.util.Date;

public class Funcionario extends Pessoa {

	private int codigoFuncionario;
	private double salario;

	public Funcionario() {}
	public Funcionario(String cpf, String nome, Date dataDeNascimento, String email, int codigoFuncionario) {
		super(cpf, nome, dataDeNascimento, email);
		this.codigoFuncionario = codigoFuncionario;
	}

	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}

	@Override
	public String getCpf() {
		return super.getCpf();
	}

	@Override
	public String getNome() {
		return super.getNome();
	}

	@Override
	public Date getDataDeNascimento() {
		return super.getDataDeNascimento();
	}

	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Override
	public String toString() {
		return "Codigo Funcionario: " + getCodigoFuncionario() +
				"\nCPF: " + getCpf() +
				"\nNome: " + getNome() +
				"\nData de Nascimento: " + getDataDeNascimento() +
				"\nEmail: " + getEmail();
	}

}
