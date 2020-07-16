package recursosGraficosPaineis;

import javax.swing.JPanel;

public class FichaCriar extends Pagina {

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		return super.getPainel();
	}

}
