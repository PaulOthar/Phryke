package formatos;

import java.util.ArrayList;

public class SuperRaca extends Formato {
	private ArrayList<CaracteristicaMod> caracteristicasbonus;

	private ArrayList<ArrayList<String>> peculiaridades;
	private String sistema, descricao;

	public SuperRaca() {

	}

	public SuperRaca(String nome, String descricao) {
		super.setNome(nome);
		this.setDescricao(descricao);
	}

	public void ConfigurarViaSistema(ArrayList<Sistema> sys, ArrayList<Caracteristica> ca) {
		for (Sistema s : sys) {
			if (s.getNome() == this.getSistema()) {
				for (Caracteristica c : s.PegarCaracteristicas(ca)) {
					this.CriarCaracteristicaBonus(c.getNome());
					this.InserirValorNaCaracteristica(c.getNome(), c.getValor());
				}
				for (String ss : s.getSegmentos()) {
					this.CriarSegmentoDePeculiaridade(ss);
				}
			}
		}
	}

	public void CriarCaracteristicaBonus(String nomedacaracteristica) {
		this.getCaracteristicasbonus().add(new CaracteristicaMod(nomedacaracteristica));
	}

	public void CriarSegmentoDePeculiaridade(String nomesegmento) {
		// Aqui Criamos um segmento vazio
		this.getPeculiaridades().add(new ArrayList<String>());
		// Depois procuramos pelo segmento vazio,percorrendo todos os segmentos
		for (int i = 0; i < this.getPeculiaridades().size(); i++) {
			if (this.getPeculiaridades().get(i).isEmpty()) {
				// quando achar-mos o segmento vazio, inserimos o nome do segmento e encerramos
				// o metodo
				this.getPeculiaridades().get(i).add(nomesegmento);
				return;
			}
		}
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
				this.setSistema(s);
				break;
			case 2:
				this.setDescricao(s);
				break;
			case 3:
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
			case 4:
				for (String ss : s.split(secundario)) {
					String segmento = "";
					for (String sss : ss.split(terciario)) {
						if (segmento.isBlank()) {
							this.CriarSegmentoDePeculiaridade(sss);
							segmento = sss;
						} else {
							this.InserirPeculiaridadeNoSegmeno(segmento, sss);
						}
					}
				}
				break;
			}
			contador++;
		}

	}

	@Override
	public String DeDadosParaCodigo() {
		String codigo = "", Caracteristica = "", peculiaridades = "";

		for (ArrayList<String> arls : this.getPeculiaridades()) {
			if (!peculiaridades.isBlank()) {
				peculiaridades = peculiaridades + secundario;
			}
			String schindler = "";
			for (String s : arls) {
				if (!schindler.isBlank()) {
					schindler = schindler + terciario;
				}
				schindler = schindler + s;
			}
			peculiaridades = peculiaridades + schindler;
		}

		for (CaracteristicaMod c : this.getCaracteristicasbonus()) {
			if (!Caracteristica.isBlank()) {
				Caracteristica = Caracteristica + secundario;
			}
			Caracteristica = Caracteristica + c.getNome() + terciario + c.getModificador();
		}

		codigo = super.getNome() + primario + this.getSistema() + primario + this.getDescricao() + primario
				+ Caracteristica + primario + peculiaridades;
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

	public void EditarNomeDoSegmento(String nomesegmentoinicial, String nomesegmentoatual) {
		for (int i = 0; i < this.getPeculiaridades().size(); i++) {
			if (this.getPeculiaridades().get(i).get(0).contentEquals(nomesegmentoinicial)) {
				this.getPeculiaridades().get(i).set(0, nomesegmentoatual);
				return;
			}
		}
	}

	public void EditarPeculiaridadeNoSegmento(String nomesegmento, String nomepeculiaridadeinicial,
			String nomepeculiaridadeatual) {
		for (int i = 0; i < this.getPeculiaridades().size(); i++) {
			if (this.getPeculiaridades().get(i).get(0).equals(nomesegmento)) {
				for (int ii = 0; ii < this.getPeculiaridades().get(i).size(); i++) {
					if (this.getPeculiaridades().get(i).get(ii).contentEquals(nomepeculiaridadeinicial)) {
						this.getPeculiaridades().get(i).set(ii, nomepeculiaridadeatual);
						return;
					}
				}
			}
		}
	}

	@Override
	public Formato GerarProprioTipo() {
		// TODO Auto-generated method stub
		return new SuperRaca();
	}

	public ArrayList<CaracteristicaMod> getCaracteristicasbonus() {
		return caracteristicasbonus;
	}

	public String getDescricao() {
		return descricao;
	}

	public ArrayList<ArrayList<String>> getPeculiaridades() {
		return peculiaridades;
	}

	public String getSistema() {
		return sistema;
	}

	public void InserirPeculiaridadeNoSegmeno(String nomesegmento, String nomepeculiaridade) {
		// Percorremos as colunas de peculiaridades(Aonde ficam os nomes dos segmentos)
		for (int i = 0; i < this.getPeculiaridades().size(); i++) {
			// Se houver um segmento com o nome informado:
			if (this.getPeculiaridades().get(i).get(0).contentEquals(nomesegmento)) {
				// Adicionamos o valor ao segmento, e encerramos o metodo
				this.getPeculiaridades().get(i).add(nomepeculiaridade);
				return;
			}
		}
	}

	public void InserirValorNaCaracteristica(String nomedacaracteristica, Double valor) {
		for (int i = 0; i < this.getCaracteristicasbonus().size(); i++) {
			if (this.getCaracteristicasbonus().get(i).getNome().contentEquals(nomedacaracteristica)) {
				this.getCaracteristicasbonus().get(i).setModificador(valor);
			}
		}
	}

	public void ReceberModificadores(ArrayList<CaracteristicaMod> mod) {
		for (CaracteristicaMod m : mod) {
			for (CaracteristicaMod mm : this.getCaracteristicasbonus()) {
				if (m.getNome() == mm.getNome()) {
					SomarModificadorCaracteristica(mm.getNome(), m.getModificador());
				}
			}
		}
	}

	public void ReceberPeculiaridades(Peculiaridade p) {
		for (ArrayList<String> arls : this.getPeculiaridades()) {
			if (arls.get(0).contentEquals(p.getNome())) {
				this.InserirPeculiaridadeNoSegmeno(arls.get(0), p.getNome());
				this.ReceberModificadores(p.getCaracteristicasbonus());
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

	/*
	 * @Deprecated public void RemoverPeculiaridadeNoSegmento(String
	 * nomesegmento,String nomepeculiaridade) { //Percorremos as colunas de
	 * peculiaridades(Aonde ficam os nomes dos segmentos) for(int i =
	 * 0;i<this.getPeculiaridades().size();i++) { //Se houver um segmento com o nome
	 * informado:
	 * if(this.getPeculiaridades().get(i).get(0).contentEquals(nomesegmento)) { //Se
	 * Houver uma peculiaridade com o nome informado: for(int ii =
	 * 0;ii<this.getPeculiaridades().get(i).size();i++) { //Se Houver uma
	 * peculiaridade com o nome informado:
	 * if(this.getPeculiaridades().get(i).get(ii).contentEquals(nomepeculiaridade))
	 * { //Removemos o item, baseado no indice,Reajustamos as posicoes e encerramos
	 * o metodo ArrayList<String> reajuste = new ArrayList<String>();
	 * this.getPeculiaridades().get(i).remove(ii); for(String s:
	 * this.getPeculiaridades().get(i)) { if(!s.isBlank() ||
	 * !s.contentEquals("null") || !s.contentEquals(null)) { reajuste.add(s); } }
	 * this.getPeculiaridades().get(i).clear(); for(String s : reajuste) {
	 * this.getPeculiaridades().get(i).add(s); } return; } } } } }
	 */
	public void RemoverPeculiaridadeNoSegmento(String nomesegmento, String nomepeculiaridade) {
		for (int i = 0; i < this.getPeculiaridades().size(); i++) {
			if (this.getPeculiaridades().get(i).get(0).equals(nomesegmento)) {
				this.getPeculiaridades().get(i).remove(nomepeculiaridade);
			}
		}
	}

	public void RemoverSegmento(String nomesegmento) {
		for (int i = 0; i < this.getPeculiaridades().size(); i++) {
			if (this.getPeculiaridades().get(i).get(0).contentEquals(nomesegmento)) {
				this.getPeculiaridades().remove(i);
				return;
			}
		}
	}

	public void setCaracteristicasbonus(ArrayList<CaracteristicaMod> caracteristicasbonus) {
		this.caracteristicasbonus = caracteristicasbonus;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPeculiaridades(ArrayList<ArrayList<String>> peculiaridades) {
		this.peculiaridades = peculiaridades;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public void SomarModificadorCaracteristica(String nomedacaracteristica, Double valor) {
		for (int i = 0; i < this.getCaracteristicasbonus().size(); i++) {
			if (this.getCaracteristicasbonus().get(i).getNome().contentEquals(nomedacaracteristica)) {
				this.getCaracteristicasbonus().get(i)
						.setModificador(this.getCaracteristicasbonus().get(i).getModificador() + valor);
			}
		}
	}

}
