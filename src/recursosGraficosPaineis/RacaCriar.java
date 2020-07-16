package recursosGraficosPaineis;

import javax.swing.JPanel;

public class RacaCriar extends Pagina {

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		return super.getPainel();
	}

}
