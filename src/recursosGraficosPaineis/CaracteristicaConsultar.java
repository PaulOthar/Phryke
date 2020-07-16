package recursosGraficosPaineis;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import recursosGraficos.ManipuladorPosicionativo;

public class CaracteristicaConsultar extends Pagina {
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] {"Todos"});
	private JTextArea descricao = new JTextArea();
	private JList caracteristicas = new JList<String>();
	
	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		
		descricao.setEditable(false);
		
		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricao, 1, 1, 1, 1, "Descricao Da Caracteristica"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(caracteristicas, 0, 1, 1, 1, "Caracteristicas"));
		
		ManipuladorPosicionativo.weightxy(0, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 0, 0, 1, 2, "Sistemas"));
		return super.getPainel();
	}

}
