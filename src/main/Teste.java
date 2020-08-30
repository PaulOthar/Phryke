package main;

import formatos.Peculiaridade;

public class Teste {
	public static void main(String[] args) {
		Peculiaridade p = new Peculiaridade("Nivel0");
		
		p.getPeculiaridades().add(new Peculiaridade("Nivel0(0)"));
		p.getPeculiaridades().add(new Peculiaridade("Nivel0(1)"));
		p.getPeculiaridades().add(new Peculiaridade("Nivel0(2)"));
		p.getPeculiaridades().add(new Peculiaridade("Nivel0(3)"));
		
		p.getPeculiaridades().get(0).getPeculiaridades().add(new Peculiaridade("(0)Nivel1(0)"));
		p.getPeculiaridades().get(0).getPeculiaridades().add(new Peculiaridade("(0)Nivel1(1)"));
		p.getPeculiaridades().get(0).getPeculiaridades().add(new Peculiaridade("(0)Nivel1(2)"));
		
		p.getPeculiaridades().get(0).getPeculiaridades().get(2).getPeculiaridades().add(new Peculiaridade("(0)(2)Nivel2(0)"));
		p.getPeculiaridades().get(0).getPeculiaridades().get(2).getPeculiaridades().add(new Peculiaridade("(0)(2)Nivel2(1)"));
		
		p.getPeculiaridades().get(2).getPeculiaridades().add(new Peculiaridade("(2)Nivel1(0)"));
		p.getPeculiaridades().get(2).getPeculiaridades().add(new Peculiaridade("(2)Nivel1(1)"));
		p.getPeculiaridades().get(2).getPeculiaridades().add(new Peculiaridade("(2)Nivel1(2)"));
		p.getPeculiaridades().get(2).getPeculiaridades().add(new Peculiaridade("(2)Nivel1(3)"));
		
		p.getPeculiaridades().get(2).getPeculiaridades().get(0).getPeculiaridades().add(new Peculiaridade("(2)(0)Nivel2(0)"));
		p.getPeculiaridades().get(2).getPeculiaridades().get(3).getPeculiaridades().add(new Peculiaridade("(2)(3)Nivel2(0)"));
		
		
		p.DeCodigoParaDados(p.DeDadosParaCodigo());
		System.out.println(p.DeDadosParaCodigo());
		Peculiaridade.PrintarHierarquia(p, "");
		
	}
	
}
