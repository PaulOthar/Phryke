package formatos;

import java.util.ArrayList;

public class Sistema extends Formato {
	private String versao;
	
	//Alguns sistemas Variam com campos do sistema, como D&D,que tem dextreza, no 3d&t tem habilidade....
	private ArrayList<String> nomecampos;
	private ArrayList<Object> campos;
	
	public String getVersao() {
		return versao;
	}
	public ArrayList<String> getNomecampos() {
		return nomecampos;
	}
	public ArrayList<Object> getCampos() {
		return campos;
	}
	
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public void setNomecampos(ArrayList<String> nomecampos) {
		this.nomecampos = nomecampos;
	}
	public void setCampos(ArrayList<Object> campos) {
		this.campos = campos;
	}
}
