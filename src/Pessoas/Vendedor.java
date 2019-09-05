package Pessoas;

import java.util.Date;

public class Vendedor extends Funcionario {

	public Vendedor() {}
	public Vendedor(String cpf, String nome, Date dataDeNascimento, String email, int codigoFuncionario) {
		super(cpf, nome, dataDeNascimento, email, codigoFuncionario);
	}

	@Override
	public int getCodigoFuncionario() {
		// TODO Auto-generated method stub
		return super.getCodigoFuncionario();
	}

	@Override
	public String getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}

	@Override
	public Date getDataDeNascimento() {
		// TODO Auto-generated method stub
		return super.getDataDeNascimento();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
