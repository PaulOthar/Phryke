package ferramentas;

import javax.swing.JOptionPane;

public class Mensageiro {
	public static void GerarMensagemSimples(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "", -1);
	}

	public static void GerarMensagemSimples(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, -1);
	}

	public static boolean PedirConfirmacao(String mensagem) {
		boolean b = false;
		if (JOptionPane.showConfirmDialog(null, mensagem, "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public static int PedirInteiro(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(message, -1));
	}

}
