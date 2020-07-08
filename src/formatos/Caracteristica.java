package formatos;

import java.util.ArrayList;

public class Caracteristica extends Formato {
	//Algumas Caracteristicas, sao definidas por outros fatores, como no 3d&t, a vida e definida por 5x a Resistencia
	// a regra nesse caso vai definir o valor da caracteristica.
	private String descricao,regra;
	private double valor,valorminimo,valormaximo;
	
	public Caracteristica() {
		this.setDescricao(new String());
		this.setRegra(new String());
		this.setValor(0);
		this.DefinirMinMax(0, 0);
	}
	public Caracteristica(String nome) {
		super.setNome(nome);
		this.setDescricao(new String());
		this.setRegra(new String());
		this.setValor(0);
		this.DefinirMinMax(0, 0);
	}
	public Caracteristica(String nome,String descricao) {
		super.setNome(nome);
		this.setDescricao(descricao);
		this.setRegra(new String());
		this.setValor(0);
		this.DefinirMinMax(0, 0);
	}
	
	//Lembrar de implementar
	public void DefinirRegra(String regra) {
		//Recebe uma equacao, que formata os valores e as operacoes, e sussetivamente faz o resultado 
		
	}
	//Lembrar de implementar
	public double CalcularCaracteristicaViaRegra(ArrayList<Double> valores) {
		//Recebe a regra e os Valores, e faz o calculo, inserindo o resultado no valor
		return 0;
	}
	
	public void DefinirMinMax(double min,double max) {
		this.setValorminimo(min);
		this.setValormaximo(max);
	}
	@Deprecated
	public void DefinirValor(Double valor) {
		this.setValor(valor);
	}
	public void DefinirValorParametrado(Double valor) {
		//So vai permitir inserir valores, se tiver entre o minimo e o maximo
		if(this.getValorminimo()<=valor && this.getValormaximo() >= valor) {
			this.setValor(valor);
		}
	}
	//Lembrar de implementar
	public void DefinirValorViaRegra(ArrayList<Double> valores) {
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	public String getRegra() {
		return regra;
	}
	public double getValor() {
		return valor;
	}
	public double getValorminimo() {
		return valorminimo;
	}
	public double getValormaximo() {
		return valormaximo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setRegra(String regra) {
		this.regra = regra;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void setValorminimo(double valorminimo) {
		this.valorminimo = valorminimo;
	}
	public void setValormaximo(double valormaximo) {
		this.valormaximo = valormaximo;
	}
	
	
}
