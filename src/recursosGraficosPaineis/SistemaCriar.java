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
	JButton botaosegmento = new JButton("Adicionar"),botaosistema = new JButton("Criar"),botaocaracteristica = new JButton("Adicionar");
	JComboBox<String> opcaosegmento = new JComboBox<String>(new String[] {"Adicionar","Remover"}),opcaocaracteristica = new JComboBox<String>(new String[] {"Adicionar","Remover"}),caracteristicasexi = new JComboBox<String>();
	

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
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(opcaosegmento, 0, 2, 1, 1, "Operacoes De Segmento"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(botaosegmento, 0, 3, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(caracteristicasexi, 1, 1, 1, 1, "Caracteristicas Existentes"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(opcaocaracteristica, 1, 2, 1, 1, "Operacoes De Caracteristica"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(botaocaracteristica, 1, 3, 1, 1));
		
		return super.getPainel();
	}

}
