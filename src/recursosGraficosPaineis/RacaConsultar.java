package recursosGraficosPaineis;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import recursosGraficos.ManipuladorPosicionativo;

public class RacaConsultar extends Pagina {
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] {"Todos"});
	private JComboBox<String> segmentos = new JComboBox<String>(new String[] {"Todos"});
	private JComboBox<String> superraca = new JComboBox<String>(new String[] {"Todas"});
	private JList<String> peculiaridades = new JList<String>();
	private JList<String> racas = new JList<String>();
	private JTextArea descricaopeculiaridade = new JTextArea();
	private JTextArea descricaoraca = new JTextArea();
	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		
		descricaopeculiaridade.setEditable(false);
		descricaoraca.setEditable(false);
		ManipuladorPosicionativo.configbasica();
		ManipuladorPosicionativo.weightxy(1, 1);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(peculiaridades, 1, 2, 1, 1, "Peculiaridades"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(racas, 0, 2, 1, 1, "Racas"));
		ManipuladorPosicionativo.weightxy(1, 3);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricaopeculiaridade, 1, 3, 1, 1, "Descricao Da Peculiaridade"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricaoraca, 0, 3, 1, 1, "Descricao Da Raca"));
		ManipuladorPosicionativo.weightxy(1, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 0, 0, 1, 2, "Sistema"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(segmentos, 1, 1, 1, 1, "Segmento"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(superraca, 0, 1, 1, 1, "Super Raca"));
		
		
		return super.getPainel();
	}

}
