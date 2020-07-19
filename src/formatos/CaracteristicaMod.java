package formatos;

public class CaracteristicaMod extends Formato {
	private Double Modificador;
	

	public CaracteristicaMod(String nomedacaracteristica) {
		this.setNome(nomedacaracteristica);
	}

	public CaracteristicaMod() {
		this.setModificador(0.0);
		this.setNome(new String());
	}

	public Double getModificador() {
		return Modificador;
	}

	public void setModificador(Double modificador) {
		Modificador = modificador;
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

	@Override
	public Formato GerarProprioTipo() {
		return new CaracteristicaMod();
	}

}
