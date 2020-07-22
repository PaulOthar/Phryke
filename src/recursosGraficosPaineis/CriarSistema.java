package recursosGraficosPaineis;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import formatos.Sistema;
import recursosGraficos.ManipuladorPosicionativo;

public class CriarSistema extends Pagina {
	
	private JPanel sistema = new JPanel();
	private JTextField nomesistema = new JTextField();
	private JTextField versao = new JTextField();
	private JButton criarsistema = new JButton("Criar Sistema");
	private JButton editarsistema = new JButton("Editar Sistema");
	private JButton excluirsistema = new JButton("Excluir Sistema");
	private JComboBox Sistemas = new JComboBox();
	
	public JPanel painelsistema() {
		sistema.setLayout(ManipuladorPosicionativo.getLayout());
		ManipuladorPosicionativo.configbasica();
		ManipuladorPosicionativo.weightxy(1, 0);
		sistema.add(ManipuladorPosicionativo.AdicionarComBorda(nomesistema, 0, 0, 1, 1, "Nome Do Sistema"));
		sistema.add(ManipuladorPosicionativo.AdicionarComBorda(versao, 1, 0, 1, 1, "Nome Da Versao"));
		sistema.add(ManipuladorPosicionativo.AdicionarComBorda(Sistemas, 0, 1, 1, 2, "Sistemas Existentes"));
		sistema.add(ManipuladorPosicionativo.Adicionar(editarsistema, 0, 2, 1, 1));
		sistema.add(ManipuladorPosicionativo.Adicionar(excluirsistema, 1, 2, 1, 1));
		sistema.add(ManipuladorPosicionativo.Adicionar(criarsistema, 0, 3, 1, 2));
		
		return sistema;
	}
	
	private JPanel regra = new JPanel();
	private JTextField nomeregra = new JTextField();
	private JTextArea descricaoregra = new JTextArea();
	private JButton criarregra = new JButton("Criar Regra");
	private JButton editarregra = new JButton("Editar Regra");
	private JButton excluirregra = new JButton("Excluir Regra");
	private JList<String> listaregras = new JList<String>();
	
	public JPanel painelregra() {
		
		descricaoregra.setLineWrap(true);
		
		regra.setLayout(ManipuladorPosicionativo.getLayout());
		ManipuladorPosicionativo.configbasica();
		ManipuladorPosicionativo.ipadxy(0, 100);
		regra.add(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricaoregra, 0, 1, 1, 2, "Descricao Da Regra"));
		ManipuladorPosicionativo.ipadxy(0, 0);
		regra.add(ManipuladorPosicionativo.AdicionarComBordaEScroll(listaregras, 0, 3, 1, 2, "Regras Inseridas"));
		ManipuladorPosicionativo.weightxy(1, 0);
		regra.add(ManipuladorPosicionativo.AdicionarComBorda(nomeregra, 0, 0, 1, 2, "Nome Da Regra"));
		regra.add(ManipuladorPosicionativo.Adicionar(criarregra, 0, 2, 1, 2));
		regra.add(ManipuladorPosicionativo.Adicionar(editarregra, 0, 4, 1, 1));
		regra.add(ManipuladorPosicionativo.Adicionar(excluirregra, 1, 4, 1, 1));
		return regra;
	}
	
	private JPanel caracteristica = new JPanel();
	private JTextField nomecaracteristica = new JTextField();
	private JButton criarcaracteristica = new JButton("Criar Caracteristica");
	private JButton editarcaracteristica = new JButton("Editar Caracteristica");
	private JButton excluircaracteristica = new JButton("Excluir Caracteristica");
	private JButton inserircaracteristica = new JButton("Inserir Caracteristica");
	private JList<String> listacaracteristicas = new JList<String>();
	private JComboBox caracteristicas = new JComboBox();
	private JSpinner v = new JSpinner();
	private JSpinner vmin = new JSpinner();
	private JSpinner vmax = new JSpinner();
	
	public JPanel painelcaracteristica() {
		caracteristica.setLayout(ManipuladorPosicionativo.getLayout());
		ManipuladorPosicionativo.configbasica();
		caracteristica.add(ManipuladorPosicionativo.AdicionarComBordaEScroll(listacaracteristicas, 0, 3, 4, 2, "Caracteristicas Inseridas"));
		caracteristica.add(ManipuladorPosicionativo.AdicionarComBorda(nomecaracteristica, 0, 0, 1, 3, "Nome Da Caracteristica"));
		caracteristica.add(ManipuladorPosicionativo.AdicionarComBorda(caracteristicas, 2, 3, 1, 1, "Caracteristicas Existentes"));
		caracteristica.add(ManipuladorPosicionativo.AdicionarComBorda(v, 1, 1, 1, 1, "Valor Base"));
		caracteristica.add(ManipuladorPosicionativo.AdicionarComBorda(vmax, 2, 1, 1, 1, "Valor Maximo"));
		caracteristica.add(ManipuladorPosicionativo.AdicionarComBorda(vmin, 0, 1, 1, 1, "Valor Minimo"));
		caracteristica.add(ManipuladorPosicionativo.Adicionar(criarcaracteristica, 0, 2, 1, 3));
		caracteristica.add(ManipuladorPosicionativo.Adicionar(inserircaracteristica, 2, 4, 1, 1));
		caracteristica.add(ManipuladorPosicionativo.Adicionar(editarcaracteristica, 2, 5, 1, 1));
		caracteristica.add(ManipuladorPosicionativo.Adicionar(excluircaracteristica, 2, 6, 1, 1));
		return caracteristica;
	}
	
	private JPanel segmento = new JPanel();
	private JTextField nomesegmento = new JTextField();
	private JButton criarsegmento = new JButton("Criar Segmento");
	private JButton editarsegmento = new JButton("Editar Segmento");
	private JButton excluirsegmento = new JButton("Excluir Segmento");
	private JList<String> listasegmentos = new JList<String>();
	
	public JPanel painelsegmento() {
		segmento.setLayout(ManipuladorPosicionativo.getLayout());
		ManipuladorPosicionativo.configbasica();
		segmento.add(ManipuladorPosicionativo.AdicionarComBordaEScroll(listasegmentos, 0, 2, 1, 2, "Segmentos Inseridos"));
		segmento.add(ManipuladorPosicionativo.AdicionarComBorda(nomesegmento, 0, 0, 1, 2, "Nome Do Segmento"));
		segmento.add(ManipuladorPosicionativo.Adicionar(criarsegmento, 0, 1, 1, 2));
		segmento.add(ManipuladorPosicionativo.Adicionar(editarsegmento, 0, 3, 1, 1));
		segmento.add(ManipuladorPosicionativo.Adicionar(excluirsegmento, 1, 3, 1, 1));
		return segmento;
	}
	
	private JPanel paineldemanipulacao = new JPanel();
	
	public JPanel paineldemanipulacao() {
		paineldemanipulacao.setLayout(ManipuladorPosicionativo.getLayout());
		ManipuladorPosicionativo.configbasica();
		return paineldemanipulacao;
	}
	
	private Sistema sys = new Sistema();
	
	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		
		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(painelsistema(), 0, 0, 1, 1,"Configuracoess Basicas De Sistema"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(painelregra(), 0, 1, 1, 1, "Regras Do Sistema"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(painelsegmento(), 0, 2, 1, 1, "Segmentos Do Sistema"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(painelcaracteristica(), 0, 3, 1, 1, "Caracteristicas Das Entidades"));
		
		return super.getPainel();
	}
	
	
	
	
	
	
	
}
