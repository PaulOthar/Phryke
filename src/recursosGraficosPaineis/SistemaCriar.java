package recursosGraficosPaineis;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import recursosGraficos.ManipuladorPosicionativo;

public class SistemaCriar extends Pagina{
	JTextField nome = new JTextField(),nomesegmentos = new JTextField();
	JList<String> segmentos = new JList<String>(),caracteristicas = new JList<String>();
	JButton	botaosistema = new JButton("Criar");
	JButton botaocaracteristicaa = new JButton("Adicionar Caracteristica");
	JButton botaocaracteristicar = new JButton("Remover Caracteristica");
	JButton botaosegmentoa = new JButton("Adicionar Segmento");
	JButton botaosegmentor = new JButton("Remover Segmento");
	JComboBox<String> caracteristicasexi = new JComboBox<String>();
	

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		
		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(segmentos, 0, 4, 1, 1, "Segmentos"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(caracteristicas, 1, 4, 1, 1, "Caracteristicas"));
		
		ManipuladorPosicionativo.weightxy(0, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(nome, 0, 0, 1, 1, "Nome Do Sistema"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(botaosistema, 1, 0, 1, 1));
		
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(nomesegmentos, 0, 1, 1, 1, "Nome Do Segmento"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(botaosegmentoa, 0, 2, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(botaosegmentor, 0, 3, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(caracteristicasexi, 1, 1, 1, 1, "Caracteristicas Existentes"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(botaocaracteristicaa, 1, 2, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(botaocaracteristicar, 1, 3, 1, 1));
		
		return super.getPainel();
	}

}
