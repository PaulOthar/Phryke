package recursosGraficosPaineis;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import recursosGraficos.ManipuladorPosicionativo;

public class SuperRacaCriar extends Pagina {
	private JComboBox<String> caracteristica = new JComboBox<String>(new String[] { "Nenhuma" });
	private JButton criarsuperraca = new JButton("Criar");

	private JTextArea descricao = new JTextArea();
	private JButton inserirmodificador = new JButton("Inserir Modificador");
	private JButton inserirpeculiaridade = new JButton("Inserir Peculiaridade");
	private JSpinner modificadorcaracteristica = new JSpinner();

	private JList<String> modificadores = new JList<String>();
	private JTextField nome = new JTextField();

	private JPanel painelauxiliar = new JPanel();

	private JComboBox<String> peculiaridade = new JComboBox<String>(new String[] { "Nenhuma" });
	private JList<String> peculiaridades = new JList<String>();
	private JButton removermodificador = new JButton("Remover Modificador");
	private JButton removerpeculiaridade = new JButton("Remover Peculiaridade");
	private JComboBox<String> segmentos = new JComboBox<String>(new String[] { "Nenhum" });

	private JComboBox<String> sistemas = new JComboBox<String>(new String[] { "Nenhum" });

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();

		painelauxiliar.setLayout(ManipuladorPosicionativo.getLayout());

		ManipuladorPosicionativo.configbasica();
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBordaEScroll(modificadores, 0, 2, 1, 2,
				"Modificadores De Caracteristica"));
		painelauxiliar
				.add(ManipuladorPosicionativo.AdicionarComBordaEScroll(peculiaridades, 2, 2, 1, 2, "Peculiaridades"));

		ManipuladorPosicionativo.weightxy(1, 0);
		painelauxiliar.add(ManipuladorPosicionativo.Adicionar(inserirmodificador, 0, 1, 1, 1));
		painelauxiliar.add(ManipuladorPosicionativo.Adicionar(removermodificador, 1, 1, 1, 1));
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBorda(caracteristica, 0, 0, 1, 1, "Caracteristica"));
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBorda(modificadorcaracteristica, 1, 0, 1, 1,
				"Modificador De Caracteristica"));

		painelauxiliar.add(ManipuladorPosicionativo.Adicionar(inserirpeculiaridade, 2, 1, 1, 1));
		painelauxiliar.add(ManipuladorPosicionativo.Adicionar(removerpeculiaridade, 3, 1, 1, 1));
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBorda(peculiaridade, 3, 0, 1, 1, "Peculiaridade"));
		painelauxiliar.add(ManipuladorPosicionativo.AdicionarComBorda(segmentos, 2, 0, 1, 1, "Segmento"));

		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricao, 0, 1, 1, 1, "Descricao"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(painelauxiliar, 1, 1, 1, 1));

		ManipuladorPosicionativo.weightxy(1, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(criarsuperraca, 0, 2, 1, 2));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(nome, 0, 0, 1, 1, "Nome"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 1, 0, 1, 1, "Sistema"));

		return super.getPainel();
	}

}
