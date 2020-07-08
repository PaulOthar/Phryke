package recursosGraficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Frame {
	private static JFrame tela = new JFrame("RPG");
	private static JTabbedPane abas = new JTabbedPane();
	private static ArrayList<Boolean> status = new ArrayList<Boolean>();
	
	public static void BasicoDaTela() {
		tela.add(abas);
		tela.setJMenuBar(Menu());
		
		tela.setLocation(0, 0);
		tela.setSize(1000,500);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setVisible(true);
	}
	public static void Rodar() {
		AtualizarStatus();
		BasicoDaTela();
	}
	
	public static JMenuBar Menu(){
        JMenuBar menu = new JMenuBar();
        menu.add(MenuElementar());
        menu.add(MenuDeAbas());
        return menu;
    }
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
		
		for(JMenuItem menui : op) {
			menu.add(menui);
		}
		opp.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Sistema",0,new JPanel());
			}});
		opp.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Sistema",1,new JPanel());
			}});
		opp.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Peculiaridade",2,new JPanel());
			}});
		opp.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Peculiaridade",3,new JPanel());
			}});
		opp.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Caracteristica",4,new JPanel());
			}});
		opp.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Caracteristica",5,new JPanel());
			}});
		opp.get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Raca",6,new JPanel());
			}});
		opp.get(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Super Raca",7,new JPanel());
			}});
		opp.get(8).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Raca",8,new JPanel());
			}});
		opp.get(9).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Super Raca",9,new JPanel());
			}});
		opp.get(10).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Item",10,new JPanel());
			}});
		opp.get(11).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Item",11,new JPanel());
			}});
		opp.get(12).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Magia",12,new JPanel());
			}});
		opp.get(13).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Escola",13,new JPanel());
			}});
		opp.get(14).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Magia",14,new JPanel());
			}});
		opp.get(15).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Escola",15,new JPanel());
			}});
		opp.get(16).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Criatura",16,new JPanel());
			}});
		opp.get(17).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Criatura",17,new JPanel());
			}});
		opp.get(18).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Criar Ficha",18,new JPanel());
			}});
		opp.get(19).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsarAba("Consultar Ficha",19,new JPanel());
			}});
		
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
	
	public static void AtualizarStatus() {
		for(int i = 0;i<20;i++) {
			status.add(false);
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
}
