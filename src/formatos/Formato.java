package formatos;

public abstract class Formato {
	//Bem... todo Formato Vai ter nome, como Raca, Super Racas, Vantagens,Desvantagens, por ai vai...
	private String Nome;
	
	public static final String primario = ";",secundario = "#",terciario = "¬";

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	public abstract String DeDadosParaCodigo();
	public abstract void DeCodigoParaDados(String Codigo);
}
