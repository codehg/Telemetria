package Gastos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import excecoes.CombustivelInvalidoException;
import excecoes.ValorInvalidoException;

public class Abastecimento extends Despesas {
	private String combustivel;
	private int hodometro;
	private int cheio;
	protected float quantidade;
	float preco;

	public int abastecer(String tipoCombustivel, ArrayList<Abastecimento> lista, float hodometroOriginal) {

		data = JOptionPane.showInputDialog("Digite a data");
		combustivel = JOptionPane.showInputDialog("Qual o tipo de combustivel abastecido?");
		try {
			if (!(combustivel.intern() == tipoCombustivel.intern() || (tipoCombustivel.intern() == "flex".intern()
					&& (combustivel.intern() == "gasolina".intern() || combustivel.intern() == "alcool".intern())))) {
				throw new CombustivelInvalidoException(combustivel, tipoCombustivel);
			}
		}

		catch (CombustivelInvalidoException e) {
			combustivel = CombustivelInvalidoException.correcao();
		}
		if (combustivel.intern() == "cancelar".intern()) {
			return 0;
		}
		hodometro = Integer.parseInt(JOptionPane.showInputDialog("Digite o n� do hodometro."));
		try {
			int c = 0;
			for (int i = 0; i < lista.size(); i++)
				c++;
			if (hodometro < hodometroOriginal) {
				throw new ValorInvalidoException();
			} else if (c > 0) {
				if (hodometro < lista.get(c - 1).getHodometro()) {
					throw new ValorInvalidoException();
				}
			}
		} catch (ValorInvalidoException e) {
			int c = 0;
			for (int i = 0; i < lista.size(); i++)
				c++;
			if (c > 0) {
				hodometro = (int) ValorInvalidoException.correcao("menorIgual", lista.get(c - 1).getHodometro());
			} else {
				hodometro = (int) ValorInvalidoException.correcao("menorIgual", hodometroOriginal);
			}
		}
		if (hodometro == 4444) {
			return 0;
		}

		quantidade = Float.parseFloat(JOptionPane.showInputDialog("Digite a quantidade de combustivel em litros"));
		preco = Float.parseFloat(JOptionPane.showInputDialog("Qual o preco do litro do combustivel"));

		try {
			if (preco <= 0) {
				throw new ValorInvalidoException();
			}
		} catch (ValorInvalidoException e) {
			preco = ValorInvalidoException.correcao("menorIgual", 0);
		}
		if (preco == 4444.0f) {
			return 0;
		}

		cheio = JOptionPane.showConfirmDialog(null, "O tanque foi cheio completamente?");

		return 1;
	}

	public String showAbs() {
		if (cheio == 0) {
			return "Data: " + data + "\n" + "Tipo de combust�vel:" + combustivel + "\n" + "Hodometro:" + hodometro
					+ "\n" + "Quantidade de combustivel:" + quantidade + "\n" + "Preco:" + preco + "\n"
					+ "Abastecimento do tipo cheio? Sim\n";
		} else {
			return "Data: " + data + "\n" + "Tipo de combust�vel:" + combustivel + "\n" + "Hodometro:" + hodometro
					+ "\n" + "Quantidade de combustivel:" + quantidade + "\n" + "Preco:" + preco + "\n"
					+ "Abastecimento do tipo cheio? Nao\n";
		}
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public int getHodometro() {
		return hodometro;
	}

	public void setHodometro(int odometro) {
		this.hodometro = odometro;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {

		this.preco = preco;
	}

	public float getValor() {
		return preco * quantidade;
	}

	public int getCheio() {
		return cheio;
	}

	public void setCheio(int cheio) {
		this.cheio = cheio;
	}

	public float getQuantidade() {
		return this.quantidade;
	}

}