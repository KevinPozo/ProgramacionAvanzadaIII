package Ejercicio4Prueba1;

import java.util.ArrayList;
import java.util.List;

public class FoldingTuplas {

	public static class Par<A, B> {
		private A first;
		private B second;

		public Par(A first, B second) {
			this.first = first;
			this.second = second;
		}

		public A getFirst() {
			return first;
		}

		public B getSecond() {
			return second;
		}
	}

	public static <A, B> void separarListas(List<Par<A, B>> listaTuplas, List<A> lista1, List<B> lista2) {
		separarListasRecursivo(listaTuplas, lista1, lista2);
	}

	private static <A, B> void separarListasRecursivo(List<Par<A, B>> listaTuplas, List<A> lista1, List<B> lista2) {
		if (listaTuplas.isEmpty()) {
			return;
		}

		Par<A, B> par = listaTuplas.get(0);

		lista1.add(par.getFirst());
		lista2.add(par.getSecond());

		separarListasRecursivo(listaTuplas.subList(1, listaTuplas.size()), lista1, lista2);
	}

	public static Integer convertirATexto(String texto) {
		List<String> numeros = List.of("uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
				"cero");
		return convertirATextoRecursivo(texto, numeros, 0);
	}

	private static Integer convertirATextoRecursivo(String texto, List<String> numeros, int index) {
		if (index >= numeros.size()) {
			return 0;
		}
		return texto.equals(numeros.get(index)) ? index : convertirATextoRecursivo(texto, numeros, index + 1);
	}

	public static void main(String[] args) {
		List<Par<String, String>> listaTuplas = List.of(new Par<>("tres", "seis"), new Par<>("dos", "ocho"),
				new Par<>("tres", "cuatro"), new Par<>("siete", "dos"), new Par<>("cinco", "ocho"));

		List<String> L1 = new ArrayList<>();
		List<String> L2 = new ArrayList<>();

		separarListas(listaTuplas, L1, L2);

		List<Integer> L1Numeros = convertirListaATextoRecursivo(L1, 0, new ArrayList<>());
		List<Integer> L2Numeros = convertirListaATextoRecursivo(L2, 0, new ArrayList<>());

		System.out.println("Lista original L1: " + L1Numeros);
		System.out.println("Lista original L2: " + L2Numeros);
	}

	private static List<Integer> convertirListaATextoRecursivo(List<String> lista, int index, List<Integer> resultado) {
		if (index >= lista.size()) {
			return resultado;
		}

		resultado.add(convertirATexto(lista.get(index)));
		return convertirListaATextoRecursivo(lista, index + 1, resultado);
	}
}
