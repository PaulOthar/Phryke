package formatos;

import java.util.ArrayList;

public class SuperPeculiaridade extends Formato {
	private String Sistema,Segmento,Detalhe;
	private double ValorAssociado;
	private ArrayList<String> NomeCaracteristicas;
	private ArrayList<Double> ModificadorCaracteristica;
	private ArrayList<Peculiaridade> Peculiaridades;
	

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

}
