package formatos;

import java.util.ArrayList;

public class Peculiaridade extends SuperPeculiaridade {
	private String SuperPeculiaridade,Separador;
	
	public Peculiaridade() {
		this.setNome("");
		this.setSuperPeculiaridade("");
		this.setSistema("");
		this.setSegmento("");
		this.setDetalhe("");
		this.setValorAssociado(0);
		this.setModificadores(new ArrayList<Modificador>());
		this.setPeculiaridades(new ArrayList<Peculiaridade>());
	}

	public Peculiaridade(String nome) {
		this();
		this.setNome(nome);
		this.setSuperPeculiaridade("Vazio");
		this.setSistema("Vazio");
		this.setSegmento("Vazio");
		this.setDetalhe("Vazio");
		this.getModificadores().add(new Modificador("Vazio",0));
	}
	
	@Override
	public String DeDadosParaCodigo() {
		String codigo = "",peculiaridades = "",modificadores = "";
		
		for(Formato s : this.getModificadores()) {
			if(!modificadores.isBlank()) {
				modificadores = modificadores + terciario;
			}
			modificadores = modificadores +s.DeDadosParaCodigo();
		}
		
		peculiaridades = PeculiaridadesInfinitasCodificadas(this.getPeculiaridades(), 0);
		
		codigo = this.getNome()+
				secundario+this.getSuperPeculiaridade()+
				secundario+this.getSegmento()+
				secundario+this.getSistema()+
				secundario+this.getValorAssociado()+
				secundario+this.getDetalhe()+
				secundario+modificadores+
				quaternario+peculiaridades;
		return codigo;
	}
	public String DeDadosParaCodigoSimplificado() {
		String codigo = "",modificadores = "";
		
		for(Formato s : this.getModificadores()) {
			if(!modificadores.isBlank()) {
				modificadores = modificadores + terciario;
			}
			modificadores = modificadores +s.DeDadosParaCodigo();
		}
		
		codigo = this.getNome()+
				secundario+this.getSuperPeculiaridade()+
				secundario+this.getSegmento()+
				secundario+this.getSistema()+
				secundario+this.getValorAssociado()+
				secundario+this.getDetalhe()+
				secundario+modificadores;
		return codigo;
	}
	
	@Override
	public void DeCodigoParaDados(String Codigo) {
		int contador = 0;
		
		ArrayList<String> str = new ArrayList<String>();
		
		for(String s : Codigo.split(quaternario)) {
			str.add(s);
		}
		
		this.setPeculiaridades(DebulhadorDeGalhos(str.get(1),0));
		
		for (String s : str.get(0).split(secundario)) {
			switch (contador) {
			case 0:
				this.setNome(s);
				break;
			case 1:
				this.setSuperPeculiaridade(s);
				break;
			case 2:
				this.setSegmento(s);
				break;
			case 3:
				this.setSistema(s);
				break;
			case 4:
				try {
					this.setValorAssociado(Double.parseDouble(s));
				}
				catch(Exception e) {
					e.printStackTrace();
					this.setValorAssociado(0);
				}
				break;
			case 5:
				this.setDetalhe(s);
				break;
			case 6:
				for (String ss : s.split(terciario)) {
					Modificador m = new Modificador();
					m.DeCodigoParaDados(ss);
					this.getModificadores().add(m);
				}
				break;
			}
			contador++;
		}
	}
	public void DeCodigoParaDadosSimples(String Codigo) {
		int contador = 0;
		for (String s : Codigo.split(secundario)) {
			switch (contador) {
			case 0:
				this.setNome(s);
				break;
			case 1:
				this.setSuperPeculiaridade(s);
				break;
			case 2:
				this.setSegmento(s);
				break;
			case 3:
				this.setSistema(s);
				break;
			case 4:
				try {
					this.setValorAssociado(Double.parseDouble(s));
				}
				catch(Exception e) {
					e.printStackTrace();
					this.setValorAssociado(0);
				}
				break;
			case 5:
				this.setDetalhe(s);
				break;
			case 6:
				for (String ss : s.split(terciario)) {
					Modificador m = new Modificador();
					m.DeCodigoParaDados(ss);
					this.getModificadores().add(m);
				}
				break;
			}
			contador++;
		}
	}
	
	public String getSuperPeculiaridade() {
		return SuperPeculiaridade;
	}

	public String getSeparador() {
		return Separador;
	}

	public void setSeparador(String separador) {
		Separador = separador;
	}

	public void setSuperPeculiaridade(String superPeculiaridade) {
		SuperPeculiaridade = superPeculiaridade;
	}
	
}
