package recursosGraficosPaineis;

import javax.swing.JPanel;

public abstract class FormatoAba {
	private JPanel painel = new JPanel();

	public abstract JPanel GerarPainel();
	
 	public JPanel getPainel() {
		return painel;
	}

	public void setPainel(JPanel painel) {
		this.painel = painel;
	}
}
