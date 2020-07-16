package recursosGraficosPaineis;

import javax.swing.JPanel;

public class ItemConsultar extends Pagina {

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		return super.getPainel();
	}

}
