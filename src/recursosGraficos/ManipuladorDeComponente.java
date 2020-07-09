package recursosGraficos;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class ManipuladorDeComponente {
	public static void borda(JComponent componente,String nome) {
		componente.setBorder(BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Color.BLACK, 1, true), nome, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), Color.BLACK));
	}
	public static JComponent bordaC(JComponent componente,String nome) {
		componente.setBorder(BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(Color.BLACK, 1, true), nome, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), Color.BLACK));
		return componente;
	}
}
