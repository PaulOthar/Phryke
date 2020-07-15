package formatos;

import java.util.ArrayList;

public class Peculiaridade extends Formato {
	private String descricao,sistema;
	private ArrayList<Double> custo;
	
	public Peculiaridade() {
		custo = new ArrayList<Double>();
		sistema = new String();
		descricao = new String();
	}
	public Peculiaridade(String nome) {
		super.setNome(nome);
		custo = new ArrayList<Double>();
		sistema = new String();
		descricao = new String();
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
	public ArrayList<Double> getCusto() {
		return custo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public void setCusto(ArrayList<Double> custo) {
		this.custo = custo;
	}
	
	@Override
	public String DeDadosParaCodigo() {
		String codigo = "";
		
		return null;
	
	}
	@Override
	public void DeCodigoParaDados(String Codigo) {
		// TODO Auto-generated method stub
		
	}
	
	
}
