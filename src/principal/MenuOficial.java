package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import classes.Pessoa;

import javax.swing.JLabel;



public class MenuOficial{
		
	    ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		Pessoa pessoa = null;
		
		private JFrame frmMenu;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MenuOficial window = new MenuOficial();
						window.frmMenu.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public MenuOficial() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			
			frmMenu = new JFrame();
			frmMenu.setTitle("Menu");
			frmMenu.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
			frmMenu.getContentPane().setBackground(Color.LIGHT_GRAY);
			frmMenu.setBounds(100, 100, 450, 400);
			frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmMenu.getContentPane().setLayout(null);
			
			JMenu mnNewMenu = new JMenu("Usuario");
			mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
			mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mnNewMenu.setBackground(new Color(64, 64, 64));
			mnNewMenu.setBounds(10, 86, 127, 22);
			frmMenu.getContentPane().add(mnNewMenu);
			
			JButton btnAdicionarUsuario = new JButton("Novo usuario");
			btnAdicionarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pessoa = new Pessoa();
					pessoa.newPessoa();
					if(pessoa.getNome().intern() != "cancelar".intern()) {
						listaPessoa.add(pessoa);
						JOptionPane.showMessageDialog(null, "Usuario logado com sucesso!");
					}
				}
			});
			btnAdicionarUsuario.setBounds(163, 86, 115, 23);
			frmMenu.getContentPane().add(btnAdicionarUsuario);
			
			JButton btnMostrarUsuario = new JButton("Exisitente");
			btnMostrarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nome = JOptionPane.showInputDialog("Digite seu nome.");
					String cpf = JOptionPane.showInputDialog("Digite o seu cpf.");
					int c = -1;
					for(int i = 0; i < listaPessoa.size(); i++) {
						if(listaPessoa.get(i).getNome().intern() == nome.intern() && listaPessoa.get(i).getCpf().intern() == cpf.intern()) {
							c = i;
							break;
						}
					}
					if(c == -1) {
						JOptionPane.showMessageDialog(null, "Usuario nao encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						pessoa = listaPessoa.get(c);
						JOptionPane.showMessageDialog(null, "Usuario logado com sucesso!");
					}
				}
			});
			btnMostrarUsuario.setBounds(293, 86, 115, 23);
			frmMenu.getContentPane().add(btnMostrarUsuario);
			
			
			JMenu mnNewMenu_1 = new JMenu("Veiculo");
			mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
			mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mnNewMenu_1.setBounds(10, 135, 127, 22);
			frmMenu.getContentPane().add(mnNewMenu_1);
			
			JMenu mnDespesas = new JMenu("Despesas");
			mnDespesas.setHorizontalAlignment(SwingConstants.CENTER);
			mnDespesas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mnDespesas.setBounds(10, 197, 127, 22);
			frmMenu.getContentPane().add(mnDespesas);
			
			JButton btnNewButton = new JButton("Imposto");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int c = -1;
					String placa = JOptionPane.showInputDialog("Digite o a placa do veiculo a ser taxado: " );
					for(int i = 0; i < pessoa.listaVeiculo.size(); i++) {
						if(pessoa.listaVeiculo.get(i).getPlaca().intern() == placa.intern()) {
							c = i;
							break;
						}
					}
					if(c == -1) {
						JOptionPane.showMessageDialog(null, "Veiculo nao encontrado", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						pessoa.listaVeiculo.get(c).novoImposto();
					};
				}
			});
			btnNewButton.setBounds(163, 182, 115, 23);
			frmMenu.getContentPane().add(btnNewButton);
			
			JButton btnNewButtonimp = new JButton("Mostrar");
			btnNewButtonimp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(pessoa == null) {
						JOptionPane.showMessageDialog(null, "Voce deve estar logado para realizar esta ação!");
					} else {
						String msg = "";
						for(int i = 0; i < pessoa.listaVeiculo.size(); i++) {
							msg += "Impostos do carro com placa " + pessoa.listaVeiculo.get(i).getPlaca() + "\n";
							for(int j = 0; j < pessoa.listaVeiculo.get(i).listaImpostos.size(); j++) {
								msg += pessoa.listaVeiculo.get(i).listaImpostos.get(j).showImposto() + "\n";
							}
						}
						if(msg == "") {
							JOptionPane.showMessageDialog(null, "Você não possui nenhum veiculo!");
						}else {
							JOptionPane.showMessageDialog(null, msg);
						}
					}
				}
			});
			btnNewButtonimp.setBounds(293, 182, 115, 23);
			frmMenu.getContentPane().add(btnNewButtonimp);
			
			JButton btnNewButton_1 = new JButton("Abastecer");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int c = -1;
					String placa = JOptionPane.showInputDialog("Digite o a placa do veiculo a ser abastecido: " );
					for(int i = 0; i < pessoa.listaVeiculo.size(); i++) {
						if(pessoa.listaVeiculo.get(i).getPlaca().intern() == placa.intern()) {
							c = i;
							break;
						}
					}
					if(c == -1) {
						JOptionPane.showMessageDialog(null, "Veiculo nao encontrado", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						pessoa.listaVeiculo.get(c).novoAbastecimento();
					};
				}
			});
			btnNewButton_1.setBounds(163, 216, 115, 23);
			frmMenu.getContentPane().add(btnNewButton_1);
			
			JButton btnNewButton_abs = new JButton("Mostrar");
			btnNewButton_abs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(pessoa == null) {
						JOptionPane.showMessageDialog(null, "Voce deve estar logado para realizar esta ação!");
					} else {
						String msg = "";
						for(int i = 0; i < pessoa.listaVeiculo.size(); i++) {
							msg += "Abastecimentos do carro com placa " + pessoa.listaVeiculo.get(i).getPlaca() + "\n";
							for(int j = 0; j < pessoa.listaVeiculo.get(i).listaAbastecimento.size(); j++) {
								msg += pessoa.listaVeiculo.get(i).listaAbastecimento.get(j).showAbs() + "\n";
							}
						}
						if(msg == "") {
							JOptionPane.showMessageDialog(null, "Você não possui nenhum veiculo!");
						}else {
							JOptionPane.showMessageDialog(null, msg);
						}
					}
				}
			});
			btnNewButton_abs.setBounds(293, 216, 115, 23);
			frmMenu.getContentPane().add(btnNewButton_abs);
			
			JButton btnNewButton_2 = new JButton("Manuten\u00E7\u00E3o");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int c = -1;
					String placa = JOptionPane.showInputDialog("Digite o a placa do veiculo a ser feita a manutencao: " );
					for(int i = 0; i < pessoa.listaVeiculo.size(); i++) {
						if(pessoa.listaVeiculo.get(i).getPlaca().intern() == placa.intern()) {
							c = i;
							break;
						}
					}
					if(c == -1) {
						JOptionPane.showMessageDialog(null, "Veiculo nao encontrado", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						pessoa.listaVeiculo.get(c).novaManutencao();
					};
				}
			});
			btnNewButton_2.setBounds(163, 250, 115, 23);
			frmMenu.getContentPane().add(btnNewButton_2);
			
			JButton btnNewButton_man = new JButton("Mostrar");
			btnNewButton_man.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(pessoa == null) {
						JOptionPane.showMessageDialog(null, "Voce deve estar logado para realizar esta ação!");
					} else {
						String msg = "";
						for(int i = 0; i < pessoa.listaVeiculo.size(); i++) {
							msg += "Manutenções do carro com placa " + pessoa.listaVeiculo.get(i).getPlaca() + "\n";
							for(int j = 0; j < pessoa.listaVeiculo.get(i).listaManutencao.size(); j++) {
								msg += pessoa.listaVeiculo.get(i).listaManutencao.get(j).showManutencao() + "\n";
							}
						}
						if(msg == "") {
							JOptionPane.showMessageDialog(null, "Você não possui nenhum veiculo!");
						}else {
							JOptionPane.showMessageDialog(null, msg);
						}
					}
				}
			});
			btnNewButton_man.setBounds(293, 250, 115, 23);
			frmMenu.getContentPane().add(btnNewButton_man);
			
			JButton btnAdicionarVeiculo = new JButton("Adicionar");
			btnAdicionarVeiculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(pessoa == null) {
						JOptionPane.showMessageDialog(null, "Voce deve estar logado para realizar esta ação!");
					} else {
						pessoa.novoVeiculo();
					}
				}
			});
			btnAdicionarVeiculo.setBounds(163, 135, 113, 23);
			frmMenu.getContentPane().add(btnAdicionarVeiculo);
			
			JButton btnMostrarVeiculo = new JButton("Mostrar");
			btnMostrarVeiculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(pessoa == null) {
						JOptionPane.showMessageDialog(null, "Voce deve estar logado para realizar esta ação!");
					} else {
						int c = -1;
						String placa = JOptionPane.showInputDialog("Digite o a placa do veiculo a ser exibido: " );
						for(int i = 0; i < pessoa.listaVeiculo.size(); i++) {
							if(pessoa.listaVeiculo.get(i).getPlaca().intern() == placa.intern()) {
								c =i;
								break;
							}
						}
						if(c == -1) {
							JOptionPane.showMessageDialog(null, "Veiculo nao encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
						}else {
							pessoa.listaVeiculo.get(c).showVeiculo();
						}
					}
				}
			});
			btnMostrarVeiculo.setBounds(293, 135, 113, 23);
			frmMenu.getContentPane().add(btnMostrarVeiculo);
			
			
			JLabel lblMenu = new JLabel("MENU");
			lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
			lblMenu.setBounds(140, 0, 160, 24);
			frmMenu.getContentPane().add(lblMenu);
			
			JMenu mnRelatorios = new JMenu("Relatorios");
			mnRelatorios.setHorizontalAlignment(SwingConstants.CENTER);
			mnRelatorios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mnRelatorios.setBounds(10, 305, 127, 22);
			frmMenu.getContentPane().add(mnRelatorios);
			
			JButton btnRelatorioSimples = new JButton("Simples");
			btnRelatorioSimples.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(pessoa == null) {
						JOptionPane.showMessageDialog(null, "Voce deve estar logado para realizar esta ação!");
					} else {
						String msg = "";
						float valorTotal = 0;
						int i,x,y,z;
						for(i =0; i < pessoa.listaVeiculo.size(); i++) {
							msg = "Despesas do veiculo: " + pessoa.listaVeiculo.get(i).getPlaca() + "\n";
							msg += "Despesas com abastecimento: \n";
							for(x=0; x < pessoa.listaVeiculo.get(i).listaAbastecimento.size(); x++) {
								msg += pessoa.listaVeiculo.get(i).listaAbastecimento.get(x).showAbs() + "\n";
								valorTotal += pessoa.listaVeiculo.get(i).listaAbastecimento.get(x).getValor();
							}
							msg += "Despesas com impostos: \n";
							for(y=0; y < pessoa.listaVeiculo.get(i).listaImpostos.size(); y++) {
								msg += pessoa.listaVeiculo.get(i).listaImpostos.get(y).showImposto() + "\n";
								valorTotal += pessoa.listaVeiculo.get(i).listaImpostos.get(y).getValor();
							}
							msg += "Despesas com manutencao: \n";
							for(z=0; z < pessoa.listaVeiculo.get(i).listaManutencao.size(); z++) {
								msg += pessoa.listaVeiculo.get(i).listaManutencao.get(z).showManutencao() + "\n";
								valorTotal += pessoa.listaVeiculo.get(i).listaManutencao.get(z).getValor();
							}
							JOptionPane.showMessageDialog(null, msg);
						}
						JOptionPane.showMessageDialog(null, "Valor total das despesas: R$"+ valorTotal);
					}
				}
			});
			btnRelatorioSimples.setBounds(163, 305, 113, 23);
			frmMenu.getContentPane().add(btnRelatorioSimples);
			
			JButton btnRelatorioDeDesempenho = new JButton("Desempenho");
			btnRelatorioDeDesempenho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(pessoa == null) {
						JOptionPane.showMessageDialog(null, "Voce deve estar logado para realizar esta ação!");
					} else {
						String msg = "";
						int count = 0;
						float km_rodado, litros_abastecidos;
						float consumoMedio = 0;
						for(int i = 0; i < pessoa.listaVeiculo.size(); i++) {
							msg += "Relatorio de consumo para o veiculo com placa " + pessoa.listaVeiculo.get(i).getPlaca() + " : ";
							for(int j = 0; j < pessoa.listaVeiculo.get(i).listaAbastecimento.size() - 1; j++) {
								if (pessoa.listaVeiculo.get(i).listaAbastecimento.get(j).getCheio() == 0 && pessoa.listaVeiculo.get(i).listaAbastecimento.get(j+1).getCheio() == 0) {
									km_rodado = pessoa.listaVeiculo.get(i).listaAbastecimento.get(j+1).getHodometro() - pessoa.listaVeiculo.get(i).listaAbastecimento.get(j).getHodometro();
									litros_abastecidos = pessoa.listaVeiculo.get(i).listaAbastecimento.get(j).getQuantidade();
									count ++;
									consumoMedio += km_rodado / litros_abastecidos;
								}
							}
							msg += consumoMedio/count + "\n";
						}
						JOptionPane.showMessageDialog(null, msg);
					
						String msg2 = "";
						float valorTotal = 0;
						int x,y,z;
						for(int i =0; i < pessoa.listaVeiculo.size(); i++) {
							valorTotal = 0;
							msg2 += "Custo por km do veiculo com placa " + pessoa.listaVeiculo.get(i).getPlaca() + " : ";
							for(x=0; x < pessoa.listaVeiculo.get(i).listaAbastecimento.size(); x++) {
								valorTotal += pessoa.listaVeiculo.get(i).listaAbastecimento.get(x).getValor();
							}
							for(y=0; y < pessoa.listaVeiculo.get(i).listaImpostos.size(); y++) {
								valorTotal += pessoa.listaVeiculo.get(i).listaImpostos.get(y).getValor();
							}
							for(z=0; z < pessoa.listaVeiculo.get(i).listaManutencao.size(); z++) {
								valorTotal += pessoa.listaVeiculo.get(i).listaManutencao.get(z).getValor();
							}
							msg2 += valorTotal + "\n";
						}
						JOptionPane.showMessageDialog(null, msg2);
					}
				}
			});
			btnRelatorioDeDesempenho.setBounds(293, 305, 113, 23);
			frmMenu.getContentPane().add(btnRelatorioDeDesempenho);
		}
	}