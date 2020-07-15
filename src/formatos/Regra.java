package formatos;

public class Regra extends Formato {
	private String regra,sistema;

	public Regra() {
		super.setNome(new String());
		this.setRegra(new String());
		this.setSistema(new String());
	}
	
	public String getRegra() {
		return regra;
	}
	public String getSistema() {
		return sistema;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	
	@Override
	public String DeDadosParaCodigo() {
		String Codigo = new String();
		Codigo = super.getNome()+primario+this.getRegra()+primario+this.getSistema();
		return Codigo;
	}
	@Override
	public void DeCodigoParaDados(String Codigo) {
		int Contador = 0;
		for(String s : Codigo.split(primario)) {
			switch(Contador) {
			case 0:
				super.setNome(s);
				break;
			case 1:
				this.setRegra(s);
				break;
			case 2:
				this.setSistema(s);
				break;
			}
			Contador++;
		}
	}
	
}
