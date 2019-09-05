package Utilitarios;

import java.util.InputMismatchException;

public class ValidarCpf {

	public static boolean isCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int soma, verificador, transformador, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			soma = 0;
			peso = 10;
			for (verificador = 0; verificador < 9; verificador++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(verificador) - 48);
				soma = soma + (num * peso);
				peso -= 1;
			}

			transformador = 11 - (soma % 11);
			if ((transformador == 10) || (transformador == 11))
				dig10 = '0';
			else
				dig10 = (char) (transformador + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			soma = 0;
			peso = 11;
			for (verificador = 0; verificador < 10; verificador++) {
				num = (int) (CPF.charAt(verificador) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			transformador = 11 - (soma % 11);
			if ((transformador == 10) || (transformador == 11))
				dig11 = '0';
			else
				dig11 = (char) (transformador + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCPF(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
				+ CPF.substring(9, 11));
	}

}
