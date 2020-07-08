package ferramentas;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Reflexivo {
	//Nao sei Debugar que nem gente, entao vou listar tudo que der para listar, durante a execucao do codigo :V
	
	//Strings
	public static ArrayList<String> ObterListaDeNomesDosMetodosDaClasse(Class<?> c){
		ArrayList<String> lista = new ArrayList<String>();
		for(Method m : c.getDeclaredMethods()) {
			lista.add(m.getName());
		}
		return lista;
	}
	public static ArrayList<String> ObterListaDeNomesDasVariaveisDaClasse(Class<?> c){
		ArrayList<String> lista = new ArrayList<String>();
		for(Field f : c.getDeclaredFields()) {
			lista.add(f.getName());
		}
		return lista;
	}
	public static String ObterNomeDaClasse(Class<?> c) {
		return c.getName();
	}
	
	//Estruturas
	public static ArrayList<Method> ObterListaDeMetodosDaClasse(Class<?> c){
		ArrayList<Method> lista = new ArrayList<Method>();
		for(Method m : c.getDeclaredMethods()) {
			lista.add(m);
		}
		return lista;
	}
	public static ArrayList<Field> ObterListaDeVariaveisDaClasse(Class<?> c){
		ArrayList<Field> lista = new ArrayList<Field>();
		for(Field f : c.getDeclaredFields()) {
			lista.add(f);
		}
		return lista;
	}
	
	//NAO USAR, POAR
	public static Method BurlarAcessoDoMetodo(Class<?> classe,String nomemetodo) throws NoSuchMethodException, SecurityException {
		Method m = classe.getDeclaredMethod(nomemetodo);
		m.setAccessible(true);
		return m;
	}
	public static Field BurlarAcessoDaVariavel(Class<?> classe,String nomevariavel) throws NoSuchFieldException, SecurityException {
		Field f = classe.getDeclaredField(nomevariavel);
		f.setAccessible(true);
		return f;
	}
}
