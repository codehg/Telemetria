package Gastos;

import javax.swing.JOptionPane;

import excecoes.*;

public class Manutencao extends Despesas {
	private String validade;
	private String descricao;

	public int newManutencao() {
		validade = JOptionPane.showInputDialog("Digite a data de validade: ");
		valor = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor pago na manuntencao?"));
		try {
			if (valor <= 0) {
				throw new ValorInvalidoException();
			}
		} catch (ValorInvalidoException e) {
			valor = ValorInvalidoException.correcao("menorIgual", 0);
		}
		if (valor == 4444.0f) {
			return 0;
		}
		descricao = JOptionPane.showInputDialog("Descreva a manutencao feita: ");
		try {
			if (descricao.intern() == "") {
				throw new DescricaoEmBrancoException("Descricao");
			}
		} catch (DescricaoEmBrancoException e) {
			descricao = DescricaoEmBrancoException.correcao();
		}
		if (descricao.intern() == "cancelar".intern()) {
			return 0;
		}
		return 1;
	}

	public String showManutencao() {
		return "Validade: " + validade + "\n" + "Valor da manutencao: R$" + valor + "\n" + "Descricao:" + descricao
				+ "\n";
	}
}