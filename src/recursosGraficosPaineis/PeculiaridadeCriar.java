package recursosGraficosPaineis;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import recursosGraficos.ManipuladorPosicionativo;

public class PeculiaridadeCriar extends Pagina {
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] {"Todos"});
	private JComboBox<String> segmentos = new JComboBox<String>(new String[] {"Todos"});
	private JTextField nome = new JTextField();
	private JTextArea descricao = new JTextArea();
	private JSpinner Custo = new JSpinner();
	private JButton adicionarcusto = new JButton("Adicionar Custo");
	private JButton removercusto = new JButton("Remover Custo");
	private JComboBox<String> custos = new JComboBox<String>(new String[] {"Sem Custo"});
	private JButton criarpeculiaridade = new JButton("Criar");
	
	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		
		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricao, 0, 3, 1, 3, "Descricao"));
		
		ManipuladorPosicionativo.weightxy(1, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(adicionarcusto,0,2,1,1));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(removercusto,1,2,1,1));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(nome, 0, 0, 1, 2, "Nome"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(Custo, 0, 1, 1, 1, "Custo"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(custos, 1, 1, 1, 1, "Custos Inseridos"));
		ManipuladorPosicionativo.weightxy(2, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(segmentos, 2, 0, 1, 1, "Segmentos"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 2, 1, 1, 1, "Sistemas"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(criarpeculiaridade,2,2,1,1));
		return super.getPainel();
	}

}
