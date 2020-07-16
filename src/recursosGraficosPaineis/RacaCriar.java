package recursosGraficosPaineis;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import recursosGraficos.ManipuladorPosicionativo;

public class RacaCriar extends Pagina {
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] {"Nenhum"});
	private JComboBox<String> segmentos = new JComboBox<String>(new String[] {"Nenhum"});
	private JComboBox<String> peculiaridade = new JComboBox<String>(new String[] {"Nenhuma"});
	private JComboBox<String> superraca = new JComboBox<String>(new String[] {"Nenhuma"});
	private JComboBox<String> caracteristica = new JComboBox<String>(new String[] {"Nenhuma"});
	
	private JList<String> peculiaridades = new JList<String>();
	private JList<String> modificadores = new JList<String>();
	
	private JSpinner modificadorcaracteristica = new JSpinner();
	
	private JButton criarraca = new JButton("Criar");
	private JButton inserirpeculiaridade = new JButton("Inserir");
	private JButton removerpeculiaridade = new JButton("Remover");
	private JButton inserirmodificador = new JButton("Inserir");
	private JButton removermodificador = new JButton("Remover");
	
	private JTextField nomeraca = new JTextField();
	private JTextArea descricaoraca = new JTextArea();
	
	private JPanel painelauxiliar = new JPanel();
	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		
		painelauxiliar.setLayout(ManipuladorPosicionativo.getLayout());
		
		
		ManipuladorPosicionativo.configbasica();
		ManipuladorPosicionativo.weightxy(1,5);
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBordaEScroll(modificadores, 0, 2, 1, 2, "Modificadores De Caracteristica"));
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBordaEScroll(peculiaridades, 2, 2, 1, 2, "Peculiaridades"));
		
		ManipuladorPosicionativo.weightxy(1,0);
		painelauxiliar.add(ManipuladorPosicionativo.Adicionar(inserirmodificador, 0, 1, 1, 1));
		painelauxiliar.add(ManipuladorPosicionativo.Adicionar(removermodificador, 1, 1, 1, 1));
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBorda(caracteristica, 0, 0, 1, 1, "Caracteristica"));
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBorda(modificadorcaracteristica, 1, 0, 1, 1, "Modificador De Caracteristica"));
		
		painelauxiliar.add(ManipuladorPosicionativo.Adicionar(inserirpeculiaridade, 2, 1, 1, 1));
		painelauxiliar.add(ManipuladorPosicionativo.Adicionar(removerpeculiaridade, 3, 1, 1, 1));
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBorda(peculiaridade, 3, 0, 1, 1, "Peculiaridade"));
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBorda(segmentos, 2, 0, 1, 1, "Segmento"));
		
		ManipuladorPosicionativo.configbasica();
		ManipuladorPosicionativo.weightxy(1, 2);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricaoraca, 0, 2, 1, 1, "Descricao"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(painelauxiliar, 1, 2, 1, 1));
		
		ManipuladorPosicionativo.weightxy(1, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(criarraca, 0, 1, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(nomeraca, 0, 0, 1, 1, "Nome"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(superraca, 1, 1, 1, 1, "Super Raca"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 1, 0, 1, 1, "Sistema"));
		
		
		return super.getPainel();
	}

}
