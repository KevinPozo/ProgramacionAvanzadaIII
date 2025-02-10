package Ejercicio2Prueba1;

import java.util.ArrayList;
import java.util.List;

public class SumarBinarios {

	public static List<Integer> sumarBinarios(List<Integer> lista1, List<Integer> lista2) {
		int maxLength = Math.max(lista1.size(), lista2.size());
		List<Integer> lista1Ajustada = ajustarLongitud(lista1, maxLength);
		List<Integer> lista2Ajustada = ajustarLongitud(lista2, maxLength);

		return sumarBinariosRecursivo(lista1Ajustada, lista2Ajustada, 0);
	}

	private static List<Integer> sumarBinariosRecursivo(List<Integer> lista1, List<Integer> lista2, int carry) {

		if (lista1.isEmpty() && lista2.isEmpty() && carry == 0) {
			return new ArrayList<>();
		}

		int suma = (lista1.isEmpty() ? 0 : lista1.get(0)) + (lista2.isEmpty() ? 0 : lista2.get(0)) + carry;
		int nuevoDigito = suma % 2;
		int nuevoCarry = suma / 2;

		List<Integer> resultado = sumarBinariosRecursivo(
				lista1.isEmpty() ? new ArrayList<>() : lista1.subList(1, lista1.size()),
				lista2.isEmpty() ? new ArrayList<>() : lista2.subList(1, lista2.size()), nuevoCarry);

		resultado.add(0, nuevoDigito);

		return resultado;
	}

	private static List<Integer> ajustarLongitud(List<Integer> lista, int longitud) {
		if (lista.size() >= longitud) {
			return lista;
		}

		List<Integer> listaAjustada = new ArrayList<>();
		listaAjustada.add(0);
		listaAjustada.addAll(lista);

		return ajustarLongitud(listaAjustada, longitud);
	}

	public static void main(String[] args) {
		List<Integer> lista1a = List.of(1, 1, 1, 1, 0);
		List<Integer> lista2a = List.of(1, 0, 1, 1);
		System.out.println("Suma a: " + sumarBinarios(lista1a, lista2a));

		List<Integer> lista1b = List.of(1, 0, 1, 1);
		List<Integer> lista2b = List.of(1, 1, 1, 1, 0);
		System.out.println("Suma b: " + sumarBinarios(lista1b, lista2b));
	}
}
