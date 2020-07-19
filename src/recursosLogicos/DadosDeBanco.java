package recursosLogicos;

import java.util.ArrayList;

import ferramentas.ManipuladorDeArquivo;
import formatos.*;

public class DadosDeBanco {
	public static String pasta = "DadosDeBanco";
	public static ArrayList<Sistema> Sistemas = new ArrayList<Sistema>();
	public static ArrayList<Caracteristica> Caracteristicas = new ArrayList<Caracteristica>();
	public static ArrayList<Peculiaridade> Peculiaridades = new ArrayList<Peculiaridade>();
	public static ArrayList<Raca> Racas = new ArrayList<Raca>();
	public static ArrayList<SuperRaca> SuperRacas = new ArrayList<SuperRaca>();
	public static ArrayList<Regra> Regras = new ArrayList<Regra>();
	
	public static void Salvar(Object o) {
		ArrayList<Formato> Formatos = (ArrayList<Formato>) o;
		ArrayList<String> Codigos = new ArrayList<String>();
		for(Formato ff : Formatos) {
			Codigos.add(ff.DeDadosParaCodigo());
		}
		ManipuladorDeArquivo.sobreescreverArquivoLista(ManipuladorDeArquivo.selecionarArquivoPorNome(pasta, Formatos.get(0).getClass().getSimpleName()+".txt"), Codigos);
	}
	public static ArrayList<Formato> Carregar(Object o,Object tipo) {
		ArrayList<Formato> Formato = (ArrayList<formatos.Formato>) o;
		ArrayList<String> Codigos = new ArrayList<String>();
		
		for(int i = 0;i<Formato.size();i++) {
			Formato.remove(i);
		}
		
		for(String s : ManipuladorDeArquivo.lerArquivoLinhas(ManipuladorDeArquivo.selecionarArquivoPorNome(pasta, tipo.getClass().getSimpleName()+".txt"))) {
			Codigos.add(s);
		}
		
		for(int i = 0;i<Codigos.size();i++) {
			Formato.add((formatos.Formato) tipo);
			Formato.get(i).DeCodigoParaDados(Codigos.get(i));
		}
		
		o = Formato;
		return Formato;
	}
}
