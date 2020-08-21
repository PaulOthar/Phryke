package formatos;

public class Regra extends Formato {
	private String regra;

	public Regra() {
		super.setNome(new String());
		this.setRegra(new String());
	}
	public Regra(String nome,String regra) {
		super.setNome(nome);
		this.setRegra(regra);
	}

	public Regra(String Codigo,boolean x) {
		this.DeCodigoParaDados(Codigo);
	}
	
	@Override
	public void DeCodigoParaDados(String Codigo) {
		int Contador = 0;
		for (String s : Codigo.split(primario)) {
			switch (Contador) {
			case 0:
				super.setNome(s);
				break;
			case 1:
				this.setRegra(s);
				break;
			}
			Contador++;
		}
	}

	@Override
	public String DeDadosParaCodigo() {
		String Codigo = new String();
		Codigo = super.getNome() + primario + this.getRegra();
		return Codigo;
	}

	@Override
	public Formato GerarProprioTipo() {
		// TODO Auto-generated method stub
		return new Regra();
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}
	@Override
	public String toString() {
		return super.getNome();
	}


}
