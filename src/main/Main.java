package main;

import ferramentas.Mensageiro;
import recursosGraficos.Frame;
import recursosGraficosJFX.InterfaceGrafica;

//Classe Main deve ser usada apenas para trabalhar com recursos de instancia maior
public class Main {

	public static void main(String[] args) {
		System.out.println("Rodando");
		if (Mensageiro.PedirConfirmacao("Qual Motor Grafico Deseja Executar? \n Sim = Swing \n Nao = JavaFX")) {
			Frame.Rodar();
		} else {
			InterfaceGrafica.Rodar(args);
		}

	}

}
