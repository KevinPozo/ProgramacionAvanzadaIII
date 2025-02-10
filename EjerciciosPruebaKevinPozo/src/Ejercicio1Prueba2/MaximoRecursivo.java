package Ejercicio1Prueba2;

import java.util.List;

public class MaximoRecursivo {

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

	public static void main(String[] args) {
		List<Integer> lista = List.of(4, 6, 2, 3, 8);
		System.out.println("El máximo es: " + encontrarMaximo(lista));
	}
}
