package recursosLogicos;

import java.util.Random;

public class MeuNomeEhDado {
	public static int RolarDado(int lados) {
		Random r = new Random();
		int x = r.nextInt(lados);
		if (x > 0) {
			return x + 1;
		} else {
			return 1;
		}
	}
}
