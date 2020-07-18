package recursosGraficosPaineis;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import recursosGraficos.ManipuladorDeComponente;
import recursosGraficos.ManipuladorPosicionativo;

public class Teste extends Pagina {
	
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] {"Nenhum"});
	private JComboBox<String> segmentos = new JComboBox<String>(new String[] {"Nenhum"});
	private JComboBox<String> superraca = new JComboBox<String>(new String[] {"Nenhuma"});
	
	private JList<String> peculiaridade = new JList<String>();
	private JList<String> caracteristica = new JList<String>();
	private JList<String> custos = new JList<String>();
	private JList<String> peculiaridades = new JList<String>();
	private JList<String> modificadores = new JList<String>();
	
	private JSpinner modificadorcaracteristica = new JSpinner();
	private JSpinner custo = new JSpinner();
	
	private JButton criarraca = new JButton("Criar");
	private JButton inserirpeculiaridade = new JButton("Inserir Peculiaridade");
	private JButton removerpeculiaridade = new JButton("Remover Peculiaridade");
	private JButton inserirmodificador = new JButton("Inserir Modificador");
	private JButton removermodificador = new JButton("Remover Modificador");
	private JButton inserircusto = new JButton("Inserir Custo");
	private JButton removercusto = new JButton("Remover Custo");
	
	private JTextField nomeraca = new JTextField();
	private JTextArea descricaoraca = new JTextArea();
	
	
	

	public JScrollPane Gerar() {
		super.Inicializar();
		
		descricaoraca.setLineWrap(true);
		
		ManipuladorPosicionativo.configbasica();
		
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(new JLabel("-Definir Basico-"), 0, 0, 1, 2));
		
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 0, 1, 1, 2,"Sistema"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(nomeraca, 0, 2, 1, 2,"Nome Da Raca"));
		ManipuladorPosicionativo.ipadxy(0, 200);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricaoraca, 0, 3, 1, 2,"Descricao Da Raca"));
		ManipuladorPosicionativo.ipadxy(0, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(superraca, 0, 4, 1, 2,"Super Raca"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(criarraca, 0, 5, 1, 2));
		
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(new JLabel("\n-Definir Custos-\n"), 0, 6, 1, 2));
		
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(custo, 0, 7, 1, 2,"Valor Do Custo"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(inserircusto, 0, 8, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(removercusto, 1, 8, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(custos, 0, 9, 1, 2,"Lista De Custos Inseridos"));
		
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(new JLabel("---Definir Caracteristicas---"), 0, 10, 1, 2));
		
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(caracteristica, 0, 11, 1, 1,"Lista De Caracteristicas Existentes"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(modificadores, 1, 11, 1, 1,"Lista De Modificadores Inseridos"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(modificadorcaracteristica, 0, 12, 1, 2,"Valor Do Modificador"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(inserirmodificador, 0, 13, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(removermodificador, 1, 13, 1, 1));
		
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(new JLabel("---Definir Peculiaridades---"), 0, 14, 1, 2));
		
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(segmentos, 0, 15, 1, 2,"Segmento Da Peculiaridade"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(peculiaridade, 0, 16, 1, 1,"Peculiaridades Existentes"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(peculiaridades, 1, 16, 1, 1,"Peculiaridades Inseridas"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(inserirpeculiaridade, 0, 17, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(removerpeculiaridade, 1, 17, 1, 1));
		
		JScrollPane chetos = ManipuladorDeComponente.Scroll(super.getPainel());
		chetos.getVerticalScrollBar().setUnitIncrement(15);
		return chetos;
	}




	@Override
	public JPanel GerarPainel() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
