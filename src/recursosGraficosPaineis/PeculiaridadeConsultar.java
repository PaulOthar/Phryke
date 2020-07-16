package recursosGraficosPaineis;

import javax.swing.JPanel;

public class PeculiaridadeConsultar extends Pagina {

	@Override
	public JPanel GerarPainel() {
		super.Inicializar();
		return super.getPainel();
	}

}
