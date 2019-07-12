package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import excecoes.DescricaoEmBrancoException;

public class Pessoa {
	private String nome;
	private String cpf;
	public Veiculo v;
	
	public ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
	
	public void novoVeiculo() {
		int sucesso;
		v = new Veiculo();
		sucesso = v.newVeiculo();
		if(sucesso == 1) {
			listaVeiculo.add(v);
		}else {
			JOptionPane.showMessageDialog(null, "Veiculo nao cadastrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void newPessoa() {
		nome = JOptionPane.showInputDialog("Digite seu nome.");
		try {
			if(nome.intern() == "") {
				throw new DescricaoEmBrancoException("Nome");
			}
		}catch(DescricaoEmBrancoException e) {
			nome = DescricaoEmBrancoException.correcao();
		}
		if(nome.intern() == "cancelar".intern()) {
			JOptionPane.showMessageDialog(null, "Pessoa nao cadastrada", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		cpf = JOptionPane.showInputDialog("Digite o seu cpf.");
	}
	
	public void showPessoa() {
		JOptionPane.showMessageDialog(null, "Nome: " + nome + "\n" + 
											"CPF: " + cpf);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}