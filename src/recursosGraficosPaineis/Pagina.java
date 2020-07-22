package recursosGraficosPaineis;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import recursosGraficos.ManipuladorDeComponente;
import recursosGraficos.ManipuladorPosicionativo;

public abstract class Pagina {
	private JPanel painel = new JPanel();

	Pagina() {
		ManipuladorPosicionativo.Resetar();
		this.setPainel(new JPanel());
	}
	
	public abstract JPanel GerarPainel();
	
	public JScrollPane GerarPainelScrollavel(){
		JScrollPane Scrollado = ManipuladorDeComponente.Scroll(GerarPainel());
		Scrollado.getVerticalScrollBar().setUnitIncrement(15);
		return Scrollado;
	}
	
	public void adicionaraopainel(JComponent componente) {
		this.getPainel().add(componente);
	}
	
	public void Inicializar() {
		ManipuladorPosicionativo.Inicializar();
		this.setPainel(new JPanel());
		this.getPainel().setLayout(ManipuladorPosicionativo.getLayout());
	}
	
 	public JPanel getPainel() {
		return painel;
	}

	public void setPainel(JPanel painel) {
		this.painel = painel;
	}
}
