package recursosGraficosPaineis;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import recursosGraficos.ManipuladorPosicionativo;

public class PeculiaridadeConsultar extends Pagina {
	private JTextArea descricao = new JTextArea();
	private JList<String> peculiaridades = new JList<String>();
	private JComboBox<String> segmentos = new JComboBox<String>(new String[] { "Todos" });
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] { "Todos" });

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();

		descricao.setEditable(false);

		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(
				ManipuladorPosicionativo.AdicionarComBordaEScroll(peculiaridades, 0, 1, 1, 1, "Peculiaridades"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricao, 1, 1, 1, 1, "Descricao"));

		ManipuladorPosicionativo.weightxy(1, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 0, 0, 1, 1, "Sistemas"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(segmentos, 1, 0, 1, 1, "Segmentos"));

		return super.getPainel();
	}

}
