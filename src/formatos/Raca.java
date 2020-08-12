package formatos;

import java.util.ArrayList;

public class Raca extends Formato {
	// Racas Podem Dar Bonus em certas caracteristicas, e como nao sabemos quais
	// caracteristicas estamos brincando, eu usei ArrayList
	private ArrayList<CaracteristicaMod> caracteristicasbonus;
	// Algums racas podem variar em custo dentro dos mesmos parametros,oq significa
	// q a pessoa deve optar pelo custo personalizado
	private ArrayList<Double> custo;
	// Super raca se refere ao subtipo de raca, tipo, um zumbi e um esqueleto
	// pertencem ao subtipo undead
	private String descricao, superraca, sistema;
	/*
	 * Peculiaridades seriam como perks, a habilidade de voar, por exemplo, ou ter
	 * um braco mecanico... Cada sistema pode variar com peculiaridades, pretendo
	 * englobar ate magia Observa-se uma matriz... o primeiro item de uma coluna,
	 * sempre sera referencia ao tipo de peculiaridade Vamos trabalhar apenas com
	 * referencia, nao vamos inserir o dado em si, pra nao ocupar muita memoria
	 * 
	 * Tipo: # / # / # # / # / # # / # / # Matriz 3x3
	 * 
	 * Vantagens / Voar / Membros elasticos Desvantagens / Cego / Surdo Aptidoes /
	 * Magia Branca / Clonagem
	 */
	private ArrayList<ArrayList<String>> peculiaridades;

	public Raca() {
		this.setCusto(new ArrayList<Double>());
		this.setPeculiaridades(new ArrayList<ArrayList<String>>());
		this.setDescricao(new String());
		this.setSuperraca(new String());
		this.setSistema(new String());
		this.setCaracteristicasbonus(new ArrayList<CaracteristicaMod>());
	}

	public Raca(String nome) {
		this.setCusto(new ArrayList<Double>());
		this.setPeculiaridades(new ArrayList<ArrayList<String>>());
		this.setDescricao(new String());
		this.setSuperraca(new String());
		this.setSistema(new String());
		this.setCaracteristicasbonus(new ArrayList<CaracteristicaMod>());
		super.setNome(nome);
	}

	public Raca(String nome, String descricao, String superraca, String sistema) {
		this.setCusto(new ArrayList<Double>());
		this.setPeculiaridades(new ArrayList<ArrayList<String>>());
		super.setNome(nome);
		this.setDescricao(descricao);
		this.setSuperraca(superraca);
		this.setSistema(sistema);
		this.setCaracteristicasbonus(new ArrayList<CaracteristicaMod>());
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
				this.setDescricao(s);
				break;
			case 2:
				this.setSuperraca(s);
				break;
			case 3:
				this.setSistema(s);
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
			case 6:
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
		String Codigo = "", Custo = "", Caracteristica = "", peculiaridades = "";

		for (Double c : this.getCusto()) {
			if (!Custo.isBlank()) {
				Custo = Custo + secundario;
			}
			Custo = Custo + c;
		}

		for (CaracteristicaMod c : this.getCaracteristicasbonus()) {
			if (!Caracteristica.isBlank()) {
				Caracteristica = Caracteristica + secundario;
			}
			Caracteristica = Caracteristica + c.getNome() + terciario + c.getModificador();
		}

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

		Codigo = super.getNome() + primario + this.getDescricao() + primario + this.getSuperraca() + primario
				+ this.getSistema() + primario + Custo + primario + Caracteristica + primario + peculiaridades;
		return Codigo;
	}

	public void EditarCaracteristica(String nomedacaracteristicainicial, String nomedacaracteristicaatual) {
		for (int i = 0; i < this.getCaracteristicasbonus().size(); i++) {
			if (this.getCaracteristicasbonus().get(i).getNome().contentEquals(nomedacaracteristicainicial)) {
				this.getCaracteristicasbonus().get(i).setNome(nomedacaracteristicaatual);
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
		return new Raca();
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

	public ArrayList<ArrayList<String>> getPeculiaridades() {
		return peculiaridades;
	}

	public String getSistema() {
		return sistema;
	}

	public String getSuperraca() {
		return superraca;
	}

	public void InserirCusto(double custo) {
		this.getCusto().add(custo);
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

	public void ReceberSuperRaca(SuperRaca r) {
		this.setSuperraca(r.getNome());
		this.SomarPeculiaridades(r.getPeculiaridades());
		this.ReceberModificadores(r.getCaracteristicasbonus());
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

	public void setCusto(ArrayList<Double> custo) {
		this.custo = custo;
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

	public void setSuperraca(String superraca) {
		this.superraca = superraca;
	}

	public void SomarModificadorCaracteristica(String nomedacaracteristica, Double valor) {
		for (int i = 0; i < this.getCaracteristicasbonus().size(); i++) {
			if (this.getCaracteristicasbonus().get(i).getNome().contentEquals(nomedacaracteristica)) {
				this.getCaracteristicasbonus().get(i)
						.setModificador(this.getCaracteristicasbonus().get(i).getModificador() + valor);
			}
		}
	}

	public void SomarPeculiaridades(ArrayList<ArrayList<String>> peculiaridades) {
		for (ArrayList<String> segmento : peculiaridades) {
			for (ArrayList<String> segmentointerno : this.getPeculiaridades()) {
				if (segmento.get(0) == segmentointerno.get(0)) {
					for (int i = 1; i < segmento.size(); i++) {
						this.InserirPeculiaridadeNoSegmeno(segmento.get(0), segmento.get(i));
					}
				}
			}
		}
	}

}
