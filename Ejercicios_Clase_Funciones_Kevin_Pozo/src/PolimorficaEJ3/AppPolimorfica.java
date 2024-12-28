package PolimorficaEJ3;

import java.util.List;
import java.util.function.BiFunction;

public class AppPolimorfica {
    // Método genérico que combina todos los elementos de una lista usando una operación
    public static <T> T combinarLista(List<T> lista, T identidad, BiFunction<T, T, T> operacion) {
        T resultado = identidad;
        for (T elemento : lista) {
            resultado = operacion.apply(resultado, elemento);
        }
        return resultado;
    }

    public static void main(String[] args) {
        // --------------------------------------------------------------
        // Ejemplo 1: Sumar todos los números de una lista
        List<Integer> numeros = List.of(4, 7, 12, 21, 45, 67, 98);
        int suma = combinarLista(numeros, 0, (a, b) -> a + b);
        System.out.println("Suma de los números: " + suma);
        // --------------------------------------------------------------
        // Ejemplo 2: Multiplicar todos los números de una lista
        int producto = combinarLista(numeros, 1, (a, b) -> a * b);
        System.out.println("Producto de los números: " + producto);
        // --------------------------------------------------------------
        // Ejemplo 3: Concatenar una lista de cadenas
        List<String> palabras = List.of("Love", "Linux", "Mint", "🐧", "");
        String oracion = combinarLista(palabras, "", (a, b) -> a + " " + b).trim();
        System.out.println("Frase concatenada (Strings): " + oracion);
        // --------------------------------------------------------------
        // Ejemplo 4: Encontrar el máximo valor en una lista
        List<Double> valores = List.of(13.5, 23.4, 45.9, 12.98, 23.45);
        double maximo = combinarLista(valores, Double.NEGATIVE_INFINITY, (a, b) -> a > b ? a : b);
        System.out.println("Valor máximo: " + maximo);
        // --------------------------------------------------------------
    }
}
