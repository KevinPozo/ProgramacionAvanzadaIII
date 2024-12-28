package PredicateEJ1;

import java.util.ArrayList;
import java.util.List;

public class AppPredicate {
    // Función genérica que filtra una lista usando la interfaz Filtro
	public static <T> List<T> filtrarLista(List<T> lista, Filtro<T> filtro) {
		List<T> resultado = new ArrayList<>();
		for (T elemento : lista) {
			if (filtro.aplicar(elemento)) {
				resultado.add(elemento);
			}
		}
		return resultado;
	}

	public static void main(String[] args) {
		List<String> palabras = List.of("Pneumonoultramicroscopicsilicovolcanoconiosis",
				"Floccinaucinihilipilification", "Antidisestablishmentarianism", "Hippopotomonstrosesquipedaliophobia",
				"Supercalifragilisticexpialidocious", "Incomprehensibilities");
		// --------------------------------------------------------------
		// Ejemplo 1: Filtrar palabras con:
		Filtro<String> masDeCuatroCaracteres = new Filtro<>() {
			@Override
			public boolean aplicar(String palabra) {
				return palabra.length() > 4;
			}
		};
		List<String> palabrasFiltradas1 = filtrarLista(palabras, masDeCuatroCaracteres);
		System.out.println("Palabras con más de 4 caracteres: " + palabrasFiltradas1);
		// --------------------------------------------------------------
		// Ejemplo 2: Filtrar palabras que empiezan con:
		Filtro<String> empiezaConP = new Filtro<>() {
			@Override
			public boolean aplicar(String palabra) {
				return palabra.startsWith("P");
			}
		};
		List<String> palabrasConP = filtrarLista(palabras, empiezaConP);
		System.out.println("Palabras que empiezan con 'P': " + palabrasConP);
		// --------------------------------------------------------------
		// Ejemplo 3: Filtrar palabras que contienen la letra:
		Filtro<String> contieneB = new Filtro<>() {
			@Override
			public boolean aplicar(String palabra) {
				return palabra.toLowerCase().contains("b");
			}
		};
		List<String> palabrasConB = filtrarLista(palabras, contieneB);
		System.out.println("Palabras que contienen la letra 'b': " + palabrasConB);
		// --------------------------------------------------------------
		// Ejemplo 4: Filtrar palabras que terminan con la letra:
		Filtro<String> terminaConA = new Filtro<>() {
			@Override
			public boolean aplicar(String palabra) {
				return palabra.endsWith("a");
			}
		};
		List<String> palabrasTerminadasEnA = filtrarLista(palabras, terminaConA);
		System.out.println("Palabras que terminan con la letra 'a': " + palabrasTerminadasEnA);
		// --------------------------------------------------------------
	}

}
