package Ejercicio2Prueba2;

import java.util.List;

public class MinimoFoldingDerecha {

	public static int encontrarMinimo(List<Integer> lista) {
		return lista.stream().reduce((a, b) -> a < b ? a : b).get();
	}

	public static void main(String[] args) {
		List<Integer> lista = List.of(4, 6, 2, 3, 8);
		System.out.println("El mínimo es: " + encontrarMinimo(lista));
	}
}
