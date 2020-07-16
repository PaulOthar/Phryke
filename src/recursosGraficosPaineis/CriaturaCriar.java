package recursosGraficosPaineis;

import javax.swing.JPanel;

public class CriaturaCriar extends Pagina {

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		return super.getPainel();
	}

}
