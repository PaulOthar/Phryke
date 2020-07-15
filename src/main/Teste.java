package main;

import formatos.Caracteristica;
import formatos.Peculiaridade;
import formatos.Raca;

public class Teste {

	public static void main(String[] args) {
		Peculiaridade p = new Peculiaridade();
		p.setNome("Ataque Pestilento");
		p.setDescricao("vc cospe");
		p.setSistema("3D&T");
		p.setSegmento("Vantagens");
		p.InserirCusto(0.0);
		p.InserirCusto(3.0);
		Peculiaridade pp = new Peculiaridade();
		pp.DeCodigoParaDados(p.DeDadosParaCodigo());
		System.out.println(p.DeDadosParaCodigo());
		System.out.println(pp.DeDadosParaCodigo());
	}

}
