package PredicateEJ2;

import java.util.List;

public class AppPredicate {
    // Método genérico que verifica si todos los elementos de la lista cumplen con una condición
    public static <T> boolean verificarCondicionParaTodos(List<T> lista, Filtro<T> condicion) {
        for (T elemento : lista) {
            if (!condicion.aplicar(elemento)) {
                return false; 
            }
        }
        return true;
    }

    public static void main(String[] args) {
		// --------------------------------------------------------------
        // Ejemplo 1: Verificar si todos los números son positivos
        List<Integer> numeros = List.of(10, 20, 30, 40, 50);
        Filtro<Integer> esPositivo = x -> x > 0;
        boolean todosPositivos = verificarCondicionParaTodos(numeros, esPositivo);
        System.out.println("Todos los números son positivos: " + todosPositivos); 
		// --------------------------------------------------------------
        // Ejemplo 2: Verificar si todas las palabras tienen más de 3 caracteres
        List<String> palabras = List.of("Java", "Predicate", "Stream");
        Filtro<String> masDeTresCaracteres = palabra -> palabra.length() > 3;
        boolean todasCumplenLongitud = verificarCondicionParaTodos(palabras, masDeTresCaracteres);
        System.out.println("Todas las palabras tienen más de 3 caracteres: " + todasCumplenLongitud); 
		// --------------------------------------------------------------
        // Ejemplo 3: Verificar si todos los números son pares
        List<Integer> numerosMixtos = List.of(2, 4, 6, 7, 8);
        Filtro<Integer> esPar = x -> x % 2 == 0;
        boolean todosPares = verificarCondicionParaTodos(numerosMixtos, esPar);
        System.out.println("Todos los números son pares: " + todosPares); 
		// --------------------------------------------------------------
        // Ejemplo 4: Verificar si todas las palabras comienzan con una letra mayúscula
        List<String> palabrasVariadas = List.of("Hola", "Mundo", "java");
        Filtro<String> comienzaConMayuscula = palabra -> Character.isUpperCase(palabra.charAt(0));
        boolean todasMayuscula = verificarCondicionParaTodos(palabrasVariadas, comienzaConMayuscula);
        System.out.println("Todas las palabras comienzan con mayúscula: " + todasMayuscula); 
		// --------------------------------------------------------------
    }
}
