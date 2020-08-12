package recursosGraficos;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ManipuladorDeComponente {
	public static JComponent Borda(JComponent componente, String nome) {
		componente.setBorder(BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Color.BLACK, 1, true),
				nome, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), Color.BLACK));
		return componente;
	}

	public static JComponent BordaComScroll(JComponent componente, String nome) {
		return Borda(Scroll(componente), nome);
	}

	public static JComponent Scroll(JComponent componente) {
		return new JScrollPane(componente, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	public static JScrollPane Scroll(JPanel painel) {
		return new JScrollPane(painel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
}
