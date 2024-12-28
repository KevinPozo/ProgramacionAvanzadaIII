package PolimorficaEJ2;

import java.util.function.Function;

public class AppPolimorfica {
	// Función de orden superior para componer dos funciones
    public static <T, R, V> Function<T, V> componerFunciones(Function<T, R> f1, Function<R, V> f2) {
        return x -> f2.apply(f1.apply(x));
    }
    public static void main(String[] args) {
		// --------------------------------------------------------------
    	// Ejemplo 1: Componer funciones para duplicar y luego sumar 5:
        Function<Integer, Integer> duplicar = x -> x * 2;
        Function<Integer, Integer> sumarCinco = x -> x + 5;
        Function<Integer, Integer> duplicarYSumarCinco = componerFunciones(duplicar, sumarCinco);
        int resultado1 = duplicarYSumarCinco.apply(3);
        System.out.println("Resultado de duplicar y sumar cinco: " + resultado1); 
		// --------------------------------------------------------------
        // Ejemplo 2: Componer funciones para convertir a cadena y agregar prefijo
        Function<Integer, String> aCadena = x -> "Número: " + x;
        Function<String, String> agregarPrefijo = s -> "[Transformado] " + s;
        Function<Integer, String> transformarConPrefijo = componerFunciones(aCadena, agregarPrefijo);
        String resultado2 = transformarConPrefijo.apply(10);
        System.out.println("Resultado con prefijo: " + resultado2); 
		// --------------------------------------------------------------
        // Ejemplo 3: Componer funciones para calcular la longitud de un texto y luego duplicar el resultado
        Function<String, Integer> longitudTexto = String::length;
        Function<Integer, Integer> duplicarLongitud = x -> x * 2;
        Function<String, Integer> longitudDuplicada = componerFunciones(longitudTexto, duplicarLongitud);
        int resultado3 = longitudDuplicada.apply("Java");
        System.out.println("Longitud duplicada: " + resultado3); 
    }
}
