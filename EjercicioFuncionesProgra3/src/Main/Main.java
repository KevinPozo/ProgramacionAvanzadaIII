package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	//Ejemplo N1:
	private static List<Integer> lista = new ArrayList<Integer>();
	
	public static void addLista(int val) {
		lista.add(val);
	}
	
	public static void main(String[] args) {
		int a = 3;
		int b = 2;
//Con funcion pura:
		int res = Ejemplo.sumar(a, b);
		int resDos = Ejemplo.sumar(b, a);
		System.out.println(res);
		System.out.println(resDos);
		System.out.println(a + " " + b);
//Con funcion devuelve el mismo valor:
		System.out.println(Ejemplo.incrementar(2));
		System.out.println(Ejemplo.incrementar(2));
//EJemplo N1:
		addLista(2);
		addLista(4);
		addLista(5);
		addLista(6);
		System.out.println(lista.toString());
		
		for(var it:lista) {
			System.out.println("Antes: "+it);
		}
		addLista(12);
		for(var it:lista) {
			System.out.println("Despues: "+it);
		}
		
	}

}
