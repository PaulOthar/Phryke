package recursosGraficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ferramentas.Mensageiro;
import formatos.Regra;
import recursosGraficosPaineis.*;
import recursosLogicos.MeuNomeEhDado;

public class Frame {
	private static JFrame tela = new JFrame("RPG");
	private static JTabbedPane abas = new JTabbedPane();
	private static ArrayList<Boolean> status = new ArrayList<Boolean>();
	private static int Dado = 6;
	
	public static void BasicoDaTela() {
		tela.add(abas);
		tela.setJMenuBar(Menu());
		
		tela.setLocation(0, 0);
		tela.setSize(1000,500);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setVisible(true);
	}
	public static void Rodar() {
		InicializarStatus();
		BasicoDaTela();
	}
	
	public static JMenuBar Menu(){
        JMenuBar menu = new JMenuBar();
        JButton rolar = new JButton("Rolar Dado");
        JLabel resultado = new JLabel("[   0   ]");
        JSpinner seimor = new JSpinner();
        seimor.setMaximumSize(new Dimension(50,50));
        seimor.setValue(1);
        
        menu.add(MenuElementar());
        menu.add(MenuOpcoes());
        menu.add(Memenu());
        
        menu.add(MenuDados());
        menu.add(rolar);
        menu.add(seimor);
        menu.add(resultado);
        
        rolar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Integer) seimor.getValue() > 1) {
					int soma = 0,rolagem = 0;
					for(int i = 0;i<(Integer)seimor.getValue();i++) {
						rolagem = MeuNomeEhDado.RolarDado(Dado);
						if(i == 0) {
							resultado.setText(""+rolagem);
							soma = rolagem;
						}
						else {
							resultado.setText(resultado.getText()+"+"+rolagem);
							soma = soma + rolagem;
						}
					}
					resultado.setText("[ "+resultado.getText()+" = "+soma+" ]");
				}
				else {
					resultado.setText("[   "+MeuNomeEhDado.RolarDado(Dado)+"   ]");
				}
			}});
        seimor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if((Integer) seimor.getValue() <= 1) {
					seimor.setValue(1);
				}
			}});
        
        return menu;
    }
	
	@Deprecated
	public static JMenu MenuElementar() {
		JMenu menu = new JMenu();
		menu.setText("Elementos");
		
		ArrayList<JMenu> op = new ArrayList<JMenu>();
		ArrayList<JMenuItem> opp = new ArrayList<JMenuItem>();
		
		op.add(new JMenu("Sistemas"));
		op.add(new JMenu("Peculiaridades"));
		op.add(new JMenu("Caracteristicas"));
		op.add(new JMenu("Racas"));
		op.add(new JMenu("Itens"));
		op.add(new JMenu("Magias"));
		op.add(new JMenu("Criaturas"));
		op.add(new JMenu("Fichas"));
		
		opp.add(new JMenuItem("Criar Sistemas"));
		opp.add(new JMenuItem("Consultar Sistemas"));
		
		op.get(0).add(opp.get(0));
		op.get(0).add(opp.get(1));
		
		opp.add(new JMenuItem("Criar Peculiaridades"));
		opp.add(new JMenuItem("Consultar Peculiaridades"));
		
		op.get(1).add(opp.get(2));
		op.get(1).add(opp.get(3));
		
		opp.add(new JMenuItem("Criar Caracteristicas"));
		opp.add(new JMenuItem("Consultar Caracteristicas"));
		
		op.get(2).add(opp.get(4));
		op.get(2).add(opp.get(5));
		
		opp.add(new JMenuItem("Criar Racas"));
		opp.add(new JMenuItem("Criar Super Racas"));
		opp.add(new JMenuItem("Consultar Racas"));
		opp.add(new JMenuItem("Consultar Super Racas"));
		
		op.get(3).add(opp.get(6));
		op.get(3).add(opp.get(7));
		op.get(3).add(opp.get(8));
		op.get(3).add(opp.get(9));
		
		opp.add(new JMenuItem("Criar Itens"));
		opp.add(new JMenuItem("Consultar Itens"));
		
		op.get(4).add(opp.get(10));
		op.get(4).add(opp.get(11));
		
		opp.add(new JMenuItem("Criar Magias"));
		opp.add(new JMenuItem("Criar Escolas"));
		opp.add(new JMenuItem("Consultar Magias"));
		opp.add(new JMenuItem("Consultar Escolas"));
		
		op.get(5).add(opp.get(12));
		op.get(5).add(opp.get(13));
		op.get(5).add(opp.get(14));
		op.get(5).add(opp.get(15));
		
		opp.add(new JMenuItem("Criar Criaturas"));
		opp.add(new JMenuItem("Consultar Criaturas"));
		
		op.get(6).add(opp.get(16));
		op.get(6).add(opp.get(17));
		
		opp.add(new JMenuItem("Criar Fichas"));
		opp.add(new JMenuItem("Consultar Fichas"));
		
		op.get(7).add(opp.get(18));
		op.get(7).add(opp.get(19));
		
		//Todos os Mini-Menus, inseridos no menu, dentro da barra
		for(JMenuItem menui : op) {
			menu.add(menui);
		}
		//Fechar tudo
		opp.add(new JMenuItem("Fechar Tudo"));
		menu.add(opp.get(20));
		
		opp.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Sistema",0,new SistemaCriar().GerarPainel());
				
				//Se For Verdade
				if(status.get(0)) {
					op.get(0).setForeground(Color.RED);
					opp.get(0).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(1) == false) {
						op.get(0).setForeground(Color.BLACK);
					}
					opp.get(0).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Sistema",1,new SistemaConsultar().GerarPainel());
				
				//Se For Verdade
				if(status.get(1)) {
					op.get(0).setForeground(Color.RED);
					opp.get(1).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(0) == false) {
						op.get(0).setForeground(Color.BLACK);
					}
					opp.get(1).setForeground(Color.BLACK);
				}
				
			}});
		
		opp.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Peculiaridade",2,new PeculiaridadeCriar().GerarPainel());

				//Se For Verdade
				if(status.get(2)) {
					op.get(1).setForeground(Color.RED);
					opp.get(2).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(3) == false) {
						op.get(1).setForeground(Color.BLACK);
					}
					opp.get(2).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Peculiaridade",3,new PeculiaridadeConsultar().GerarPainel());

				//Se For Verdade
				if(status.get(3)) {
					op.get(1).setForeground(Color.RED);
					opp.get(3).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(2) == false) {
						op.get(1).setForeground(Color.BLACK);
					}
					opp.get(3).setForeground(Color.BLACK);
				}
				
			}});
		
		opp.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Caracteristica",4,new CaracteristicaCriar().GerarPainel());

				//Se For Verdade
				if(status.get(4)) {
					op.get(2).setForeground(Color.RED);
					opp.get(4).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(5) == false) {
						op.get(2).setForeground(Color.BLACK);
					}
					opp.get(4).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Caracteristica",5,new CaracteristicaConsultar().GerarPainel());

				//Se For Verdade
				if(status.get(5)) {
					op.get(2).setForeground(Color.RED);
					opp.get(5).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(4) == false) {
						op.get(2).setForeground(Color.BLACK);
					}
					opp.get(5).setForeground(Color.BLACK);
				}
				
			}});
		
		opp.get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Raca",6,new RacaCriar().GerarPainel());

				//Se For Verdade
				if(status.get(6)) {
					op.get(3).setForeground(Color.RED);
					opp.get(6).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(7) == false && status.get(8) == false && status.get(9) == false) {
						op.get(3).setForeground(Color.BLACK);
					}
					opp.get(6).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Super Raca",7,new SuperRacaCriar().GerarPainel());

				//Se For Verdade
				if(status.get(7)) {
					op.get(3).setForeground(Color.RED);
					opp.get(7).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(6) == false && status.get(8) == false && status.get(9) == false) {
						op.get(3).setForeground(Color.BLACK);
					}
					opp.get(7).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(8).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Raca",8,new RacaConsultar().GerarPainel());

				//Se For Verdade
				if(status.get(8)) {
					op.get(3).setForeground(Color.RED);
					opp.get(8).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(6) == false && status.get(7) == false && status.get(9) == false) {
						op.get(3).setForeground(Color.BLACK);
					}
					opp.get(8).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(9).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Super Raca",9,new SuperRacaConsultar().GerarPainel());

				//Se For Verdade
				if(status.get(9)) {
					op.get(3).setForeground(Color.RED);
					opp.get(9).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(6) == false && status.get(7) == false && status.get(8) == false) {
						op.get(3).setForeground(Color.BLACK);
					}
					opp.get(9).setForeground(Color.BLACK);
				}
				
			}});
		
		opp.get(10).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Item",10,new JPanel());

				//Se For Verdade
				if(status.get(10)) {
					op.get(4).setForeground(Color.RED);
					opp.get(10).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(11) == false) {
						op.get(4).setForeground(Color.BLACK);
					}
					opp.get(10).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(11).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Item",11,new JPanel());

				//Se For Verdade
				if(status.get(11)) {
					op.get(4).setForeground(Color.RED);
					opp.get(11).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(10) == false) {
						op.get(4).setForeground(Color.BLACK);
					}
					opp.get(11).setForeground(Color.BLACK);
				}
				
			}});
		
		opp.get(12).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Magia",12,new JPanel());

				//Se For Verdade
				if(status.get(12)) {
					op.get(5).setForeground(Color.RED);
					opp.get(12).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(13) == false && status.get(14) == false && status.get(15) == false) {
						op.get(5).setForeground(Color.BLACK);
					}
					opp.get(12).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(13).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Escola",13,new JPanel());

				//Se For Verdade
				if(status.get(13)) {
					op.get(5).setForeground(Color.RED);
					opp.get(13).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(12) == false && status.get(14) == false && status.get(15) == false) {
						op.get(5).setForeground(Color.BLACK);
					}
					opp.get(13).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(14).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Magia",14,new JPanel());

				//Se For Verdade
				if(status.get(14)) {
					op.get(5).setForeground(Color.RED);
					opp.get(14).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(12) == false && status.get(12) == false && status.get(15) == false) {
						op.get(5).setForeground(Color.BLACK);
					}
					opp.get(14).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(15).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Escola",15,new JPanel());

				//Se For Verdade
				if(status.get(15)) {
					op.get(5).setForeground(Color.RED);
					opp.get(15).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(12) == false && status.get(13) == false && status.get(14) == false) {
						op.get(5).setForeground(Color.BLACK);
					}
					opp.get(15).setForeground(Color.BLACK);
				}
				
			}});
		
		opp.get(16).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Criatura",16,new JPanel());

				//Se For Verdade
				if(status.get(16)) {
					op.get(6).setForeground(Color.RED);
					opp.get(16).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(17) == false) {
						op.get(6).setForeground(Color.BLACK);
					}
					opp.get(16).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(17).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Criatura",17,new JPanel());

				//Se For Verdade
				if(status.get(17)) {
					op.get(6).setForeground(Color.RED);
					opp.get(17).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(16) == false) {
						op.get(6).setForeground(Color.BLACK);
					}
					opp.get(17).setForeground(Color.BLACK);
				}
				
			}});
		
		opp.get(18).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Ficha",18,new JPanel());

				//Se For Verdade
				if(status.get(18)) {
					op.get(7).setForeground(Color.RED);
					opp.get(18).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(19) == false) {
						op.get(7).setForeground(Color.BLACK);
					}
					opp.get(18).setForeground(Color.BLACK);
				}
				
			}});
		opp.get(19).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Ficha",19,new JPanel());

				//Se For Verdade
				if(status.get(19)) {
					op.get(7).setForeground(Color.RED);
					opp.get(19).setForeground(Color.RED);
				}
				//Se For Falso
				else {
					if(status.get(18) == false) {
						op.get(7).setForeground(Color.BLACK);
					}
					opp.get(19).setForeground(Color.BLACK);
				}
				
			}});
		
		opp.get(20).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0;i<op.size();i++) {
					op.get(i).setForeground(Color.BLACK);
				}
				for(int i = 0;i<opp.size();i++) {
					opp.get(i).setForeground(Color.BLACK);
				}
				abas.removeAll();
				PadronizarStatus(false);
			}});
		
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
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D2");
				Dado = 2;
			}});
		
		dados.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D4");
				Dado = 4;
			}});
		
		dados.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D6");
				Dado = 6;
			}});
		
		dados.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D10");
				Dado = 10;
			}});
		
		dados.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D12");
				Dado = 12;
			}});
		
		dados.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D20");
				Dado = 20;
			}});
		
		dados.get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D50");
				Dado = 50;
			}});
		
		dados.get(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setText("Dado : D100");
				Dado = 100;
			}});
		
		
		for(JMenuItem m : dadoscriados) {
			dados.add(m);
		}
		
		for(JMenuItem m : dados) {
			m.setText("Rolar "+m.getText());
			menu.add(m);
		}
		
		return menu;
	}
	
	public static JMenu MenuOpcoes() {
		JMenu menu = new JMenu();
		menu.setText("Opcoes");
		
		menu.add(MenuDeAbas());
		menu.add(MenuDeEstilos());
		
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
			public void actionPerformed(ActionEvent e) {
				DefinirOrientacao("Cima");
			}});
		op.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefinirOrientacao("Direita");
			}});
		op.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefinirOrientacao("Esquerda");
			}});
		op.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefinirOrientacao("Baixo");
			}});
		
		for(JMenuItem m : op) {
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
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("Metal");
			}});
		op.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("Nimbus");
			}});
		op.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("CDE/Motif");
			}});
		op.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("Windows");
			}});
		op.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefinirEstilo("Windows Classic");
			}});
		
		for(JMenuItem m : op) {
			menu.add(m);
		}
		
		return menu;
	}
	
	
	public static JMenu Memenu() {
		//Meu Proprio Easter Egg, Com jogos e Pr*********!
		JMenu menu = new JMenu("Ajuda");
		JMenuItem meme = new JMenuItem("Te Vira");
		JMenuItem meme2 = new JMenuItem("Thanos de Saia");
		meme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mensageiro.GerarMensagemSimples("Nao e problema meu, te vira kkkk", "Te Vira");
			}});
		menu.add(meme);
		menu.add(meme2);
		return menu;
	}
	
	public static void InicializarStatus() {
		for(int i = 0;i<20;i++) {
			status.add(false);
		}
	}
	public static void PadronizarStatus(boolean b) {
		for(int i = 0;i<20;i++) {
			status.set(i,b);
		}
	}
	public static void UsarAba(String titulo,int index,JPanel painel) {
		if(status.get(index)) {
			abas.removeTabAt(abas.indexOfTab(titulo));
			status.set(index, false);
		}
		else {
			abas.addTab(titulo,painel);
			status.set(index, true);
		}
	}
	public static void DefinirOrientacao(String orientacao) {
		
		switch(orientacao){
			case "Direita":
				abas.setTabPlacement(JTabbedPane.RIGHT);
				break;
			
			case "Esquerda":
				abas.setTabPlacement(JTabbedPane.LEFT);
				break;
			
			case "Baixo":
				abas.setTabPlacement(JTabbedPane.BOTTOM);
				break;
			
			case "Cima":
				abas.setTabPlacement(JTabbedPane.TOP);
				break;
		}
	}
	public static void DefinirEstilo(String lnf){
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
}
