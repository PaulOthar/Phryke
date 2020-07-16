package recursosGraficosPaineis;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import recursosGraficos.ManipuladorPosicionativo;

public class SistemaConsultar extends Pagina {
	private JComboBox<String> sistemas = new JComboBox<String>();
	private JLabel visualizador = new JLabel();
		
	private JComboBox<String> regras = new JComboBox<String>();
	private JTextArea descricao = new JTextArea();
	
	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		
		descricao.setEditable(false);
		//descricao.setLineWrap(true);
		
		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(visualizador, 0, 1, 1, 1, "Estrutura"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricao, 1, 1, 1, 1, "Descricao"));
		
		ManipuladorPosicionativo.weightxy(1, 0);
		
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 0, 0, 1, 1, "Sistemas"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(regras, 1, 0, 1, 1, "Regras"));
		return super.getPainel();
	}

}
