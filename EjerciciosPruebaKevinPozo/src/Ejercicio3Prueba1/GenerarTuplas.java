package Ejercicio3Prueba1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenerarTuplas {

	public static <T, U, R, S> List<Pair<R, S>> generarTuplas(List<T> lista1, List<U> lista2, Function<T, R> funcion1,
			Function<U, S> funcion2) {
		return generarTuplasRecursivo(lista1, lista2, funcion1, funcion2, new ArrayList<>());
	}

	private static <T, U, R, S> List<Pair<R, S>> generarTuplasRecursivo(List<T> lista1, List<U> lista2,
			Function<T, R> funcion1, Function<U, S> funcion2, List<Pair<R, S>> resultado) {

		if (lista1.isEmpty() || lista2.isEmpty()) {
			return resultado;
		}

		R valor1 = funcion1.apply(lista1.get(0));
		S valor2 = funcion2.apply(lista2.get(0));

		resultado.add(new Pair<>(valor1, valor2));

		return generarTuplasRecursivo(lista1.subList(1, lista1.size()), lista2.subList(1, lista2.size()), funcion1,
				funcion2, resultado);
	}

	public static class Pair<A, B> {
		private final A first;
		private final B second;

		public Pair(A first, B second) {
			this.first = first;
			this.second = second;
		}

		public A getFirst() {
			return first;
		}

		public B getSecond() {
			return second;
		}

		@Override
		public String toString() {
			return "(" + first + ", " + second + ")";
		}
	}

	public static void main(String[] args) {
		List<Integer> L1 = List.of(3, 2, 3, 7, 5);
		List<Integer> L2 = List.of(6, 8, 4, 2, 8);

		Function<Integer, String> numeroATexto = num -> {
			List<String> numeros = List.of("desconocido", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete",
					"ocho", "nueve", "cero");
			return (num >= 0 && num < numeros.size()) ? numeros.get(num) : "desconocido";
		};

		List<Pair<String, String>> resultado = generarTuplas(L1, L2, numeroATexto, numeroATexto);

		System.out.println("Resultado: " + resultado);
	}
}
