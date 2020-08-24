package recursosGraficosPaineis;
/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import formatos.Caracteristica;
import formatos.Formato;
import formatos.Sistema;
import recursosGraficos.ManipuladorPosicionativo;
import recursosLogicos.DadosDeBanco;

public class CaracteristicaCriar extends Pagina {
	private Caracteristica cac = new Caracteristica();
	private JComboBox<String> Caracteristicareferencial = new JComboBox<String>(new String[] { "Nenhuma" });
	private JComboBox<String> Caracteristicareferencial2 = new JComboBox<String>(new String[] { "Nenhuma" });

	private JButton criarregra = new JButton("Criar Por Regra");
	private JButton criarvalor = new JButton("Criar Por Valor");
	private JTextArea descricao = new JTextArea();
	private JTextField nome = new JTextField();

	private JComboBox<String> operador = new JComboBox<String>(
			new String[] { "Somar", "Subtrair", "Multiplicar", "Dividir" });
	private JSpinner referencianumerica = new JSpinner();
	private JComboBox<String> sistemas = new JComboBox<String>(new String[] { "Nenhum" });
	private JSpinner valor = new JSpinner();
	private JSpinner valormax = new JSpinner();

	private JSpinner valormin = new JSpinner();

	public void AtualizarCaracteristicas() {
		Caracteristicareferencial.removeAllItems();
		Caracteristicareferencial2.removeAllItems();
		Caracteristicareferencial.addItem("Nenhuma");
		Caracteristicareferencial2.addItem("Nenhuma");
		for (String s : TratarCaracteristicas()) {
			Caracteristicareferencial.addItem(s);
			Caracteristicareferencial2.addItem(s);
		}
		Caracteristicareferencial.addItem("Atualizar");
		Caracteristicareferencial2.addItem("Atualizar");
		System.out.println("Lista De Caracteristicas Atualizada");
	}

	public void AtualizarNomes() {
		sistemas.removeAllItems();
		sistemas.addItem("Nenhum");
		for (String s : TratarNomes()) {
			sistemas.addItem(s);
		}
		sistemas.addItem("Atualizar");
		System.out.println("Lista De Nomes De Sistema Atualizada");
	}

	public void Funcionalidade() {
		criarregra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		criarvalor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!nome.getText().isBlank()) {
					System.out.println("Criando Caracteristica " + nome.getText());
					cac.setNome(nome.getText());
					int x = (int) valor.getValue(), y = (int) valormax.getValue(), z = (int) valormin.getValue();
					cac.setValor(x);
					cac.setValormaximo(y);
					cac.setValorminimo(z);
					if (sistemas.getSelectedItem() != "Nenhum" && sistemas.getSelectedItem() != "Atualizar") {
						ArrayList<Sistema> sys = new ArrayList<Sistema>();
						Sistema sis = new Sistema();
						for (Formato f : DadosDeBanco.Carregar(new Sistema())) {
							sys.add((Sistema) f);
						}
						for (Sistema s : sys) {
							String nome = s.getNome() + " - " + s.getVersao();
							if (sistemas.getSelectedItem().equals(nome)) {
								sis = s;
							}
						}
						Sistema sisv = new Sistema();
						sisv.DeCodigoParaDados(sis.DeDadosParaCodigo());
						sis.getCaracteristicas().add(cac.getNome());
						DadosDeBanco.Substituir(sisv, sis);
					}
					DadosDeBanco.SalvarUnico(cac);
					LimparTudo();
				} else {
					System.out.println("O Nome Do Sistema Esta Vazio");
				}
			}
		});
		Caracteristicareferencial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Caracteristicareferencial.getSelectedItem() == "Atualizar") {
					AtualizarCaracteristicas();
				}
			}
		});
		Caracteristicareferencial2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Caracteristicareferencial2.getSelectedItem() == "Atualizar") {
					AtualizarCaracteristicas();
				}
			}
		});
		sistemas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sistemas.getSelectedItem() == "Atualizar") {
					AtualizarNomes();
				}
			}
		});
	}

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();

		ManipuladorPosicionativo.configbasica();
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBordaEScroll(descricao, 0, 5, 1, 5,
				"Descricao Da Caracteristica"));

		ManipuladorPosicionativo.weightxy(1, 0);
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(sistemas, 1, 0, 1, 3, "Inserir no Sistema"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(nome, 0, 0, 1, 1, "Nome Da Caracteristica"));

		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(valor, 0, 1, 1, 2, "Valor Inicial"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(valormin, 0, 2, 1, 2, "Valor Minimo"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(valormax, 0, 3, 1, 2, "Valor Maximo"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(criarvalor, 0, 4, 1, 2));

		super.adicionaraopainel(
				ManipuladorPosicionativo.AdicionarComBorda(Caracteristicareferencial, 2, 1, 1, 2, "Caracteristica"));
		super.adicionaraopainel(ManipuladorPosicionativo.AdicionarComBorda(operador, 2, 2, 1, 2, "Operador"));
		super.adicionaraopainel(
				ManipuladorPosicionativo.AdicionarComBorda(referencianumerica, 2, 3, 1, 1, "Valor Operante"));
		super.adicionaraopainel(
				ManipuladorPosicionativo.AdicionarComBorda(Caracteristicareferencial2, 3, 3, 1, 1, "Caracteristica"));
		super.adicionaraopainel(ManipuladorPosicionativo.Adicionar(criarregra, 2, 4, 1, 2));

		Funcionalidade();
		AtualizarNomes();
		AtualizarCaracteristicas();
		return super.getPainel();
	}

	public void LimparTudo() {
		cac = new Caracteristica();
		referencianumerica.setValue(0);
		valormax.setValue(0);
		valormin.setValue(0);
		valor.setValue(0);
		descricao.setText("");
		nome.setText("");
		sistemas.setSelectedIndex(0);
	}

	public String[] TratarCaracteristicas() {
		ArrayList<Formato> nomes = DadosDeBanco.Carregar(new Caracteristica());
		String[] listanomes = new String[nomes.size()];
		for (int i = 0; i < nomes.size(); i++) {
			Caracteristica s = (Caracteristica) nomes.get(i);
			listanomes[i] = s.getNome();
		}
		return listanomes;
	}

	public String[] TratarNomes() {
		ArrayList<Formato> nomes = DadosDeBanco.Carregar(new Sistema());
		String[] listanomes = new String[nomes.size()];
		for (int i = 0; i < nomes.size(); i++) {
			Sistema s = (Sistema) nomes.get(i);
			listanomes[i] = s.getNome() + " - " + s.getVersao();
		}
		return listanomes;
	}
}
*/