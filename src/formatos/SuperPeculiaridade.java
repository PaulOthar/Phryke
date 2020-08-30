package formatos;

import java.util.ArrayList;

public class SuperPeculiaridade extends Formato {
	private String Sistema,Segmento,Detalhe;
	private double ValorAssociado;
	private ArrayList<Peculiaridade> Peculiaridades;
	private ArrayList<Modificador> modificadores;
	
 	public SuperPeculiaridade() {
		this.setSistema("");
		this.setSegmento("");
		this.setDetalhe("");
		this.setValorAssociado(0);
		this.setPeculiaridades(new ArrayList<Peculiaridade>());
		this.setModificadores(new ArrayList<Modificador>());
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

	public ArrayList<Peculiaridade> getPeculiaridades() {
		return Peculiaridades;
	}

	public ArrayList<Modificador> getModificadores() {
		return modificadores;
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

	public void setPeculiaridades(ArrayList<Peculiaridade> peculiaridades) {
		Peculiaridades = peculiaridades;
	}
	
	public void setModificadores(ArrayList<Modificador> modificadores) {
		this.modificadores = modificadores;
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
				this.setSegmento(s);
				break;
			case 2:
				this.setSistema(s);
				break;
			case 3:
				try {
					this.setValorAssociado(Double.parseDouble(s));
				}
				catch(Exception e) {
					e.printStackTrace();
					this.setValorAssociado(0);
				}
				break;
			case 4:
				this.setDetalhe(s);
				break;
			case 5:
				for (String ss : s.split(terciario)) {
					Modificador m = new Modificador();
					m.DeCodigoParaDados(ss);
					this.getModificadores().add(m);
				}
				break;
			case 6:
				this.setPeculiaridades(DebulhadorDeGalhos(s,0));
				break;
			}
			contador++;
		}
	}

	@Override
	public String DeDadosParaCodigo() {
		String codigo = "",peculiaridades = "",modificadores = "";
		
		for(Formato s : this.getModificadores()) {
			if(!modificadores.isBlank()) {
				modificadores = modificadores + secundario;
			}
			modificadores = modificadores +s.DeDadosParaCodigo();
		}
		
		peculiaridades = PeculiaridadesInfinitasCodificadas(this.getPeculiaridades(),0);
		
		codigo = this.getNome()+
				primario+this.getSegmento()+
				primario+this.getSistema()+
				primario+this.getValorAssociado()+
				primario+this.getDetalhe()+
				primario+modificadores+
				primario+peculiaridades;
		return codigo;
	}

	@Override
	public Formato GerarProprioTipo() {
		return this;
	}

	@Override
	public String toString() {
		return super.getNome();
	}
	
	public static String PeculiaridadesInfinitasCodificadas(ArrayList<Peculiaridade> peculiaridade,int numero) {
		String codigo = new String();
		for(Peculiaridade p : peculiaridade) {
			if(!codigo.isBlank()) {
				codigo = codigo + infinito+numero;
			}
			if(p.getPeculiaridades().isEmpty()) {
				//System.out.println("Trabalhando no nivel: "+numero+" Em: "+p.getNome());
				codigo = codigo +p.DeDadosParaCodigoSimplificado();
			}
			else {
				codigo = codigo + p.DeDadosParaCodigoSimplificado();
				//System.out.println("Indo Para o nivel: "+(numero+1)+" Em: "+p.getNome());
				codigo = codigo + "/"+numero+"/" + PeculiaridadesInfinitasCodificadas(p.getPeculiaridades(),numero+1);
			}
		}
		//System.out.println("Trabalho Terminado No Nivel: "+numero);
		//System.out.println(codigo);
		return codigo;
	}
	public static ArrayList<String> DivisorArboreo(String codigo,int reggex){
		ArrayList<String> lista = new ArrayList<String>();
		for(String s : codigo.split("£"+reggex)) {
			lista.add(s);
		}
		return lista;
	}
	public static ArrayList<String> DivisorHierarquico(String codigo,int reggex){
		ArrayList<String> lista = new ArrayList<String>();
		//Detalhe: O Primeiro e sempre o recebedor da porra toda
		for(String s : codigo.split("/"+reggex+"/")) {
			lista.add(s);
		}
		return lista;
	}
	public static ArrayList<Peculiaridade> DebulhadorDeGalhos(String codigo,int reggex) {
		ArrayList<Peculiaridade> peculiaridades = new ArrayList<Peculiaridade>();
		
		for(String s : DivisorArboreo(codigo,reggex)) {
			
			if(s.contains("/"+reggex+"/")) {
				Peculiaridade p = new Peculiaridade();
				ArrayList<String> ss = DivisorHierarquico(s,reggex);
				p.DeCodigoParaDadosSimples(ss.get(0));
				p.setPeculiaridades(DebulhadorDeGalhos(ss.get(1),reggex+1));
				peculiaridades.add(p);
			}
			else {
				Peculiaridade p = new Peculiaridade();
				p.DeCodigoParaDadosSimples(s);
				peculiaridades.add(p);
			}
		}
		
		return peculiaridades;
	}
	public static void PrintarHierarquia(Peculiaridade p,String hierarquia) {
		System.out.print(hierarquia+p.getNome());
		if(p.getPeculiaridades().size() > 0) {
			System.out.println("{");
			for(Peculiaridade x : p.getPeculiaridades()) {
				PrintarHierarquia(x,hierarquia+"    ");
			}
			System.out.println(hierarquia+"}");
		}
		System.out.print("\n");
	}
	public static ArrayList<Modificador> ColetarModificadores(ArrayList<Peculiaridade> p) {
		ArrayList<Modificador> m = new ArrayList<Modificador>();
		for(Peculiaridade pp : p) {
			if(pp.getPeculiaridades().size()>0) {
				for(Modificador M : ColetarModificadores(pp.getPeculiaridades())) {
					m.add(M);
				}
			}
			else {
				for(Modificador M : pp.getModificadores()) {
					m.add(M);
				}
			}
		}
		
		return m;
	}
	
}
