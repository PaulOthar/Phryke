package formatos;

public class Caracteristica extends Formato {
	private String operador, Creferencia1, Creferencia2, aparencia;
	private boolean referenciadoC, referenciadoV;
	private double valor, valorminimo, valormaximo, modificador;
	public static final String soma = "Soma(+)", subtracao = "Subtracao(-)", multiplicacao = "Multiplicacao(x)",
			divisao = "Divisao(/)";

	public Caracteristica() {
		super.setNome("");
		this.setOperador("");
		this.setCreferencia1("");
		this.setCreferencia2("");
		this.setAparencia("");
		this.setReferenciadoC(false);
		this.setReferenciadoV(false);
		this.setValor(0);
		this.setValorminimo(0);
		this.setValormaximo(0);
		this.setModificador(0);

	}

	public Caracteristica(String nome) {
		this();
		super.setNome(nome);
	}

	public Caracteristica(String codigo,boolean chave) {
		this.DeCodigoParaDados(codigo);
	}
	
	public Caracteristica(String nome, double valor, double valorminimo, double valormaximo) {
		this(nome);
		this.setValor(valor);
		this.setValorminimo(valorminimo);
		this.setValormaximo(valormaximo);

	}

	public Caracteristica(String nome, Caracteristica caracteristica, String operador, double modificador) {
		this(nome);
		this.setCreferencia1(caracteristica.getNome());
		this.setReferenciadoV(true);
		this.setModificador(modificador);
		this.setOperador(operador);
		this.setValor(this.CalcularViaOperador(caracteristica.getValor(), modificador, operador));
		this.setValorminimo(this.CalcularViaOperador(caracteristica.getValorminimo(), modificador, operador));
		this.setValormaximo(this.CalcularViaOperador(caracteristica.getValormaximo(), modificador, operador));
		this.setAparencia(this.GerarAparencia(operador, modificador));

	}

	public Caracteristica(String nome, Caracteristica caracteristica1, Caracteristica caracteristica2,String operador) {
		this(nome);
		this.setCreferencia1(caracteristica1.getNome());
		this.setCreferencia2(caracteristica2.getNome());
		this.setReferenciadoC(true);
		this.setOperador(operador);
		this.setValor(this.CalcularViaOperador(caracteristica1.getValor(), caracteristica2.getValor(), operador));
		this.setValorminimo(this.CalcularViaOperador(caracteristica1.getValorminimo(), caracteristica2.getValorminimo(), operador));
		this.setValormaximo(this.CalcularViaOperador(caracteristica1.getValormaximo(), caracteristica2.getValormaximo(), operador));
		this.setAparencia(this.GerarAparencia(operador, caracteristica2.getNome()));
	}

	public String GerarAparencia(String operador, double modificador) {
		switch (operador) {
		case soma:
			return "+" + modificador;
		case subtracao:
			return "-" + modificador;
		case divisao:
			return "/" + modificador;
		case multiplicacao:
			return "x*" + modificador;
		default:
			return "";
		}
	}
	
	public String GerarAparencia(String operador, String caracteristica) {
		switch (operador) {
		case soma:
			return "+" + caracteristica;
		case subtracao:
			return "-" + caracteristica;
		case divisao:
			return "/" + caracteristica;
		case multiplicacao:
			return "x" + caracteristica;
		default:
			return "";
		}
	}

	public double CalcularViaOperador(double valor1, double valor2, String operador) {
		switch (operador) {
		case soma:
			return valor1 + valor2;
		case subtracao:
			return valor1 - valor2;
		case divisao:
			return valor1 / valor2;
		case multiplicacao:
			return valor1 * valor2;
		default:
			return 0;
		}
	}

	public String getOperador() {
		return operador;
	}

	public String getCreferencia1() {
		return Creferencia1;
	}

	public String getCreferencia2() {
		return Creferencia2;
	}

	public String getAparencia() {
		return aparencia;
	}

	public boolean isReferenciadoC() {
		return referenciadoC;
	}

	public boolean isReferenciadoV() {
		return referenciadoV;
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

	public double getModificador() {
		return modificador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public void setCreferencia1(String creferencia1) {
		Creferencia1 = creferencia1;
	}

	public void setCreferencia2(String creferencia2) {
		Creferencia2 = creferencia2;
	}

	public void setAparencia(String aparencia) {
		this.aparencia = aparencia;
	}

	public void setReferenciadoC(boolean referenciadoC) {
		this.referenciadoC = referenciadoC;
	}

	public void setReferenciadoV(boolean referenciadoV) {
		this.referenciadoV = referenciadoV;
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

	public void setModificador(double modificador) {
		this.modificador = modificador;
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
				this.setReferenciadoC(Boolean.parseBoolean(s));
				break;
			case 2:
				this.setReferenciadoV(Boolean.parseBoolean(s));
				break;
			case 3:
				this.setCreferencia1(s);
				break;
			case 4:
				this.setCreferencia2(s);
				break;
			case 5:
				this.setAparencia(s);
				break;
			case 6:
				this.setOperador(s);
				break;
			case 7:
				this.setValor(Double.parseDouble(s));
				break;
			case 8:
				this.setValorminimo(Double.parseDouble(s));
				break;
			case 9:
				this.setValormaximo(Double.parseDouble(s));
				break;
			case 10:
				this.setModificador(Double.parseDouble(s));
				break;
			}
			contador++;
		}
	}

	@Override
	public String DeDadosParaCodigo() {
		String codigo = "";
		
		codigo = this.getNome() + 
				primario + this.isReferenciadoC() + 
				primario + this.isReferenciadoV() + 
				primario + this.getCreferencia1() + 
				primario + this.getCreferencia2()+
				primario + this.getAparencia() + 
				primario + this.getOperador() + 
				primario + this.getValor() + 
				primario + this.getValorminimo() + 
				primario + this.getValormaximo() +
				primario + this.getModificador();
		
		return codigo;
	}

	@Override
	public Formato GerarProprioTipo() {
		return this;
	}

	
	@Override
	public String toString() {
		return super.getNome();
	}

}
