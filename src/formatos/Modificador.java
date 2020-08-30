package formatos;

public class Modificador extends Formato {
	private double modificador;
	
	public Modificador() {
		super.setNome("");
		this.setModificador(0);
	}
	public Modificador(String nome,double modificador) {
		super.setNome(nome);
		this.setModificador(modificador);
	}
	
	public double getModificador() {
		return modificador;
	}

	public void setModificador(double modificador) {
		this.modificador = modificador;
	}
	
	@Override
	public void DeCodigoParaDados(String Codigo) {
		int contador = 0;
		for(String s : Codigo.split(quinario)) {
			switch(contador) {
			case 0:
				this.setNome(s);
				break;
			case 1:
				try {
					this.setModificador(Double.parseDouble(s));
				}
				catch(Exception e) {
					e.printStackTrace();
					this.setModificador(0);
				}
				break;
			}
			contador++;
		}
	}

	@Override
	public String DeDadosParaCodigo() {
		String codigo;
		codigo = this.getNome()+quinario+this.getModificador();
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
