package recursosGraficos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;

public class ManipuladorPosicionativo {
	private static GridBagLayout layout = new GridBagLayout();
	private static GridBagConstraints limitacao = new GridBagConstraints();
	
	public static void Resetar() {
		ManipuladorPosicionativo.setLayout(new GridBagLayout());
		ManipuladorPosicionativo.setLimitacao(new GridBagConstraints());
	}
	
	public static JComponent Adicionar(JComponent componente,int x,int y,int altura,int largura) {
		ManipuladorPosicionativo.gridxy(x,y);
		ManipuladorPosicionativo.gridwh(altura, largura);
		ManipuladorPosicionativo.getLayout().setConstraints(componente, getLimitacao());
		return componente;
	}
	public static JComponent AdicionarComBorda(JComponent componente,int x,int y,int altura,int largura,String titulo) {
		return Adicionar(ManipuladorDeComponente.Borda(componente,titulo),x,y,altura,largura);
	}
	public static JComponent AdicionarComBordaEScroll(JComponent componente,int x,int y,int altura,int largura,String titulo) {
		return Adicionar(ManipuladorDeComponente.BordaComScroll(componente,titulo),x,y,altura,largura);
	}
	
	public static void configbasica() {
		ManipuladorPosicionativo.weightxy(1,1);
		ManipuladorPosicionativo.fill(GridBagConstraints.BOTH);
	}
	public static void weightxy(int x,int y) {
		getLimitacao().weightx = x;
		getLimitacao().weighty = y;
	}
	public static void ipadxy(int x,int y) {
		getLimitacao().ipadx = x;
		getLimitacao().ipady = y;
	}
	public static void fill(int GridBagConstraints) {
		getLimitacao().fill = GridBagConstraints;
	}
	
	public static void gridxy(int x,int y) {
		getLimitacao().gridx = x;
		getLimitacao().gridy = y;
	}
	public static void gridwh(int altura,int largura) {
		getLimitacao().gridheight = altura;
		getLimitacao().gridwidth = largura;
	}
	
	public static GridBagLayout getLayout() {
		return layout;
	}
	public static GridBagConstraints getLimitacao() {
		return limitacao;
	}
	
	public static void setLayout(GridBagLayout layout) {
		ManipuladorPosicionativo.layout = layout;
	}
	public static void setLimitacao(GridBagConstraints limitacao) {
		ManipuladorPosicionativo.limitacao = limitacao;
	}
}
