package formatos;

public class Segmento extends Formato {
	private String ValorAssociado;
	
	public Segmento() {
		this.setNome("");
		this.setValorAssociado("");
	}
	
	public Segmento(String Codigo,boolean x) {
		this.DeCodigoParaDados(Codigo);
	}
	
	public Segmento(String nome, String VA){
		this.setNome(nome);
		this.setValorAssociado(VA);
	}

	public String getValorAssociado() {
		return ValorAssociado;
	}

	public void setValorAssociado(String ValorAssociado) {
		this.ValorAssociado = ValorAssociado;
	}

	@Override
	public void DeCodigoParaDados(String Codigo) {
		int contador = 0;
		for (String s : Codigo.split(primario)) {
			switch (contador) {
			case 0:
				this.setNome(s);
				break;
			case 1:
				this.setValorAssociado(s);
				break;
			}
			contador++;
		}
			
	}

	@Override
	public String DeDadosParaCodigo() {
		return this.getNome() + primario + this.getValorAssociado();
	}

	@Override
	public Formato GerarProprioTipo() {
		return new Segmento();
	}

}
