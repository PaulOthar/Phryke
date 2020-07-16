package recursosGraficosPaineis;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import recursosGraficos.ManipuladorPosicionativo;

public class CaracteristicaCriar extends Pagina {
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] {"Nenhum"});
	private JTextField nome = new JTextField();
	private JTextArea descricao = new JTextArea();
	
	private JButton criarvalor = new JButton("Criar Por Valor");
	private JSpinner valor = new JSpinner();
	private JSpinner valormin = new JSpinner();
	private JSpinner valormax = new JSpinner();
	
	private JComboBox<String> Caracteristicareferencial = new JComboBox<String>(new String[] {"Nenhuma"});
	private JComboBox<String> Caracteristicareferencial2 = new JComboBox<String>(new String[] {"Nenhuma"});
	private JComboBox<String> operador = new JComboBox<String>(new String[] {"Somar","Subtrair","Multiplicar","Dividir"});
	private JSpinner referencianumerica = new JSpinner();
	private JButton criarregra = new JButton("Criar Por Regra");
	
	
	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		
		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricao, 0, 5, 1, 5, "Descricao Da Caracteristica"));
		
		ManipuladorPosicionativo.weightxy(1, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 1, 0, 1, 3, "Inserir no Sistema"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(nome, 0, 0, 1, 1, "Nome Da Caracteristica"));
		
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(valor, 0, 1, 1, 2, "Valor Inicial"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(valormin, 0, 2, 1, 2, "Valor Minimo"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(valormax, 0, 3, 1, 2, "Valor Maximo"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(criarvalor, 0, 4, 1, 2));
		
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(Caracteristicareferencial, 2, 1, 1, 2, "Caracteristica"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(operador, 2, 2, 1, 2, "Operador"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(referencianumerica, 2, 3, 1, 1, "Valor Operante"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(Caracteristicareferencial2, 3, 3, 1, 1, "Caracteristica"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(criarregra, 2, 4, 1, 2));
		
		return super.getPainel();
	}

}
