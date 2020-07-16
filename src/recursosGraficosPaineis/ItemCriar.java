package recursosGraficosPaineis;

import javax.swing.JPanel;

public class ItemCriar extends Pagina {

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		return super.getPainel();
	}

}
