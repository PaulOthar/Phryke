package formatos;

public class Regra extends Formato {
	private String regra,sistema;

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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void DeCodigoParaDados(String Codigo) {
		// TODO Auto-generated method stub
		
	}
	
}
