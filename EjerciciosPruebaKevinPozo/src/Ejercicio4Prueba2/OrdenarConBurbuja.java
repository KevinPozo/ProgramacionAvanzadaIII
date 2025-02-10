package Ejercicio4Prueba2;

import java.util.ArrayList;
import java.util.List;

public class OrdenarConBurbuja {

	public static int encontrarMinimo(List<Integer> lista) {
		return encontrarMinimoRecursivo(lista, Integer.MAX_VALUE);
	}

	private static int encontrarMinimoRecursivo(List<Integer> lista, int min) {
		if (lista.isEmpty()) {
			return min;
		}

		int nuevoMin = Math.min(min, lista.get(0));
		return encontrarMinimoRecursivo(lista.subList(1, lista.size()), nuevoMin);
	}

	public static List<Integer> ordenarBurbuja(List<Integer> lista) {
		if (lista.size() <= 1) {
			return lista;
		}

		List<Integer> listaModificada = burbujaRecursiva(lista, 0);

		List<Integer> listaOrdenada = ordenarBurbuja(listaModificada.subList(0, listaModificada.size() - 1));

		List<Integer> resultado = new ArrayList<>(listaOrdenada);
		resultado.add(listaModificada.get(listaModificada.size() - 1));

		return resultado;
	}

	private static List<Integer> burbujaRecursiva(List<Integer> lista, int index) {
		if (index == lista.size() - 1) {
			return lista;
		}

		if (lista.get(index) > lista.get(index + 1)) {
			List<Integer> listaModificada = new ArrayList<>(lista);
			int temp = listaModificada.get(index);
			listaModificada.set(index, listaModificada.get(index + 1));
			listaModificada.set(index + 1, temp);
			return burbujaRecursiva(listaModificada, index + 1);
		}
		return burbujaRecursiva(lista, index + 1);
	}

	public static List<Integer> ordenarConMinimoAlInicio(List<Integer> lista) {
		int minimo = encontrarMinimo(lista);
		List<Integer> listaSinMinimo = sublistaSinMaximo(lista);
		List<Integer> listaOrdenada = ordenarBurbuja(listaSinMinimo);
		List<Integer> resultado = new ArrayList<>();
		resultado.add(minimo);
		resultado.addAll(listaOrdenada);
		return resultado;
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
		System.out.println("Lista ordenada: " + ordenarConMinimoAlInicio(lista));
	}
}
