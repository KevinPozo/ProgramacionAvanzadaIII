package Ejercicio1Prueba1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumarDigito {

	public static List<Integer> sumarDigito(List<Integer> lista, int digito) {
		return lista.isEmpty() ? (digito == 0 ? new ArrayList<>() : List.of(digito))
				: sumarDigitoRecursivo(lista, digito, 0);
	}

	private static List<Integer> sumarDigitoRecursivo(List<Integer> lista, int digito, int carry) {
		return lista.isEmpty() ? (carry == 0 ? new ArrayList<>() : List.of(carry))
				: sumarDigitoRecursivo(lista.subList(1, lista.size()), digito, (lista.get(0) + digito + carry) / 2)
						.stream().collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
							result.add(0, (lista.get(0) + digito + carry) % 2);
							return result;
						}));
	}

	public static void main(String[] args) {
		List<Integer> lista = List.of(1, 1, 1, 1, 0);
		List<Integer> lista2 = List.of(1, 0, 1, 1);
		int digito = 4;

		List<Integer> resultado = sumarDigito(lista, digito);
		System.out.println("Resultado: " + resultado);
		List<Integer> resultado2 = sumarDigito(lista2, digito);
		System.out.println("Resultado: " + resultado2);
	}
}
