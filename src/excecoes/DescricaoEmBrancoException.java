package excecoes;
import javax.swing.JOptionPane;

public class DescricaoEmBrancoException extends Exception{
	static String descricao;

	public DescricaoEmBrancoException(String descricao) {
		super();
		DescricaoEmBrancoException.descricao = descricao;
	}

	public static String correcao() {
		String retorno;
		int count = 3;
		do {
			JOptionPane.showMessageDialog(null, DescricaoEmBrancoException.descricao + " nao pode ser deixada em branco", "DescricaoEmBrancoException", JOptionPane.ERROR_MESSAGE);
			retorno = JOptionPane.showInputDialog("Faca uma descricao valida. Voce ainda tem "+ count + " chances");
			count--;
			if(count == 0) {
				retorno = "cancelar";
			}
		}while(retorno.intern() == "");
		return retorno;
	}
	
	
}
