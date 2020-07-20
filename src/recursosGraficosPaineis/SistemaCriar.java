package recursosGraficosPaineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import formatos.Caracteristica;
import formatos.Formato;
import formatos.Sistema;
import recursosGraficos.ManipuladorPosicionativo;
import recursosLogicos.DadosDeBanco;

public class SistemaCriar extends Pagina{
	JTextField nome = new JTextField(),nomesegmentos = new JTextField();
	JList<String> segmentos = new JList<String>(),caracteristicas = new JList<String>();
	JButton	botaosistema = new JButton("Criar");
	JButton botaocaracteristicaa = new JButton("Adicionar Caracteristica");
	JButton botaocaracteristicar = new JButton("Remover Caracteristica");
	JButton botaosegmentoa = new JButton("Adicionar Segmento");
	JButton botaosegmentor = new JButton("Remover Segmento");
	JComboBox<String> caracteristicasexi = new JComboBox<String>(new String[] {"Selecione","Atualizar"});
	
	Sistema sys = new Sistema();
	
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
		
		Funcionalidade();
		AtualizarCaracteristicasCombo();
		return super.getPainel();
	}
	
	public void Funcionalidade() {
		botaosistema.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			String nomedozistema = nome.getText();
			if(!nomedozistema.isBlank()) {
				System.out.println("Criando Sistema "+nomedozistema);
				sys.setNome(nomedozistema);
				ArrayList<String> nomes = DadosDeBanco.PegarNomes(new Sistema());
				if(nomes.contains(nomedozistema)) {
					int contador = 0;
					for(String s : nomes) {
						if(s.contains(nomedozistema)) {
							contador++;
						}
					}
					sys.setVersao(contador+".0");
				}
				else {
					sys.setVersao(1+".0");
				}
				DadosDeBanco.SalvarUnico(sys);
				LimparTudo();
			}
			else {
				System.out.println("O Nome Do Sistema Esta Vazio");
			}
			}});
		
		botaocaracteristicaa.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {

			String caracteristica = (String) caracteristicasexi.getSelectedItem();
			if(!caracteristica.contentEquals("Selecione") && !caracteristica.contentEquals("Atualizar")) {
				System.out.println("Inserindo Caracteristica "+caracteristica+" No Sistema");
				sys.getCaracteristicas().add(caracteristica);
				AtualizarCaracteristicas();
			}
			else {
				System.out.println("Nenhuma Caracteristica Selecionada");
			}
			}});
		
		botaocaracteristicar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			String caracteristica = (String) caracteristicasexi.getSelectedItem();
			if(!caracteristica.contentEquals("Selecione")) {
				if(sys.getCaracteristicas().contains(caracteristica)) {
					System.out.println("Removendo Caracteristica "+caracteristica+" Do Sistema");
					sys.getCaracteristicas().remove(caracteristica);
					AtualizarCaracteristicas();
				}
				else {
					System.out.println("A Caracteristica "+caracteristica+" Non Ecziste");
				}
			}
			else {
				System.out.println("Nenhuma Caracteristica Selecionada");
			}
			}});
		
		botaosegmentoa.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			String nomeinserido = nomesegmentos.getText();
			if(!nomeinserido.isBlank()) {
				System.out.println("Inserindo Segmento "+nomeinserido+" No Sistema");
				sys.getSegmentos().add(nomeinserido);
				AtualizarSegmentos();
			}
			else {
				System.out.println("O Nome Do Segmento Esta Vazio");
			}
			}});
		
		botaosegmentor.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {

			String nomeinserido = nomesegmentos.getText();
			if(!nomeinserido.isBlank()) {
				if(sys.getSegmentos().contains(nomeinserido)) {
					System.out.println("Removendo Segmento "+nomeinserido+" Do Sistema");
					sys.getSegmentos().remove(nomeinserido);
					AtualizarSegmentos();
				}
				else {
					System.out.println("O Segmento "+nomeinserido+" Non Ecziste");
				}
			}
			else {
				System.out.println("O Nome Do Segmento Esta Vazio");
			}
			}});
		
		caracteristicasexi.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(caracteristicasexi.getSelectedItem() == "Atualizar") {
				AtualizarCaracteristicasCombo();
			}
			else {
				System.out.println(caracteristicasexi.getSelectedItem()+" Selecionado");
			}
			}});
	}
	public void AtualizarSegmentos() {
		String[] x = new String[sys.getSegmentos().size()];
		for(int i = 0;i<sys.getSegmentos().size();i++) {
			x[i] = sys.getSegmentos().get(i);
		}
		segmentos.setListData(x);
	}
	public void AtualizarCaracteristicas() {
		String[] x = new String[sys.getCaracteristicas().size()];
		for(int i = 0;i<sys.getCaracteristicas().size();i++) {
			x[i] = sys.getCaracteristicas().get(i);
		}
		caracteristicas.setListData(x);
	}
	public String[] TratarCaracteristicas() {
		ArrayList<Formato> nomes = DadosDeBanco.Carregar(new Caracteristica());
		String[] listanomes = new String[nomes.size()];
		for(int i = 0;i<nomes.size();i++) {
			Caracteristica s = (Caracteristica) nomes.get(i);
			listanomes[i] = s.getNome();
		}
		return listanomes;
	}
	public void AtualizarCaracteristicasCombo() {
		caracteristicasexi.removeAllItems();
		caracteristicasexi.addItem("Selecione");
		for(String s : TratarCaracteristicas()) {
			caracteristicasexi.addItem(s);
		}
		caracteristicasexi.addItem("Atualizar");
		System.out.println("Lista De Nomes De Caracteristicas Atualizada");
	}
	public void LimparTudo() {
		this.nome.setText("");
		this.nomesegmentos.setText("");
		this.segmentos.setListData(new String[] {});
		this.caracteristicas.setListData(new String[] {});
		this.caracteristicasexi.removeAllItems();
		this.sys = new Sistema();
		AtualizarCaracteristicasCombo();
	}
}
