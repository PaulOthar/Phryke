package formatos;

import java.util.ArrayList;

public class Caracteristica extends Formato {
	// Algumas Caracteristicas, sao definidas por outros fatores, como no 3d&t, a
	// vida e definida por 5x a Resistencia
	// a regra nesse caso vai definir o valor da caracteristica.
	private String descricao, regra, sistema;
	private double valor, valorminimo, valormaximo;

	public Caracteristica() {
		super.setNome(new String());
		this.setDescricao(new String());
		this.setRegra(new String());
		this.setSistema(new String());
		this.setValor(0);
		this.DefinirMinMax(0, 0);
	}

	public Caracteristica(String nome) {
		super.setNome(nome);
		this.setDescricao(new String());
		this.setRegra(new String());
		this.setSistema(new String());
		this.setValor(0);
		this.DefinirMinMax(0, 0);
	}

	public Caracteristica(String nome, String descricao) {
		super.setNome(nome);
		this.setDescricao(descricao);
		this.setRegra(new String());
		this.setSistema(new String());
		this.setValor(0);
		this.DefinirMinMax(0, 0);
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
				this.setRegra(s);
				break;
			case 3:
				this.setSistema(s);
				break;
			case 4:
				this.setValor(Double.parseDouble(s));
				break;
			case 5:
				this.setValormaximo(Double.parseDouble(s));
				break;
			case 6:
				this.setValorminimo(Double.parseDouble(s));
				break;
			}
			contador++;
		}
	}

	@Override
	public String DeDadosParaCodigo() {
		String codigo;
		codigo = super.getNome() + primario + this.getDescricao() + primario + this.getRegra() + primario
				+ this.getSistema() + primario + this.getValor() + primario + this.getValormaximo() + primario
				+ this.getValorminimo();
		return codigo;
	}

	public void DefinirMinMax(double min, double max) {
		this.setValorminimo(min);
		this.setValormaximo(max);
	}

	// Lembrar de implementar
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

	// Lembrar de implementar
	public void DefinirValorViaRegra(ArrayList<Double> valores) {

	}

	@Override
	public Formato GerarProprioTipo() {
		return new Caracteristica();
	}

	public String getDescricao() {
		return descricao;
	}

	public String getRegra() {
		return regra;
	}

	public String getSistema() {
		return sistema;
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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
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

}
