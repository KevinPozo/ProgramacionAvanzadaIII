package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
	public static <T> T redAux(List<T> lis, T valin, Function<T, Function<T, T>> fn) {
		if (lis.isEmpty()) {
			return valin;
		} else {
			T valor = lis.get(0);
			List<T> newList = new ArrayList<T>(lis);
			newList.remove(0);
			return fn.apply(valor).apply(redAux(newList, valin, fn));
		}
	}

	public static <T> T red(List<T> lis, Function<T, Function<T, T>> fn) {
		T valor = lis.get(0);
		if (lis.isEmpty()) {
			List.of();
		}

		List<T> newList = new ArrayList<T>(lis);
		newList.remove(0);
		if (newList.isEmpty()) {
			return valor;
		} else {
			return redAux(newList, valor, fn);
		}
	}

	public static String concatenar(List<Integer> lis) {
		String cad = "";
		for (var v : lis) {
			cad += v + " ";
		}
		return cad;
	}

	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4, 5);
		List<String> nombres = List.of("Hola", "Jordy");
		Function<Integer, Function<Integer, Integer>> f = x -> y -> x + y;
		Function<String, Function<String, String>> g = x -> y -> "[" + x + " , " + y + "]";
		System.out.println(red(list, f));
		System.out.println(red(nombres, g));

	}

}
