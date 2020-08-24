package formatosVelhos;
/*
import java.util.ArrayList;

import formatos.Caracteristica;
import formatos.Formato;
import formatos.Sistema;

public class Peculiaridade extends Formato {
	private ArrayList<CaracteristicaMod> caracteristicasbonus;
	private ArrayList<Double> custo;
	private String descricao, sistema, segmento;

	public Peculiaridade() {
		super.setNome(new String());
		this.setCusto(new ArrayList<Double>());
		this.setSistema(new String());
		this.setSegmento(new String());
		this.setDescricao(new String());
	}

	public Peculiaridade(String nome) {
		super.setNome(nome);
		this.setCusto(new ArrayList<Double>());
		this.setSistema(new String());
		this.setSegmento(new String());
		this.setDescricao(new String());
	}

	public void ConfigurarViaSistema(ArrayList<Sistema> sys, ArrayList<Caracteristica> ca) {
		for (Sistema s : sys) {
			if (s.getNome() == this.getSistema()) {
				for (Caracteristica c : s.PegarCaracteristicas(ca)) {
					this.CriarCaracteristicaBonus(c.getNome());
					this.InserirValorNaCaracteristica(c.getNome(), c.getValor());
				}
			}
		}
	}

	public void CriarCaracteristicaBonus(String nomedacaracteristica) {
		this.getCaracteristicasbonus().add(new CaracteristicaMod(nomedacaracteristica));
	}

	@Override
	public void DeCodigoParaDados(String Codigo) {
		int contador = 0;
		for (String s : Codigo.split(primario)) {
			switch (contador) {
			case 0:
				super.setNome(s);
				break;
			case 1:
				this.setDescricao(s);
				break;
			case 2:
				this.setSistema(s);
				break;
			case 3:
				this.setSegmento(s);
				break;
			case 4:
				for (String ss : s.split(secundario)) {
					this.InserirCusto(Double.parseDouble(ss));
				}
				break;
			case 5:
				for (String ss : s.split(secundario)) {

					CaracteristicaMod c = new CaracteristicaMod();
					int contadeiro = 0;

					for (String sss : ss.split(terciario)) {
						switch (contadeiro) {
						case 0:
							c.setNome(sss);
							break;
						case 1:
							c.setModificador(Double.parseDouble(sss));
							break;
						}
						contadeiro++;
					}

					this.getCaracteristicasbonus().add(c);
				}
				break;
			}
			contador++;
		}
	}

	@Override
	public String DeDadosParaCodigo() {
		String codigo = "", custo = "", Caracteristica = "";

		for (Double d : this.getCusto()) {
			if (!custo.isBlank()) {
				custo = custo + secundario;
			}
			custo = custo + d;
		}

		for (CaracteristicaMod c : this.getCaracteristicasbonus()) {
			if (!Caracteristica.isBlank()) {
				Caracteristica = Caracteristica + secundario;
			}
			Caracteristica = Caracteristica + c.getNome() + terciario + c.getModificador();
		}

		codigo = super.getNome() + primario + this.getDescricao() + primario + this.getSistema() + primario
				+ this.getSegmento() + primario + custo + primario + Caracteristica;
		return codigo;

	}

	public void EditarCaracteristica(String nomedacaracteristicainicial, String nomedacaracteristicaatual) {
		for (int i = 0; i < this.getCaracteristicasbonus().size(); i++) {
			if (this.getCaracteristicasbonus().get(i).getNome().contentEquals(nomedacaracteristicainicial)) {
				this.getCaracteristicasbonus().get(i).setNome(nomedacaracteristicaatual);
				;
			}
		}
	}

	public void EditarCusto(double custoinicial, double custoatual) {
		for (int i = 0; i < this.getCusto().size(); i++) {
			if (this.getCusto().get(i).equals(custoinicial)) {
				this.getCusto().set(i, custoatual);
				return;
			}
		}
	}

	@Override
	public Formato GerarProprioTipo() {
		// TODO Auto-generated method stub
		return new Peculiaridade();
	}

	public ArrayList<CaracteristicaMod> getCaracteristicasbonus() {
		return caracteristicasbonus;
	}

	public ArrayList<Double> getCusto() {
		return custo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSegmento() {
		return segmento;
	}

	public String getSistema() {
		return sistema;
	}

	public void InserirCusto(double custo) {
		this.getCusto().add(custo);
	}

	public void InserirValorNaCaracteristica(String nomedacaracteristica, Double valor) {
		for (int i = 0; i < this.getCaracteristicasbonus().size(); i++) {
			if (this.getCaracteristicasbonus().get(i).getNome().contentEquals(nomedacaracteristica)) {
				this.getCaracteristicasbonus().get(i).setModificador(valor);
			}
		}
	}

	public void RemoverCaracteristica(String nomedacaracteristica) {
		for (int i = 0; i < this.getCaracteristicasbonus().size(); i++) {
			if (this.getCaracteristicasbonus().get(i).getNome().contentEquals(nomedacaracteristica)) {
				this.getCaracteristicasbonus().remove(i);
			}
		}
	}

	public void RemoverCusto(double custo) {
		this.getCusto().remove(custo);
	}

	public void setCaracteristicasbonus(ArrayList<CaracteristicaMod> caracteristicasbonus) {
		this.caracteristicasbonus = caracteristicasbonus;
	}

	public void setCusto(ArrayList<Double> custo) {
		this.custo = custo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
}
*/