package formatos;

import java.util.ArrayList;

public class SuperPeculiaridade extends Formato {
	private String Sistema,Segmento,Detalhe;
	private double ValorAssociado;
	private ArrayList<String> NomeCaracteristicas;
	private ArrayList<Double> ModificadorCaracteristica;
	private ArrayList<Peculiaridade> Peculiaridades;
	
	public SuperPeculiaridade() {
		this.setSistema("");
		this.setSegmento("");
		this.setDetalhe("");
		this.setValorAssociado(0);
		this.setNomeCaracteristicas(new ArrayList<String>());
		this.setModificadorCaracteristica(new ArrayList<Double>());
		this.setPeculiaridades(new ArrayList<Peculiaridade>());
	}

	public String getSistema() {
		return Sistema;
	}

	public String getSegmento() {
		return Segmento;
	}

	public String getDetalhe() {
		return Detalhe;
	}

	public double getValorAssociado() {
		return ValorAssociado;
	}

	public ArrayList<String> getNomeCaracteristicas() {
		return NomeCaracteristicas;
	}

	public ArrayList<Double> getModificadorCaracteristica() {
		return ModificadorCaracteristica;
	}

	public ArrayList<Peculiaridade> getPeculiaridades() {
		return Peculiaridades;
	}

	public void setSistema(String sistema) {
		Sistema = sistema;
	}

	public void setSegmento(String segmento) {
		Segmento = segmento;
	}

	public void setDetalhe(String detalhe) {
		Detalhe = detalhe;
	}

	public void setValorAssociado(double valorAssociado) {
		ValorAssociado = valorAssociado;
	}

	public void setNomeCaracteristicas(ArrayList<String> nomeCaracteristicas) {
		NomeCaracteristicas = nomeCaracteristicas;
	}

	public void setModificadorCaracteristica(ArrayList<Double> modificadorCaracteristica) {
		ModificadorCaracteristica = modificadorCaracteristica;
	}

	public void setPeculiaridades(ArrayList<Peculiaridade> peculiaridades) {
		Peculiaridades = peculiaridades;
	}
	

	@Override
	public void DeCodigoParaDados(String Codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public String DeDadosParaCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formato GerarProprioTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String toString() {
		return super.getNome();
	}

	
}
