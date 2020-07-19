package main;

import formatos.*;
import recursosLogicos.DadosDeBanco;

public class Teste {

	public static void main(String[] args) {
		DadosDeBanco.Salvar(DadosDeBanco.Carregar(new Sistema()), new Sistema());
	}

}
