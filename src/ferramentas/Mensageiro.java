package ferramentas;

import javax.swing.JOptionPane;

public class Mensageiro {
	public static void GerarMensagemSimples(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem,"",-1);
	}
	public static void GerarMensagemSimples(String mensagem,String titulo) {
		JOptionPane.showMessageDialog(null,mensagem,titulo,-1);
	}
	public static int PedirInteiro(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(message,-1));
	}
	
}
