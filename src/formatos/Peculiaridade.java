package formatos;

import java.util.ArrayList;

public class Peculiaridade extends Formato {
	private String descricao,sistema,segmento;
	private ArrayList<Double> custo;
	
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
	
	public void InserirCusto(double custo) {
		this.getCusto().add(custo);
	}
	public void EditarCusto(double custoinicial,double custoatual) {
		for(int i = 0;i<this.getCusto().size();i++) {
			if(this.getCusto().get(i).equals(custoinicial)) {
				this.getCusto().set(i, custoatual);
				return;
			}
		}
	}
	public void RemoverCusto(double custo) {
		this.getCusto().remove(custo);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public String getSistema() {
		return sistema;
	}
	public String getSegmento() {
		return segmento;
	}
	public ArrayList<Double> getCusto() {
		return custo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public void setCusto(ArrayList<Double> custo) {
		this.custo = custo;
	}
	
	@Override
	public String DeDadosParaCodigo() {
		String codigo = "",custo = "";
		
		for(Double d : this.getCusto()) {
			if(!custo.isBlank()) {
				custo = custo + secundario;
			}
			custo = custo + d;
		}
		
		codigo = super.getNome()+primario+this.getDescricao()+primario+this.getSistema()+primario+this.getSegmento()+primario+custo;
		return codigo;
	
	}
	@Override
	public void DeCodigoParaDados(String Codigo) {
		int contador = 0;
		for(String s : Codigo.split(primario)) {
			switch(contador) {
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
				for(String ss : s.split(secundario)) {
					this.InserirCusto(Double.parseDouble(ss));
				}
				break;
			}
			contador++;
		}
	}
	
	
}
