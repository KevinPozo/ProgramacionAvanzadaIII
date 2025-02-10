package Ejercicio3Prueba2;

import java.util.ArrayList;
import java.util.List;

public class SublistaSinMaximo {

	public static int encontrarMaximo(List<Integer> lista) {
		return encontrarMaximoRecursivo(lista, 0, Integer.MIN_VALUE);
	}

	private static int encontrarMaximoRecursivo(List<Integer> lista, int index, int max) {
		if (index == lista.size()) {
			return max;
		}
		int nuevoMax = Math.max(max, lista.get(index));
		return encontrarMaximoRecursivo(lista, index + 1, nuevoMax);
	}

	public static List<Integer> sublistaSinMaximo(List<Integer> lista) {
		int maximo = encontrarMaximo(lista);
		return sublistaSinMaximoRecursivo(lista, maximo);
	}

	private static List<Integer> sublistaSinMaximoRecursivo(List<Integer> lista, int max) {
		if (lista.isEmpty()) {
			return new ArrayList<>();
		}

		int primerElemento = lista.get(0);
		List<Integer> subListaRestante = sublistaSinMaximoRecursivo(lista.subList(1, lista.size()), max);

		if (primerElemento != max) {
			subListaRestante.add(0, primerElemento);
		}
		return subListaRestante;
	}

	public static void main(String[] args) {
		List<Integer> lista = List.of(4, 6, 2, 3, 8);
		System.out.println("La sublista sin el máximo es: " + sublistaSinMaximo(lista));
	}
}
