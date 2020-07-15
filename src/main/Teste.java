package main;

import formatos.Raca;

public class Teste {

	public static void main(String[] args) {
		Raca r = new Raca("a","a","a","a");
		r.setNome("Troglodita");
		r.setDescricao("Trogs sao feios, eca");
		r.setSuperraca("Humanoide");
		r.InserirCusto(0.0);
		r.InserirCusto(6.0);
		r.setSistema("3d&t");
		r.CriarSegmentoDePeculiaridade("Vantagens");
		r.CriarSegmentoDePeculiaridade("Desvantagens");
		r.InserirPeculiaridadeNoSegmeno("Vantagens", "Ataque Pestilento");
		r.InserirPeculiaridadeNoSegmeno("Vantagens", "Armadura Extra");
		r.CriarCaracteristicaBonus("Armadura");
		r.InserirValorNaCaracteristica("Armadura", 1.0);
		r.CriarCaracteristicaBonus("Forca");
		r.InserirValorNaCaracteristica("Forca", 2.0);
		System.out.println(r.DeDadosParaCodigo());
		
		String codigo = r.DeDadosParaCodigo();
		
		Raca rr = new Raca();
		Raca rrr = new Raca();
		rr.DeCodigoParaDados(new Raca("kek").DeDadosParaCodigo());
		rrr.DeCodigoParaDados(rr.DeDadosParaCodigo());
		
		System.out.println(rr.DeDadosParaCodigo());
		System.out.println(rrr.DeDadosParaCodigo());
		
		System.out.println(new Raca("kek").DeDadosParaCodigo());
	}

}
