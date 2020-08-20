package recursosGraficosPaineis;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import recursosGraficos.ManipuladorPosicionativo;

public class SuperRacaConsultar extends Pagina {
	private JTextArea descricaopeculiaridade = new JTextArea();
	private JTextArea descricaosuperraca = new JTextArea();
	private JList<String> peculiaridades = new JList<String>();
	private JComboBox<String> segmentos = new JComboBox<String>(new String[] { "Todos" });
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] { "Todos" });
	private JList<String> superracas = new JList<String>();

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();

		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(
				ManipuladorPosicionativo.AdicionarComBordaEScroll(peculiaridades, 1, 1, 1, 1, "Peculiaridades"));
		super.adicionaraopainel(
				ManipuladorPosicionativo.AdicionarComBordaEScroll(superracas, 0, 1, 1, 1, "Super Racas"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricaosuperraca, 0, 2, 1, 1,
				"Descricao Da Super Raca"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricaopeculiaridade, 1, 2, 1, 1,
				"Descricao Da Peculiaridade"));

		ManipuladorPosicionativo.weightxy(1, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 0, 0, 1, 1, "Sistema"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(segmentos, 1, 0, 1, 1, "Segmento"));

		return super.getPainel();
	}

}
