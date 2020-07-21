package recursosGraficosPaineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ferramentas.Mensageiro;
import formatos.Caracteristica;
import formatos.Formato;
import formatos.Sistema;
import recursosGraficos.ManipuladorPosicionativo;
import recursosLogicos.DadosDeBanco;

public class SistemaConsultar extends Pagina {
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] {"Selecione"});
	private JTextArea visualizador = new JTextArea();
		
	private JComboBox<String> regras = new JComboBox<String>(new String[] {"Em Desenvolvimento"});
	private JTextArea descricao = new JTextArea();
	
	private JButton removerregra = new JButton("Remover Regra");
	private JButton excluir = new JButton("Excluir Sistema");
	
	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		
		descricao.setEditable(false);
		visualizador.setEditable(false);
		//descricao.setLineWrap(true);
		
		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(visualizador, 0, 1, 1, 1, "Estrutura"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricao, 1, 1, 1, 1, "Descricao"));
		
		ManipuladorPosicionativo.weightxy(1, 0);
		
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 0, 0, 1, 1, "Sistemas"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(regras, 1, 0, 1, 1, "Regras"));
		
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(removerregra, 1, 2, 1, 1));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(excluir, 0, 2, 1, 1));
		
		AtualizarNomes();
		Funcionalidade();
		
		return super.getPainel();
	}
	public void Funcionalidade() {
		removerregra.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			}});
		
		excluir.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			if(sistemas.getSelectedItem() != "Atualizar" && sistemas.getSelectedItem() != "Selecione") {
				if(Mensageiro.PedirConfirmacao("Deseja Mesmo Excluir o Sistema "+sistemas.getSelectedItem()+"?")) {
					ArrayList<Sistema> sys = new ArrayList<Sistema>();
					Sistema sis = new Sistema();
					for(Formato f : DadosDeBanco.Carregar(new Sistema())) {
						sys.add((Sistema)f);
					}
					for(Sistema s : sys) {
						String nome = s.getNome()+" - "+s.getVersao();
						if(sistemas.getSelectedItem().equals(nome)) {
							sis = s;
						}
					}
					DadosDeBanco.Excluir(sis);
				}
				
			}
			
		}});
		
		sistemas.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {

			if(sistemas.getSelectedItem() == "Atualizar") {
				AtualizarNomes();
			}
			else if(sistemas.getSelectedItem() != "Selecione"){
				System.out.println(sistemas.getSelectedItem()+" Selecionado");
				ArrayList<String> texto = new ArrayList<String>();
				String textoformatado = new String();
				ArrayList<Caracteristica> c = new ArrayList<Caracteristica>();
				ArrayList<Sistema> sys = new ArrayList<Sistema>();
				Sistema sis = new Sistema();
				for(Formato f : DadosDeBanco.Carregar(new Sistema())) {
					sys.add((Sistema)f);
				}
				for(Sistema s : sys) {
					String nome = s.getNome()+" - "+s.getVersao();
					if(sistemas.getSelectedItem().equals(nome)) {
						sis = s;
					}
				}
				for(Formato f : DadosDeBanco.Carregar(new Caracteristica())) {
					for(String s : sis.getCaracteristicas()) {
						if(f.getNome().contentEquals(s)) {
							c.add((Caracteristica) f);
						}
					}
				}
				texto.add("Nome: "+sis.getNome());
				texto.add("Versao: "+sis.getVersao());
				texto.add("\n");
				texto.add("Caracteristicas:");
				for(Caracteristica cc : c) {
					texto.add(cc.getNome()+" : Minimo:"+cc.getValorminimo()+" / Base:"+cc.getValor()+" / Maximo:"+cc.getValormaximo());
				}
				texto.add("\n");
				texto.add("Segmentos:");
				for(String s : sis.getSegmentos()) {
					texto.add("+"+s);
				}
				
				for(int i = 0;i<texto.size();i++) {
					textoformatado = textoformatado + texto.get(i) + "\n";
				}
				
				visualizador.setText(textoformatado);
			}
			}});
	}
	
	public String[] TratarNomes() {
		ArrayList<Formato> nomes = DadosDeBanco.Carregar(new Sistema());
		String[] listanomes = new String[nomes.size()];
		for(int i = 0;i<nomes.size();i++) {
			Sistema s = (Sistema) nomes.get(i);
			listanomes[i] = s.getNome()+" - "+s.getVersao();
		}
		return listanomes;
	}
	public void AtualizarNomes() {
		sistemas.removeAllItems();
		sistemas.addItem("Selecione");
		for(String s : TratarNomes()) {
			sistemas.addItem(s);
		}
		sistemas.addItem("Atualizar");
		System.out.println("Lista De Nomes De Sistema Atualizada");
	}
	public void SetarPainel(JPanel p) {
		super.setPainel(p);
	}
}
