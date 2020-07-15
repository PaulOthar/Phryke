package recursosGraficosPaineis;

import javax.swing.JPanel;

import recursosGraficos.ManipuladorPosicionativo;

public abstract class Pagina {
	private JPanel painel = new JPanel();

	Pagina() {
		ManipuladorPosicionativo.Resetar();
		this.setPainel(new JPanel());
	}
	
	public abstract JPanel GerarPainel();
	
 	public JPanel getPainel() {
		return painel;
	}

	public void setPainel(JPanel painel) {
		this.painel = painel;
	}
}
