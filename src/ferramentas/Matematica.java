package ferramentas;

import java.util.ArrayList;

//Eu Sei que existe a classe Math, mas eu prefiro usar minhas proprias ferramentas com jogos e prostitutas
public class Matematica {
	public static double CalcularEquacao(String equacao, ArrayList<Double> numeros) {
		return 0;
	}

	// Essa Porra n funciona
	@Deprecated
	public static ArrayList<String> Desparatenzar(String equacao) {
		ArrayList<String> eq = new ArrayList<String>();
		ArrayList<String> eq2 = new ArrayList<String>();
		ArrayList<String> primeironivel = new ArrayList<String>();
		ArrayList<String> segundonivel = new ArrayList<String>();
		int parenteses = 0, trava = 0, contador = 0;
		for (String s : equacao.split(";")) {
			for (String ss : s.split("#")) {
				System.out.println(ss);
				if (!ss.isBlank()) {
					eq.add(ss);
				}
				eq.add("|");
			}
		}

		System.out.println(eq);
		for (String s : eq) {
			if (s.contentEquals("|")) {
				parenteses++;
			}
		}

		trava = parenteses;
		while (parenteses != 0) {
			if (parenteses > trava / 2) {
				if (eq.get(contador).contains("|")) {
					parenteses--;
					System.out.println("Reduzindo" + parenteses + " " + trava / 2);
				}
				primeironivel.add(eq.get(contador));
				contador++;
			}
			if (parenteses <= trava / 2) {
				if (eq.get(contador).contains("|")) {
					parenteses--;
					System.out.println("Reduzindo" + parenteses + " " + trava / 2);
				}
				segundonivel.add(eq.get(contador));
				contador++;
			}
		}
		System.out.println(primeironivel);
		System.out.println(segundonivel);
		contador = 0;
		int i1 = 0, i2 = segundonivel.size();
		while (true) {
			if (i1 >= primeironivel.size() && 0 == i2) {
				break;
			} else if (!(i1 >= primeironivel.size()) && !primeironivel.get(i1).contains("|")) {
				System.out.println(primeironivel.get(i1));
				eq2.add(primeironivel.get(i1));
				i1++;
				System.out.println(1);
			} else if (!segundonivel.get(i2 - 1).contains("|")) {
				System.out.println(segundonivel.get(i2 - 1));
				eq2.add(segundonivel.get(i2 - 1));
				i2--;
				System.out.println(2);
			}

			else {
				eq2.set(eq2.size() - 1, eq2.get(eq2.size() - 1) + "()");
				i1++;
				i2--;
				System.out.println(5);
			}

			System.out.println(i1 + "/" + primeironivel.size() + " " + segundonivel.size() + "/" + i2);
		}
		return eq2;
	}

	public static double Dividir(double numero1, double numero2) {
		try {
			return numero1 / numero2;
		} catch (Exception e) {
			return 0;
		}
	}

	public static float Dividir(float numero1, float numero2) {
		try {
			return numero1 / numero2;
		} catch (Exception e) {
			return 0;
		}
	}

	public static int Dividir(int numero1, int numero2) {
		try {
			return numero1 / numero2;
		} catch (Exception e) {
			return 0;
		}
	}

	public static double Multiplicar(double numero1, double numero2) {
		return numero1 * numero2;
	}

	public static float Multiplicar(float numero1, float numero2) {
		return numero1 * numero2;
	}

	public static int Multiplicar(int numero1, int numero2) {
		return numero1 * numero2;
	}

	public static double Somar(double numero1, double numero2) {
		return numero1 + numero2;
	}

	public static float Somar(float numero1, float numero2) {
		return numero1 + numero2;
	}

	public static int Somar(int numero1, int numero2) {
		return numero1 + numero2;
	}

	public static double Subtrair(double numero1, double numero2) {
		return numero1 - numero2;
	}

	public static float Subtrair(float numero1, float numero2) {
		return numero1 - numero2;
	}

	public static int Subtrair(int numero1, int numero2) {
		return numero1 - numero2;
	}
}
