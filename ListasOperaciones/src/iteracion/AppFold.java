package iteracion;

import java.util.List;
import java.util.function.Function;

public class AppFold {
	public static <T, U> U foldLeft(List<T> obj, U vi, Function<T, Function<U, U>> fn) {
		U valor = vi;
		for (var v : obj) {
			valor = fn.apply(v).apply(valor);
		}
		return valor;
	}

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);

		String sum = foldLeft(numbers, "", x -> y -> x + y);
		System.out.println("Suma de la lista: " + sum);
	}
}
