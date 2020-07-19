package main;

import formatos.*;
import recursosLogicos.DadosDeBanco;

public class Teste {

	public static void main(String[] args) {
		System.out.println(DadosDeBanco.Carregar(DadosDeBanco.Sistemas,new Sistema()).get(0).getNome());
		System.out.println(DadosDeBanco.Sistemas.get(0).getNome());
	}

}
