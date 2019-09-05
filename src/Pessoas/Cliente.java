package Pessoas;

import java.util.Date;

public class Cliente extends Pessoa {

    public Cliente(String cpf, String nome, Date dataDeNascimento, String email) {
        super(cpf, nome, dataDeNascimento, email);
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

    public String toString() {
        return "Nome: " + getNome()
                + "\nCodigo do Cliente: " + getCpf()
                + "\nData de Nascimento: " + getDataDeNascimento()
                + "\nEmail: " + getEmail();
    }
}
