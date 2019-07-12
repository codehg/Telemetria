package classes;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import Gastos.Abastecimento;
import Gastos.Impostos;
import Gastos.Manutencao;
import excecoes.DescricaoEmBrancoException;

public class Veiculo {
	private String modelo;
	private int anoMod;
	private int anoFab;
	private float cilindrada;
	private String tipoCombustivel;
	private String cor;
	private String placa;
	private String renavam;
	private int hodometro;
	private String marca;
	private Abastecimento abas;
	private Impostos imp;
	private Manutencao manuten;
	
	public ArrayList<Abastecimento> listaAbastecimento = new ArrayList<Abastecimento>();
	public ArrayList<Impostos> listaImpostos = new ArrayList<Impostos>();
	public ArrayList<Manutencao> listaManutencao = new ArrayList<Manutencao>();
	
	public void novoAbastecimento() {
		int sucesso;
		abas = new Abastecimento();
		sucesso = abas.abastecer(tipoCombustivel, listaAbastecimento, hodometro);
		if(sucesso == 1) {
			listaAbastecimento.add(abas);
		}else {
			JOptionPane.showMessageDialog(null, "Veiculo nao abastecido", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void novoImposto() {
		int sucesso;
		imp = new Impostos();
		sucesso = imp.newImposto();
		if(sucesso == 1) {
			listaImpostos.add(imp);
		}else {
			JOptionPane.showMessageDialog(null, "Imposto nao registrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void novaManutencao() {
		int sucesso;
		manuten = new Manutencao();
		sucesso = manuten.newManutencao();
		if(sucesso == 1) {
			listaManutencao.add(manuten);
		}else {
			JOptionPane.showMessageDialog(null, "Manutencao nao registrada", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int newVeiculo() {
		modelo = JOptionPane.showInputDialog("Digite o modelo do veiculo: " );
		marca = JOptionPane.showInputDialog("Digite a marca do veiculo: " );
		anoMod = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do modelo do veiculo: " ));
		anoFab = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricacao do veiculo: " ));
		cilindrada = Float.parseFloat(JOptionPane.showInputDialog("Digite a ciclindrada (ex: 1.0, 1.6...): " ));
		tipoCombustivel = JOptionPane.showInputDialog("Digite o combustivel aceito (no caso de flex, use 'flex'): " );
		try {
			if(tipoCombustivel.intern() == "") {
				throw new DescricaoEmBrancoException("Tipo de combustivel");
			}
		}catch(DescricaoEmBrancoException e) {
			tipoCombustivel = DescricaoEmBrancoException.correcao();
		}
		if(tipoCombustivel.intern() == "cancelar".intern()) {
			return 0;
		}
		cor = JOptionPane.showInputDialog("Digite a cor: " );
		placa = JOptionPane.showInputDialog("Digite a placa: " );
		try {
			if(placa.intern() == "") {
				throw new DescricaoEmBrancoException("Placa");
			}
		}catch(DescricaoEmBrancoException e) {
			placa = DescricaoEmBrancoException.correcao();
		}
		if(placa.intern() == "cancelar".intern()) {
			return 0;
		}
		renavam = JOptionPane.showInputDialog("Digite o no do Renavam: " );
		hodometro = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do hodometro: "));
		
		return 1;
	}
	
	public void showVeiculo() {
			JOptionPane.showMessageDialog(null,"Modelo: "+ modelo + "\n" +
			"Marca: " + marca + "\n" +	
			"Ano do modelo: "+ anoMod + "\n" +
			"Ano de fabricacao: "+ anoFab + "\n" +			
			"Cilindrada: "+ cilindrada + "\n" +			
			"Aceita combustivel: "+ tipoCombustivel + "\n" +		
			"Cor: "+ cor + "\n" +
			"Placa:"+ placa + "\n" +
			"No Renavam: "+ renavam + "\n" +
			"Hodometro : "+ hodometro + "\n");			
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public float getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(float cilindrada) {
		this.cilindrada = cilindrada;
	}
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public int getHdometro() {
		return hodometro;
	}
	public void setOdometro(int hodometro) {
		this.hodometro = hodometro;
	}
	
}