package formatosVelhos;
/*
package formatos;

import java.util.ArrayList;

public class Caracteristica extends Formato {
	private String descricao, operador,operadoraparente;
	private Caracteristica referencia;
	private double valor, valorminimo, valormaximo, modificador;
	private boolean referenciado = false;
	
	public static final String soma = "Soma(+)",subtracao = "Subtracao(-)",multiplicacao = "Multiplicacao(x)",divisao = "Divisao(/)";
	
	public Caracteristica() {
		super.setNome(new String());
		this.setDescricao(new String());
		this.setValor(0);
		this.DefinirMinMax(0, 0);
		this.setModificador(0);
		this.getReferencia().setNome("");
		this.getReferencia().setValor(0);
		this.getReferencia().DefinirMinMax(0, 0);
		this.getReferencia().setModificador(0);
		this.getReferencia().setReferenciado(false);
		this.getReferencia().setOperador("");
		
	}

	public Caracteristica(String Codigo,boolean x) {
		this.DeCodigoParaDados(Codigo);
	}
	
	public Caracteristica(String nome, Double v, Double vmin, Double vmax) {
		super.setNome(nome);
		this.setDescricao(new String());
		this.setValor(v);
		this.DefinirMinMax(vmin, vmax);
	}
	
	public Caracteristica(String nome) {
		super.setNome(nome);
		this.setDescricao(new String());
		this.setValor(0);
		this.DefinirMinMax(0, 0);
	}

	public Caracteristica(String nome, String descricao) {
		super.setNome(nome);
		this.setDescricao(descricao);
		this.setValor(0);
		this.DefinirMinMax(0, 0);
	}

	public Caracteristica(String nome,Caracteristica referencia,String operador,double modificador) {
		super.setNome(nome);
		this.setDescricao(new String());
		this.setReferencia(referencia);
		this.setOperador(operador);
		this.setModificador(modificador);
		this.DefinirValoresViaRegra(referencia);
		this.setReferenciado(true);
		this.Aparencias();
	}
	
	// Lembrar de implementar
	public double CalcularCaracteristicaViaRegra(ArrayList<Double> valores) {
		// Recebe a regra e os Valores, e faz o calculo, inserindo o resultado no valor
		return 0;
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
				this.setValor(Double.parseDouble(s));
				break;
			case 3:
				this.setValormaximo(Double.parseDouble(s));
				break;
			case 4:
				this.setValorminimo(Double.parseDouble(s));
				break;
			case 5:
				this.setModificador(Double.parseDouble(s));
				break;
			case 6:
				this.setOperador(s);
				break;
			case 7:
				this.setReferencia(new Caracteristica(s));
				break;
			case 8:
				this.getReferencia().setValor(Double.parseDouble(s));
				break;
			case 9:
				this.getReferencia().setValormaximo(Double.parseDouble(s));
				break;
			case 10:
				this.getReferencia().setValorminimo(Double.parseDouble(s));
				break;
				
			}
			contador++;
		}
	}

	@Override
	public String DeDadosParaCodigo() {
		String codigo;
		
		if(referenciado) {
			codigo = super.getNome() + primario + this.getDescricao() + primario + this.getValor() + primario
					+ this.getValormaximo() + primario + this.getValorminimo() + primario
					+ this.getModificador() + primario + this.getOperador() + primario + this.getReferencia().getNome() + primario
					+ this.getReferencia().getValor() + primario + this.getReferencia().getValormaximo() + primario + this.getReferencia().getValorminimo();
		}
		else {
			codigo = super.getNome() + primario + this.getDescricao() + primario + this.getValor() + primario
					+ this.getValormaximo() + primario + this.getValorminimo() + primario
					+ 0 + primario + "" + primario + "x" + primario
					+ 0 + primario + 0 + primario + 0;
		}
		return codigo;
	}

	public void DefinirMinMax(double min, double max) {
		this.setValorminimo(min);
		this.setValormaximo(max);
	}
	
	//Lembrar de implementar
	public void DefinirRegra(String regra) {
		// Recebe uma equacao, que formata os valores e as operacoes, e sussetivamente
		// faz o resultado

	}

	@Deprecated
	public void DefinirValor(Double valor) {
		this.setValor(valor);
	}

	public void DefinirValorParametrado(Double valor) {
		// So vai permitir inserir valores, se tiver entre o minimo e o maximo
		if (this.getValorminimo() <= valor && this.getValormaximo() >= valor) {
			this.setValor(valor);
		}
	}

	public void DefinirValoresViaRegra(Caracteristica c) {
		switch(this.getOperador()) {
		case soma:
			this.setValor(c.getValor()+this.getModificador());
			this.setValorminimo(c.getValorminimo()+this.getModificador());
			this.setValormaximo(c.getValormaximo()+this.getModificador());
			break;
		case subtracao:
			this.setValor(c.getValor()-this.getModificador());
			this.setValorminimo(c.getValorminimo()-this.getModificador());
			this.setValormaximo(c.getValormaximo()-this.getModificador());
			break;
		case divisao:
			this.setValor(c.getValor()/this.getModificador());
			this.setValorminimo(c.getValorminimo()/this.getModificador());
			this.setValormaximo(c.getValormaximo()/this.getModificador());
			break;
		case multiplicacao:
			this.setValor(c.getValor()*this.getModificador());
			this.setValorminimo(c.getValorminimo()*this.getModificador());
			this.setValormaximo(c.getValormaximo()*this.getModificador());
			break;
		}
	}

	public double CalcularValorViaRegra(double valordacaracteristica) {
		switch(this.getOperador()) {
		case soma:
			return valordacaracteristica + this.getModificador();
		case subtracao:
			return valordacaracteristica - this.getModificador();
		case divisao:
			return valordacaracteristica / this.getModificador();
		case multiplicacao:
			return valordacaracteristica * this.getModificador();
		default:
			return 0;
		}
	}
	
	public void Aparencias() {
		switch(operador) {
		case soma:
			this.setOperadoraparente("+"+modificador);
			break;
		case subtracao:
			this.setOperadoraparente("-"+modificador);
			break;
		case divisao:
			this.setOperadoraparente("/"+modificador);
			break;
		case multiplicacao:
			this.setOperadoraparente("x"+modificador);
			break;
		}
	}
	
	@Override
	public Formato GerarProprioTipo() {
		return new Caracteristica();
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public double getValormaximo() {
		return valormaximo;
	}

	public double getValorminimo() {
		return valorminimo;
	}

	public Caracteristica getReferencia() {
		return referencia;
	}

	public double getModificador() {
		return modificador;
	}

	public String getOperador() {
		return operador;
	}
	
	public boolean isReferenciado() {
		return referenciado;
	}

	public String getOperadoraparente() {
		return operadoraparente;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setValormaximo(double valormaximo) {
		this.valormaximo = valormaximo;
	}

	public void setValorminimo(double valorminimo) {
		this.valorminimo = valorminimo;
	}
	
	public void setReferencia(Caracteristica referencia) {
		this.referencia = referencia;
	}

	public void setModificador(double modificador) {
		this.modificador = modificador;
	}

	
	public void setOperador(String operador) {
		this.operador = operador;
	}

	public void setReferenciado(boolean referenciado) {
		this.referenciado = referenciado;
	}

	public void setOperadoraparente(String operadoraparente) {
		this.operadoraparente = operadoraparente;
	}

	@Override
	public String toString() {
		return super.getNome();
	}

}
*/
