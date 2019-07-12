package Gastos;

public abstract class Despesas {
	protected String data;
	protected float valor;
	protected String descricao;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}