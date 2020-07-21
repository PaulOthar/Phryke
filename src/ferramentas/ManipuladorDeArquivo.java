package ferramentas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;

public class ManipuladorDeArquivo {
	
	public static void criarArquivo(String pasta,String nome) {
		try {
			if(!pasta.isBlank() && !nome.isBlank()) {
				new File(pasta).mkdir();
				if(new File(pasta+"//"+nome).createNewFile()) {
					System.out.println("O Arquivo "+nome+" Foi criado na pasta "+pasta);
				}
				
				else {
					System.out.println("O Arquivo "+nome+" Ja Existe na pasta "+pasta);
				}
			}
			
			else {
				System.out.println("Nao foi possivel criar o arquivo, pois falta informar nome e destino");
			}
		}
		catch(Exception e) {
			System.out.println("Nao foi possivel criar o arquivo: "+nome);
			e.printStackTrace();
		}
	}
	public static File selecionarArquivoPorNome(String pasta,String nome) {
		
		File arquivo = new File(pasta+"//"+nome);
		
		if(!pasta.isBlank() && !nome.isBlank()) {
			if(arquivo.exists()) {
				System.out.println("Arquivo "+nome+" Selecionado");
				return arquivo;
			}
			else {
				System.out.println("O Arquivo Nao Existe,Procedendo com a criacao...");
				criarArquivo(pasta,nome);
				return arquivo;
			}
		}
		else {
			System.out.println("Ha Campos Vazios");
			return null;
		}
	}
	
	public static void sobreescreverArquivo(File arquivo,String texto) {
		if(arquivo.exists()) {
			System.out.println("Sobreescrevendo em: "+arquivo.getName());
			try {
				FileOutputStream arq = new FileOutputStream(arquivo);
				PrintWriter pr = new PrintWriter(arq);
				pr.println(texto);
				pr.close();
				arq.close();
				System.out.println("Arquivo Sobreescrito com Sucesso");
			}
			catch(Exception e){
				System.out.println("Nao Foi Possivel Sobreescrever o arquivo");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("O Arquivo Nao Existe");
			return;
		}
	}
	public static void sobreescreverArquivoLinha(File arquivo,String texto,int linha) {
		if(arquivo.exists()) {
			System.out.println("Sobreescrevendo Linha "+linha+" em: "+arquivo.getName());
			try {
				ArrayList<String> linhas = lerArquivoLinhas(arquivo);
				System.out.println(linhas);
				if(linhas.size()<linha) {
					for(int i = linhas.size() ; i<linha ; i++) {
						linhas.add("");
					}
				}
				linhas.set(linha -1, texto);
				sobreescreverArquivoLista(arquivo,linhas);
			}
			catch(Exception e) {
				System.out.println("Nao Foi Possivel Sobreescrever o arquivo");
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("O Arquivo Nao Existe");
			return;
		}
	}
	public static void sobreescreverArquivoLista(File arquivo,ArrayList<String> texto) {
		if(arquivo.exists()) {
			System.out.println("Sobreescrevendo em: "+arquivo.getName());
			try {
				FileOutputStream arq = new FileOutputStream(arquivo);
				PrintWriter pr = new PrintWriter(arq);
				for(String s : texto) {
					pr.println(s);
				}
				pr.close();
				arq.close();
				System.out.println("Arquivo Sobreescrito Com Sucesso");
			}
			catch(Exception e) {
				System.out.println("Nao Foi Possivel Sobreescrever o arquivo");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("O Arquivo Nao Existe");
			return;
		}
	}
	
	public static void escreverNovaLinha(File arquivo,String texto) {
		if(arquivo.exists()) {
			try {
				String statusanterior = lerArquivo(arquivo);
				FileOutputStream arq = new FileOutputStream(arquivo);
				PrintWriter pr = new PrintWriter(arq);
				pr.print(statusanterior);
				pr.print(texto);
				pr.close();
				arq.close();
				System.out.println("Nova Linha Escrita Com Sucesso");
			}
			catch(Exception e){
				System.out.println("Erro ao Escrever em: "+arquivo.getName());
				e.printStackTrace();
			}
		}
		else {
			System.out.println("O Arquivo Nao Existe");
			return;
		}
	}
	
	public static String lerArquivo(File arquivo) {
		if(arquivo.exists()) {
			try {
				FileInputStream arq = new FileInputStream(arquivo);
				InputStreamReader input = new InputStreamReader(arq);
				BufferedReader br = new BufferedReader(input);
				String linha = "";
				String saida = "";
				while(linha != null) {
					
					linha = br.readLine();
					if(linha != null) {
						saida = saida+linha+" \n";
					}
					
				}
				br.close();
				input.close();
				arq.close();
				return saida;
			}
			catch(Exception e){
				System.out.println("Nao Foi Possivel Ler o arquivo "+arquivo.getName());
				e.printStackTrace();
				return null;
			}
		}
		else {
			System.out.println("O Arquivo Nao Existe");
			return null;
		}
	}
	public static ArrayList<String> lerArquivoLinhas(File arquivo){
		if(arquivo.exists()) {
			try {
				FileInputStream arq = new FileInputStream(arquivo);
				InputStreamReader input = new InputStreamReader(arq);
				BufferedReader br = new BufferedReader(input);
				
				String linha = "";
				ArrayList<String> saida = new ArrayList<String>();
				
				while(linha != null) {
					linha = br.readLine();
					
					if(linha != null){
						saida.add(linha);
					}
				}
				
				br.close();
				input.close();
				arq.close();
				return saida;
			}
			catch(Exception e){
				System.out.println("Nao Foi Possivel Ler o arquivo "+arquivo.getName());
				e.printStackTrace();
				return null;
			}
		}
		else {
			System.out.println("O Arquivo Nao Existe");
			return null;
		}
	}
	
	public static String Desparagrafadorsimples(String s) {
		try {
			StringReader sr = new StringReader(s);
			BufferedReader br = new BufferedReader(sr);
			
			String linha = "";
			String saida = "";
			boolean primeiralinha = true;
			
			while(linha != null) {
				linha = br.readLine();
				
				if(linha != null && primeiralinha) {
					saida = saida+linha;
					primeiralinha = false;
					
				}
				else if(linha != null) {
					saida = saida+" "+linha;
				}
				
			}
			br.close();
			sr.close();
			return saida;
		}
		catch(Exception e){
			System.out.println("Erro ao Desparagrafar");
			e.printStackTrace();
			return null;
		}
	}
	public static String Desparagrafadorelaborado(String s) {
		String saida = Desparagrafadorsimples(s);
		return saida.replaceAll(";", ",").replaceAll("£", "").replaceAll("#", "*");
	}
	
	public static void SubstituirArquivoLinha(File arquivo,String textoinicial,String textoatual) {
		ArrayList<String> lista = lerArquivoLinhas(arquivo);
		for(int i = 0;i<lista.size();i++) {
			if(lista.get(i).contentEquals(textoinicial)) {
				lista.set(i, textoatual);
			}
		}
		sobreescreverArquivoLista(arquivo,lista);
	}
	public static void ApagarArquivoLinha(File arquivo,String texto) {
		ArrayList<String> documento = new ArrayList<String>();
		documento = lerArquivoLinhas(arquivo);
		for(int i = 0;i<documento.size();i++) {
			if(documento.get(i).contains(texto)) {
				documento.remove(i);
			}
		}
		sobreescreverArquivoLista(arquivo,documento);
	}
}