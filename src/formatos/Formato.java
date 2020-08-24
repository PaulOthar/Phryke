package formatos;

public abstract class Formato {
	public static final String primario = "¢", secundario = "#", terciario = "¬";

	// Bem... todo Formato Vai ter nome, como Raca, Super Racas,
	// Vantagens,Desvantagens, por ai vai...
	private String Nome;

	public abstract void DeCodigoParaDados(String Codigo);

	public abstract String DeDadosParaCodigo();

	public abstract Formato GerarProprioTipo();

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
}
