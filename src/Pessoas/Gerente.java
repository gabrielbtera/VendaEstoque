package Pessoas;

import java.util.Date;

public class Gerente extends Funcionario{

	public Gerente() {}
	public Gerente(String cpf, String nome, Date dataDeNascimento, String email, int codigoFuncionario) {
		super(cpf, nome, dataDeNascimento, email, codigoFuncionario);
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
	public int getCodigoFuncionario() {
		return super.getCodigoFuncionario();
	}
	

}
