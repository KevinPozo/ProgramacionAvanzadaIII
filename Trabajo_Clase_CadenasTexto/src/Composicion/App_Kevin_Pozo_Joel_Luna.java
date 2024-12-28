package Composicion;

//Nombre: Kevin Pozo - Joel Luna
//Programacion Avanzada III
//Carrera: Computación

//Interfaz funcional para manipular cadenas de texto
@FunctionalInterface
interface StringFunction {
	String apply(String input);
}

public class App_Kevin_Pozo_Joel_Luna {
	// Función para convertir una cadena a mayúsculas
	public static String toUpperCase(String input) {
		return input.toUpperCase();
	}

	// Función para quitar los espacios en blanco de una cadena
	public static String removeSpaces(String input) {
		return input.replace(" ", "");
	}

	// Función para reemplazar los espacios en blanco por guiones
	public static String replaceSpacesWithHyphens(String input) {
		return input.replace(" ", "-");
	}

	// Método para componer dos funciones de tipo StringFunction
	public static StringFunction compose(StringFunction f, StringFunction g) {
		return new StringFunction() {
			@Override
			public String apply(String input) {
				return f.apply(g.apply(input));
			}
		};
	}

	public static void main(String[] args) {
		// Aplicación:
		String cadena = "Los hombres quieren volar, pero temen al vacio. No pueden vivir sin certezas. Por eso cambian el vuelo por jaulas. Las jaulas son el lugar donde viven las certezas";

		System.out.println(">> Original: [" + cadena + "]");
		System.out.println(">> Mayúsculas: [" + toUpperCase(cadena) + "]");
		System.out.println(">> Sin espacios: [" + removeSpaces(cadena) + "]");
		System.out.println(">> Con guiones: [" + replaceSpacesWithHyphens(cadena) + "]");

		// Creación de funciones usando interfaces funcionales
		StringFunction toUpper = new StringFunction() {
			@Override
			public String apply(String input) {
				return toUpperCase(input);
			}
		};

		StringFunction removeSpaces = new StringFunction() {
			@Override
			public String apply(String input) {
				return removeSpaces(input);
			}
		};

		StringFunction replaceSpacesWithHyphens = new StringFunction() {
			@Override
			public String apply(String input) {
				return replaceSpacesWithHyphens(input);
			}
		};

		// Composición de funciones
		StringFunction upperThenRemoveSpaces = compose(removeSpaces, toUpper);
		StringFunction removeSpacesThenReplace = compose(replaceSpacesWithHyphens, removeSpaces);

		System.out.println(">> Mayúsculas y luego quitar espacios: [" + upperThenRemoveSpaces.apply(cadena) + "]");
		System.out.println(
				">> Quitar espacios y luego reemplazar por guiones: [" + removeSpacesThenReplace.apply(cadena) + "]");
	}
}
