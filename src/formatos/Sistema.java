package formatos;

import java.util.ArrayList;

public class Sistema extends Formato {
	private String versao;
	
	//Alguns sistemas Variam com campos do sistema, como D&D,que tem dextreza, no 3d&t tem habilidade....
	//Caracteristicas: Forca, habilidade...
	//Segmentos: Vantagens..desvantagens...magias...pericias.......
	private ArrayList<String> caracteristicas,segmentos,regras;
	
	public Sistema() {
		super.setNome(new String());
		this.setVersao(new String());
		this.setCaracteristicas(new ArrayList<String>());
		this.setSegmentos(new ArrayList<String>());
		this.setRegras(new ArrayList<String>());
	}
	
	public ArrayList<Caracteristica> PegarCaracteristicas(ArrayList<Caracteristica> ca) {
		ArrayList<Caracteristica> cagerada = new ArrayList<Caracteristica>();
		for(Caracteristica c : ca) {
			for(String s : this.getCaracteristicas()) {
				if(c.getNome() == s) {
					cagerada.add(c);
				}
			}
		}
		return cagerada;
	}
	
	public void AdicionarCaracteristicaPorCaracteristica(Caracteristica c) {
		this.getCaracteristicas().add(c.getNome());
	}
	public void AdicionarRegraPorRegra(Regra r) {
		regras.add(r.getNome());
	}
	
	public String getVersao() {
		return versao;
	}
	public ArrayList<String> getSegmentos() {
		return segmentos;
	}
	public ArrayList<String> getCaracteristicas() {
		return caracteristicas;
	}
	public ArrayList<String> getRegras() {
		return regras;
	}
	
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public void setSegmentos(ArrayList<String> segmentos) {
		this.segmentos = segmentos;
	}

	public void setCaracteristicas(ArrayList<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public void setRegras(ArrayList<String> regras) {
		this.regras = regras;
	}
	

	@Override
	public String DeDadosParaCodigo() {
		String codigo = new String(),caracteristicas = new String(),segmentos = new String(),regras = new String();
		
		for(String s : this.getCaracteristicas()) {
			if(!caracteristicas.isBlank()) {
				caracteristicas = caracteristicas + secundario;
			}
			caracteristicas  = caracteristicas + s;
		}
		
		for(String s : this.getSegmentos()) {
			if(!segmentos.isBlank()) {
				segmentos = segmentos + secundario;
			}
			segmentos = segmentos + s;
		}
		
		for(String s : this.getRegras()) {
			if(!regras.isBlank()) {
				regras = regras + secundario;
			}
			regras = regras + s;
		}
		
		codigo = this.getVersao()+primario+super.getNome()+primario+caracteristicas+primario+segmentos+primario+regras;
		return codigo;
	}
	@Override
	public void DeCodigoParaDados(String Codigo) {
		int contador = 0;
		for(String s : Codigo.split(primario)) {
			switch(contador) {
			case 0:
				this.setVersao(s);
				break;
			case 1:
				this.setNome(s);
				break;
			case 2:
				for(String ss : s.split(secundario)) {
					this.getCaracteristicas().add(ss);
				}
				break;
			case 3:
				for(String ss : s.split(secundario)) {
					this.getSegmentos().add(ss);
				}
				break;
			case 4:
				for(String ss : s.split(secundario)) {
					this.getRegras().add(ss);
				}
				break;
			}
			contador++;
		}
	}

	@Override
	public Formato GerarProprioTipo() {
		// TODO Auto-generated method stub
		return new Sistema();
	}
}
