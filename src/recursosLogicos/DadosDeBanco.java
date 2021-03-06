package recursosLogicos;

import java.util.ArrayList;

import ferramentas.ManipuladorDeArquivo;
import formatos.Formato;

public class DadosDeBanco {
	public static String pasta = "DadosDeBanco";

	public static ArrayList<Formato> Carregar(Formato tipo) {
		ArrayList<Formato> formatos = new ArrayList<Formato>();
		ArrayList<String> Codigos = new ArrayList<String>();
		for (String s : ManipuladorDeArquivo.lerArquivoLinhas(
				ManipuladorDeArquivo.selecionarArquivoPorNome(pasta, tipo.getClass().getSimpleName() + ".txt"))) {
			Codigos.add(s);
		}
		for (int i = 0; i < Codigos.size(); i++) {
			formatos.add(tipo.GerarProprioTipo());
			formatos.get(i).DeCodigoParaDados(Codigos.get(i));
		}
		return formatos;
	}

	public static ArrayList<Formato> CarregarProBanco(Object o, Object tipo) {
		ArrayList<Formato> Formato = (ArrayList<formatos.Formato>) o;
		ArrayList<String> Codigos = new ArrayList<String>();

		for (int i = 0; i < Formato.size(); i++) {
			Formato.remove(i);
		}

		for (String s : ManipuladorDeArquivo.lerArquivoLinhas(
				ManipuladorDeArquivo.selecionarArquivoPorNome(pasta, tipo.getClass().getSimpleName() + ".txt"))) {
			Codigos.add(s);
		}

		for (int i = 0; i < Codigos.size(); i++) {
			Formato.add((formatos.Formato) tipo);
			Formato.get(i).DeCodigoParaDados(Codigos.get(i));
		}

		o = Formato;
		return Formato;
	}

	public static void Excluir(Formato tipoexcluir) {
		ManipuladorDeArquivo.ApagarArquivoLinha(
				ManipuladorDeArquivo.selecionarArquivoPorNome(pasta, ObtertipoComTXT(tipoexcluir)),
				tipoexcluir.DeDadosParaCodigo());
	}

	public static String ObtertipoComTXT(Formato tipo) {
		return tipo.getClass().getSimpleName() + ".txt";
	}

	public static ArrayList<String> PegarNomes(Formato tipo) {
		ArrayList<String> nomes = new ArrayList<String>();
		for (Formato f : Carregar(tipo)) {
			nomes.add(f.getNome());
		}
		return nomes;
	}

	public static void Salvar(Object o, Object tipo) {
		ArrayList<Formato> Formatos = (ArrayList<Formato>) o;
		ArrayList<String> Codigos = new ArrayList<String>();
		for (Formato ff : Formatos) {
			Codigos.add(ff.DeDadosParaCodigo());
		}
		ManipuladorDeArquivo.sobreescreverArquivoLista(
				ManipuladorDeArquivo.selecionarArquivoPorNome(pasta, tipo.getClass().getSimpleName() + ".txt"),
				Codigos);
	}

	public static void SalvarUnico(Formato f) {
		ManipuladorDeArquivo.escreverNovaLinha(
				ManipuladorDeArquivo.selecionarArquivoPorNome(pasta, f.getClass().getSimpleName() + ".txt"),
				f.DeDadosParaCodigo());
	}

	public static void Substituir(Formato tipovelho, Formato tiponovo) {
		ManipuladorDeArquivo.SubstituirArquivoLinha(
				ManipuladorDeArquivo.selecionarArquivoPorNome(pasta, tipovelho.getClass().getSimpleName() + ".txt"),
				tipovelho.DeDadosParaCodigo(), tiponovo.DeDadosParaCodigo());
	}
}
