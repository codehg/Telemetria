package Gastos;

import javax.swing.JOptionPane;

import excecoes.*;

public class Impostos extends Despesas {
	private String nomeImposto;
	private int pago;
	private float valorImp;

	public int newImposto() {
		nomeImposto = JOptionPane.showInputDialog("Digite o nome do imposto: ");
		valorImp = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do imposto: "));
		try {
			if (valorImp <= 0) {
				throw new ValorInvalidoException();
			}
		} catch (ValorInvalidoException e) {
			valor = ValorInvalidoException.correcao("menorIgual", 0);
		}
		if (valor == 4444.0f) {
			return 0;
		}
		descricao = JOptionPane.showInputDialog("Descreva o imposto: ");
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
		pago = JOptionPane.showConfirmDialog(null, "O imposto ja foi pago?");
		return 1;
	}

	public void pagarImposto() {
		pago = 0;
	}

	public String showImposto() {
		if (pago == 0) {
			return "Imposto: " + nomeImposto + "\n" + "Valor do Imposto: R$ " + valorImp + "\n" + "Descricao:"
					+ descricao + "\n" + "Imposto Pago? Sim\n";
		} else {
			return "Imposto: " + nomeImposto + "\n" + "Valor do Imposto: R$ " + valorImp + "\n" + "Descricao:"
					+ descricao + "\n" + "Imposto Pago? Nao\n";
		}

	}

	public String getNomeImposto() {
		return nomeImposto;
	}

	public void setNomeImposto(String nomeImposto) {
		this.nomeImposto = nomeImposto;
	}
	public float getValor() {
		return valorImp;
	}
}