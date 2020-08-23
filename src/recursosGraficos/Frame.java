package recursosGraficos;
/*
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ferramentas.Mensageiro;
import recursosGraficosPaineis.CaracteristicaConsultar;
import recursosGraficosPaineis.CaracteristicaCriar;
import recursosGraficosPaineis.CriarSistema;
import recursosGraficosPaineis.FichaConsultar;
import recursosGraficosPaineis.FichaCriar;
import recursosGraficosPaineis.PeculiaridadeConsultar;
import recursosGraficosPaineis.PeculiaridadeCriar;
import recursosGraficosPaineis.RacaConsultar;
import recursosGraficosPaineis.RacaCriar;
import recursosGraficosPaineis.SistemaConsultar;
import recursosGraficosPaineis.SistemaCriar;
import recursosGraficosPaineis.SuperRacaConsultar;
import recursosGraficosPaineis.SuperRacaCriar;
import recursosLogicos.MeuNomeEhDado;

public class Frame {
	private static JTabbedPane abas = new JTabbedPane();
	private static int Dado = 6;
	private static ArrayList<Boolean> izdadus = new ArrayList<Boolean>();
	private static JFrame tela = new JFrame("RPG");

	public static void BasicoDaTela() {
		tela.add(abas);
		tela.setJMenuBar(Menu());

		tela.setLocation(0, 0);
		tela.setSize(1000, 500);
		tela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		tela.setVisible(true);
	}

	public static void DefinirEstilo(String lnf) {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if (lnf.equals(info.getName())) {
				try {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					javax.swing.SwingUtilities.updateComponentTreeUI(tela);
				} catch (Exception e) {
					return;
				}

				break;
			}
		}
	}

	public static void DefinirOrientacao(String orientacao) {

		switch (orientacao) {
		case "Direita":
			abas.setTabPlacement(SwingConstants.RIGHT);
			break;

		case "Esquerda":
			abas.setTabPlacement(SwingConstants.LEFT);
			break;

		case "Baixo":
			abas.setTabPlacement(SwingConstants.BOTTOM);
			break;

		case "Cima":
			abas.setTabPlacement(SwingConstants.TOP);
			break;
		}
	}

	public static JMenu InserirItens(JMenu menu, String nomesubmenu, String[] nomeitens, JPanel[] paineis) {

		JMenu submenu = new JMenu(nomesubmenu);

		if (nomeitens.length == paineis.length) {
			for (int i = 0; i < nomeitens.length; i++) {
				JMenuItem item = new JMenuItem(nomeitens[i]);
				int index = izdadus.size();
				izdadus.add(false);
				System.out.println(izdadus.size());
				int x = i;
				item.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(x);
						System.out.println(index);
						UsarAbas(nomeitens[x], index, paineis[x]);
					}
				});

				submenu.add(item);
			}
		}

		menu.add(submenu);
		return menu;
	}

	public static JMenu InserirItens(JMenu menu, String nomesubmenu, String[] nomeitens, JScrollPane[] paineis) {

		JMenu submenu = new JMenu(nomesubmenu);

		if (nomeitens.length == paineis.length) {
			for (int i = 0; i < nomeitens.length; i++) {
				JMenuItem item = new JMenuItem(nomeitens[i]);
				int index = izdadus.size();
				izdadus.add(false);
				System.out.println(izdadus.size());
				int x = i;
				item.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(x);
						System.out.println(index);
						UsarAbas(nomeitens[x], index, paineis[x]);
					}
				});

				submenu.add(item);
			}
		}

		menu.add(submenu);
		return menu;
	}

	public static JMenu Memenu() {
		// Meu Proprio Easter Egg, Com jogos e Pr*********!
		JMenu menu = new JMenu("Ajuda");
		JMenuItem meme = new JMenuItem("Te Vira");
		meme.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Mensageiro.GerarMensagemSimples("Nao e problema meu, te vira kkkk", "Te Vira");
			}
		});
		menu.add(meme);
		return menu;
	}

	public static JMenuBar Menu() {
		JMenuBar menu = new JMenuBar();

		menu.add(MenuElemental());
		menu.add(MenuOpcoes());
		menu.add(Memenu());

		return MenuComDado(menu);
	}

	public static JMenuBar MenuComDado(JMenuBar menu) {
		JButton rolar = new JButton("Rolar Dado");
		JLabel resultado = new JLabel("[   0   ]");
		JSpinner seimor = new JSpinner();
		seimor.setMaximumSize(new Dimension(50, 50));
		seimor.setValue(1);

		menu.add(MenuDados());
		menu.add(rolar);
		menu.add(seimor);
		menu.add(resultado);

		rolar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((Integer) seimor.getValue() > 1) {
					int soma = 0, rolagem = 0;
					for (int i = 0; i < (Integer) seimor.getValue(); i++) {
						rolagem = MeuNomeEhDado.RolarDado(Dado);
						if (i == 0) {
							resultado.setText("" + rolagem);
							soma = rolagem;
						} else {
							resultado.setText(resultado.getText() + "+" + rolagem);
							soma = soma + rolagem;
						}
					}
					resultado.setText("[ " + resultado.getText() + " = " + soma + " ]");
				} else {
					resultado.setText("[   " + MeuNomeEhDado.RolarDado(Dado) + "   ]");
				}
			}
		});
		seimor.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if ((Integer) seimor.getValue() <= 1) {
					seimor.setValue(1);
				}
			}
		});
		return menu;
	}

	@Deprecated
	public static JMenu MenuDados() {
		JMenu menu = new JMenu();
		menu.setText("Dado : D6");

		ArrayList<JMenuItem> dados = new ArrayList<JMenuItem>();
		ArrayList<JMenuItem> dadoscriados = new ArrayList<JMenuItem>();

		dados.add(new JMenuItem("D2"));
		dados.add(new JMenuItem("D4"));
		dados.add(new JMenuItem("D6"));
		dados.add(new JMenuItem("D10"));
		dados.add(new JMenuItem("D12"));
		dados.add(new JMenuItem("D20"));
		dados.add(new JMenuItem("D50"));
		dados.add(new JMenuItem("D100"));

		dados.get(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D2");
				Dado = 2;
			}
		});

		dados.get(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D4");
				Dado = 4;
			}
		});

		dados.get(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D6");
				Dado = 6;
			}
		});

		dados.get(3).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D10");
				Dado = 10;
			}
		});

		dados.get(4).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D12");
				Dado = 12;
			}
		});

		dados.get(5).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D20");
				Dado = 20;
			}
		});

		dados.get(6).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D50");
				Dado = 50;
			}
		});

		dados.get(7).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D100");
				Dado = 100;
			}
		});

		for (JMenuItem m : dadoscriados) {
			dados.add(m);
		}

		for (JMenuItem m : dados) {
			m.setText("Rolar " + m.getText());
			menu.add(m);
		}

		return menu;
	}

	public static JMenu MenuDeAbas() {
		JMenu menu = new JMenu();
		menu.setText("Posicao Das Abas");
		ArrayList<JMenuItem> op = new ArrayList<JMenuItem>();

		op.add(new JMenuItem("Cima"));
		op.add(new JMenuItem("Direita"));
		op.add(new JMenuItem("Esquerda"));
		op.add(new JMenuItem("Baixo"));

		op.get(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefinirOrientacao("Cima");
			}
		});
		op.get(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefinirOrientacao("Direita");
			}
		});
		op.get(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefinirOrientacao("Esquerda");
			}
		});
		op.get(3).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefinirOrientacao("Baixo");
			}
		});

		for (JMenuItem m : op) {
			menu.add(m);
		}

		return menu;
	}

	public static JMenu MenuDeEstilos() {
		JMenu menu = new JMenu();
		menu.setText("Estilo Ja Janela");
		ArrayList<JMenuItem> op = new ArrayList<JMenuItem>();

		op.add(new JMenuItem("Metal"));
		op.add(new JMenuItem("Nimbus"));
		op.add(new JMenuItem("CDE/Motif"));
		op.add(new JMenuItem("Windows"));
		op.add(new JMenuItem("Windows Classic"));

		op.get(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("Metal");
			}
		});
		op.get(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("Nimbus");
			}
		});
		op.get(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("CDE/Motif");
			}
		});
		op.get(3).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("Windows");
			}
		});
		op.get(4).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("Windows Classic");
			}
		});

		for (JMenuItem m : op) {
			menu.add(m);
		}

		return menu;
	}

	public static JMenu MenuElemental() {
		JMenu menu = new JMenu("Elementos");
		JMenuItem f = new JMenuItem("Fechar Tudo");

		menu = InserirItens(menu, "Sistemas", new String[] { "Criar Sistema", "Consultar Sistema" },
				new JPanel[] { new SistemaCriar().GerarPainel(), new SistemaConsultar().GerarPainel() });
		menu = InserirItens(menu, "Caracteristicas",
				new String[] { "Criar Caracteristicas", "Consultar Características" },
				new JPanel[] { new CaracteristicaCriar().GerarPainel(), new CaracteristicaConsultar().GerarPainel() });
		menu = InserirItens(menu, "Peculiaridades", new String[] { "Criar Peculiaridade", "Consultar Peculiaridade" },
				new JPanel[] { new PeculiaridadeCriar().GerarPainel(), new PeculiaridadeConsultar().GerarPainel() });
		menu = InserirItens(menu, "Racas", new String[] { "Criar Raca", "Consultar Raca" },
				new JPanel[] { new RacaCriar().GerarPainel(), new RacaConsultar().GerarPainel() });
		menu = InserirItens(menu, "Super Racas", new String[] { "Criar Super Raca", "Consultar Super Raca" },
				new JPanel[] { new SuperRacaCriar().GerarPainel(), new SuperRacaConsultar().GerarPainel() });
		menu = InserirItens(menu, "Fichas", new String[] { "Criar Ficha", "Consultar Ficha" },
				new JPanel[] { new FichaCriar().GerarPainel(), new FichaConsultar().GerarPainel() });
		menu = InserirItens(menu, "Teste", new String[] { "Teste Sistema" },
				new JScrollPane[] { new CriarSistema().GerarPainelScrollavel() });
		menu.add(f);

		f.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abas.removeAll();
				PadronizarIzdadus(false);
			}
		});
		return menu;
	}

	public static JMenu MenuOpcoes() {
		JMenu menu = new JMenu();
		menu.setText("Opcoes");

		menu.add(MenuDeAbas());
		menu.add(MenuDeEstilos());

		return menu;
	}

	public static void PadronizarIzdadus(boolean b) {
		for (int i = 0; i < izdadus.size(); i++) {
			izdadus.set(i, b);
		}
	}

	public static void Rodar() {
		BasicoDaTela();
	}

	public static void UsarAbaComScroll(String titulo, int index, JPanel painel) {
		if (izdadus.get(index)) {
			abas.removeTabAt(abas.indexOfTab(titulo));
			izdadus.set(index, false);
		} else {
			JScrollPane Scrollado = ManipuladorDeComponente.Scroll(painel);
			Scrollado.getVerticalScrollBar().setUnitIncrement(15);
			abas.addTab(titulo, Scrollado);
			izdadus.set(index, true);
		}
	}

	public static void UsarAbas(String titulo, int index, JPanel painel) {
		if (izdadus.get(index)) {
			abas.removeTabAt(abas.indexOfTab(titulo));
			izdadus.set(index, false);
		} else {
			abas.addTab(titulo, painel);
			izdadus.set(index, true);
		}
	}

	public static void UsarAbas(String titulo, int index, JScrollPane painel) {
		if (izdadus.get(index)) {
			abas.removeTabAt(abas.indexOfTab(titulo));
			izdadus.set(index, false);
		} else {
			abas.addTab(titulo, painel);
			izdadus.set(index, true);
		}
	}
}
*/