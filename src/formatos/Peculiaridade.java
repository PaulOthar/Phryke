package formatos;

import java.util.ArrayList;

public class Peculiaridade extends SuperPeculiaridade {
	private String SuperPeculiaridade;
	
	public Peculiaridade() {
		this.setSuperPeculiaridade("");
		this.setSistema("");
		this.setSegmento("");
		this.setDetalhe("");
		this.setValorAssociado(0);
		this.setNomeCaracteristicas(new ArrayList<String>());
		this.setModificadorCaracteristica(new ArrayList<Double>());
		this.setPeculiaridades(new ArrayList<Peculiaridade>());
	}

	public String getSuperPeculiaridade() {
		return SuperPeculiaridade;
	}

	public void setSuperPeculiaridade(String superPeculiaridade) {
		SuperPeculiaridade = superPeculiaridade;
	}
	
}
