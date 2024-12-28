package PolimorficaEJ1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AppPolimorfica {
    // Función genérica que transforma una lista
	public static <T, R> List<R> transformarLista(List<T> lista, Transformador<T, R> funcion) {
		List<R> resultado = new ArrayList<>();
		for (T elemento : lista) {
			resultado.add(funcion.aplicar(elemento));
		}
		return resultado;
	}

	public static void main(String[] args) {
		List<Integer> numeros = List.of(3, 5, 2, 10, 40);
		// --------------------------------------------------------------
		// Ejemplo 1: Transformar una lista de enteros a:
		Transformador<Integer, Integer> doble = x -> x * 2;
		List<Integer> numerosDoblados = transformarLista(numeros, doble);
		System.out.println("Números doblados: " + numerosDoblados);
		Transformador<Integer, Integer> triple = x -> x * 3;
		List<Integer> numerosTriples = transformarLista(numeros, triple);
		System.out.println("Números triples: " + numerosTriples);
		Transformador<Integer, Integer> cuadruple = x -> x * 4;
		List<Integer> numerosCuadruples = transformarLista(numeros, cuadruple);
		System.out.println("Números cuadruples: " + numerosCuadruples);
		Transformador<Integer, Double> divisionDos = x -> (double) x / 2;
		List<Double> numerosDivididos = transformarLista(numeros, divisionDos);
		System.out.println("Números divididos entre dos: " + numerosDivididos);
		// --------------------------------------------------------------
		// Ejemplo 2: Transformar una lista de enteros a:
		Transformador<Integer, String> aCadena = x -> "Número: " + x;
		List<String> cadenas = transformarLista(numeros, aCadena);
		System.out.println("Números como cadenas: " + cadenas);
		// --------------------------------------------------------------
		// Ejemplo 3: Transformar una lista de cadenas a:
		List<String> palabras = List.of("Kevin", "Pozo", "Fernando");
		Transformador<String, Integer> longitudes = String::length;
		List<Integer> longitudesPalabras = transformarLista(palabras, longitudes);
		System.out.println("Longitudes de palabras: " + longitudesPalabras);
		Transformador<String, String> aMayusculas = String::toUpperCase;
		List<String> nombresMayusculas = transformarLista(palabras, aMayusculas);
		System.out.println("Nombres en mayúsculas: " + nombresMayusculas);
		Transformador<String, String> agregarPrefijo = nombre -> "Sr. " + nombre;
		List<String> nombresConPrefijo = transformarLista(palabras, agregarPrefijo);
		Transformador<String, String> invertir = nombre -> new StringBuilder(nombre).reverse().toString();
		List<String> nombresInvertidos = transformarLista(palabras, invertir);
		System.out.println("Nombres invertidos: " + nombresInvertidos);
		Transformador<String, String> aMinusculas = String::toLowerCase;
		List<String> nombresMinusculas = transformarLista(palabras, aMinusculas);
		System.out.println("NOmbres en minusculas: " + nombresMinusculas);
		// --------------------------------------------------------------
	}
}
