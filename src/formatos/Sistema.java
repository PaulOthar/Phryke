package formatos;

import java.util.ArrayList;

public class Sistema extends Formato {
	// Alguns sistemas Variam com campos do sistema, como D&D,que tem dextreza, no
	// 3d&t tem habilidade....
	// Caracteristicas: Forca, habilidade...
	// Segmentos: Vantagens..desvantagens...magias...pericias.......
	private ArrayList<Segmento>  segmentos;
	private ArrayList<Caracteristica> caracteristicas;
	private ArrayList<Regra> regras;
	private String descricao;

	private String versao;

	public Sistema() {
		super.setNome(new String());
		this.setVersao(new String());
		this.setCaracteristicas(new ArrayList<Caracteristica>());
		this.setSegmentos(new ArrayList<Segmento>());
		this.setRegras(new ArrayList<Regra>());
	}

	@Override
	public void DeCodigoParaDados(String Codigo) {
		int contador = 0;
		for (String s : Codigo.split(terciario)) {
			switch (contador) {
			case 0:
				this.setVersao(s);
				break;
			case 1:
				this.setNome(s);
				break;
			case 2:
				this.setDescricao(s);
				break;
			case 3:
				for (String ss : s.split(secundario)) {
					this.getCaracteristicas().add(new Caracteristica(ss,true));
				}
				break;
			case 4:
				for (String ss : s.split(secundario)) {
					this.getSegmentos().add(new Segmento(ss,true));
				}
				break;
			case 5:
				for (String ss : s.split(secundario)) {
					this.getRegras().add(new Regra(ss,true));
				}
				break;
			}
			contador++;
		}
	}

	@Override
	public String DeDadosParaCodigo() {
		String codigo = new String(), caracteristicas = new String(), segmentos = new String(), regras = new String();

		for (Formato s : this.getCaracteristicas()) {
			if (!caracteristicas.isBlank()) {
				caracteristicas = caracteristicas + secundario;
			}
			caracteristicas = caracteristicas + s.DeDadosParaCodigo();
		}

		for (Formato s : this.getSegmentos()) {
			if (!segmentos.isBlank()) {
				segmentos = segmentos + secundario;
			}
			segmentos = segmentos + s.DeDadosParaCodigo();
		}

		for (Formato s : this.getRegras()) {
			if (!regras.isBlank()) {
				regras = regras + secundario;
			}
			regras = regras + s.DeDadosParaCodigo();
		}

		codigo = this.getVersao() + terciario + super.getNome() + terciario + this.getDescricao() + terciario + caracteristicas + terciario + segmentos
				+ terciario + regras;
		return codigo;
	}

	@Override
	public Formato GerarProprioTipo() {
		// TODO Auto-generated method stub
		return new Sistema();
	}

	public ArrayList<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public ArrayList<Regra> getRegras() {
		return regras;
	}

	public ArrayList<Segmento> getSegmentos() {
		return segmentos;
	}

	public String getVersao() {
		return versao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public void setRegras(ArrayList<Regra> regras) {
		this.regras = regras;
	}

	public void setSegmentos(ArrayList<Segmento> segmentos) {
		this.segmentos = segmentos;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return super.getNome();
	}
	
	
}
