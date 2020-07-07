package formatos;

import java.util.ArrayList;

public class Raca extends Formato {
	//Super raca se refere ao subtipo de raca, tipo, um zumbi e um esqueleto pertencem ao subtipo undead  
	private String descricao,superraca,sistema;
	//Algums racas podem variar em custo dentro dos mesmos parametros,oq significa q a pessoa deve optar pelo custo personalizado
	private ArrayList<Double> custo;
	//Racas Podem Dar Bonus em certas caracteristicas, e como nao sabemos quais caracteristicas estamos brincando, eu usei ArrayList
	private ArrayList<Double> caracteristicasbonus;
	/*
	Peculiaridades seriam como perks, a habilidade de voar, por exemplo, ou ter um braco mecanico...
	Cada sistema pode variar com peculiaridades, pretendo englobar ate magia
	Observa-se uma matriz... o primeiro item de uma coluna, sempre sera referencia ao tipo de peculiaridade
	Vamos trabalhar apenas com referencia, nao vamos inserir o dado em si, pra nao ocupar muita memoria
	
	Tipo:
	# / # / #
	# / # / #
	# / # / #
	Matriz 3x3
	
	Vantagens / Voar / Membros elasticos
	Desvantagens / Cego / Surdo
	Aptidoes / Magia Branca / Clonagem
	 */
	private ArrayList<ArrayList<String>> peculiaridades;
	
	public Raca() {
		this.setDescricao(new String());
		this.setSuperraca(new String());
		this.setSistema(new String());
		this.setCaracteristicasbonus(new ArrayList<Double>());
	}
	public Raca(String nome) {
		this.setDescricao(new String());
		this.setSuperraca(new String());
		this.setSistema(new String());
		this.setCaracteristicasbonus(new ArrayList<Double>());
		super.setNome(nome);
	}
	public Raca(String nome,String descricao,String superraca,String sistema) {
		super.setNome(nome);
		this.setDescricao(descricao);
		this.setSuperraca(superraca);
		this.setSistema(sistema);
		this.setCaracteristicasbonus(new ArrayList<Double>());
	}
	
	public void CriarSegmentoDePeculiaridade(String nomesegmento) {
		//Aqui Criamos um segmento vazio
		this.getPeculiaridades().add(new ArrayList<String>());
		//Depois procuramos pelo segmento vazio,percorrendo todos os segmentos
		for(int i = 0;i<this.getPeculiaridades().size();i++) {
			if(this.getPeculiaridades().get(i).isEmpty()) {
				//quando achar-mos o segmento vazio, inserimos o nome do segmento e encerramos o metodo
				this.getPeculiaridades().get(i).add(nomesegmento);
				return;
			}
		}
	}
	public void InserirPeculiaridadeNoSegmeno(String nomesegmento,String nomepeculiaridade) {
		//Percorremos as colunas de peculiaridades(Aonde ficam os nomes dos segmentos)
		for(int i = 0;i<this.getPeculiaridades().size();i++) {
			//Se houver um segmento com o nome informado:
			if(this.getPeculiaridades().get(i).get(0).contentEquals(nomesegmento)) {
				//Adicionamos o valor ao segmento, e encerramos o metodo
				this.getPeculiaridades().get(i).add(nomepeculiaridade);
				return;
			}
		}
	}
	public void RemoverPeculiaridadeNoSegmento(String nomesegmento,String nomepeculiaridade) {
		//Percorremos as colunas de peculiaridades(Aonde ficam os nomes dos segmentos)
				for(int i = 0;i<this.getPeculiaridades().size();i++) {
					//Se houver um segmento com o nome informado:
					if(this.getPeculiaridades().get(i).get(0).contentEquals(nomesegmento)) {
						//Se Houver uma peculiaridade com o nome informado:
						for(int ii = 0;ii<this.getPeculiaridades().get(i).size();i++) {
							//Se Houver uma peculiaridade com o nome informado:
							if(this.getPeculiaridades().get(i).get(ii).contentEquals(nomepeculiaridade)) {
								//Removemos o item, baseado no indice,Reajustamos as posicoes e encerramos o metodo
								ArrayList<String> reajuste = new ArrayList<String>();
								this.getPeculiaridades().get(i).remove(ii);
								for(String s: this.getPeculiaridades().get(i)) {
									if(!s.isBlank() || !s.contentEquals("null") || !s.contentEquals(null)) {
										reajuste.add(s);
									}
								}
								this.getPeculiaridades().get(i).clear();
								for(String s : reajuste) {
									this.getPeculiaridades().get(i).add(s);
								}
								return;
							}
						}
					}
				}
	}
	
	public void InserirCusto(double custo) {
		this.getCusto().add(custo);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public String getSuperraca() {
		return superraca;
	}
	public String getSistema() {
		return sistema;
	}
	public ArrayList<Double> getCusto() {
		return custo;
	}
	public ArrayList<Double> getCaracteristicasbonus() {
		return caracteristicasbonus;
	}
	public ArrayList<ArrayList<String>> getPeculiaridades() {
		return peculiaridades;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setSuperraca(String superraca) {
		this.superraca = superraca;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public void setCusto(ArrayList<Double> custo) {
		this.custo = custo;
	}
	public void setCaracteristicasbonus(ArrayList<Double> caracteristicasbonus) {
		this.caracteristicasbonus = caracteristicasbonus;
	}
	public void setPeculiaridades(ArrayList<ArrayList<String>> peculiaridades) {
		this.peculiaridades = peculiaridades;
	}
}
