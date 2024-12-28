package ordensup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class AppMascota {
//Nombre: Kevin Fernando Pozo Maldonado
//EJERCICIO EN CLASE MASCOTAS FUNCIONES GENÉRICAS
	public static List<Mascota> list = Arrays.asList(new Mascota(2, "Luna", "Golden Retriever"),
			new Mascota(5, "Max", "Labrador"), new Mascota(1, "Bella", "Poodle"), new Mascota(4, "Charlie", "Bulldog"),
			new Mascota(3, "Rocky", "Beagle"));

	// Método para imprimir los nombres de las mascotas
	public static List<String> imprimir(List<Mascota> mascotas) {
		List<String> nombres = new ArrayList<>();
		for (Mascota mascota : mascotas) {
			nombres.add(mascota.getNombre());
		}
		return nombres;
	}

	// Método para calcular la edad promedio de las mascotas
	public static double promedio(List<Mascota> mascotas) {
		int totalEdad = mascotas.stream().mapToInt(Mascota::getEdad).sum();
		return (double) totalEdad / mascotas.size();
	}

	// Método genérico para operar sobre las mascotas
	public static <T> T reducir(T startValue, Function<Mascota, T> fn, BinaryOperator<T> op) {
		T total = startValue;
		for (Mascota mascota : list) {
			T value = fn.apply(mascota);
			total = op.apply(total, value);
		}
		return total;
	}

	public static void main(String[] args) {
		// Imprimir los nombres
		System.out.println("Nombres de las mascotas:");
		List<String> nombres = imprimir(list);
		nombres.forEach(System.out::println);

		// Calcular la edad promedio
		System.out.println("\nEdad promedio:");
		System.out.println(promedio(list));

		// Reducir para calcular el total de edad
		System.out.println("\nTotal de edad:");
		int totalEdad = reducir(0, Mascota::getEdad, Integer::sum);
		System.out.println(totalEdad);

		// Reducir para concatenar los nombres
		System.out.println("\nConcatenación de nombres:");
		String nombresConcatenados = reducir("", Mascota::getNombre, (a, b) -> a + ", " + b);
		System.out.println(nombresConcatenados);

		// Salida funcional para nombres en mayúsculas
		System.out.println("\nNombres en mayúsculas (funcional):");
		list.stream().map(Mascota::getNombre).map(String::toUpperCase).forEach(System.out::println);
	}
}
