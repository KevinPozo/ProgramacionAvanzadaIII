//Nombre: Kevin Fernando Pozo Maldonado
//Curso: C7-001
//Fecha: 2025/01/27
package DeberEnClase;

public class Main {
	public static void main(String[] args) {
		Lista<Integer> lista = Lista.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Integer sumaLeft = lista.fold(0, x -> acc -> x + acc, true);
		System.out.println("Suma usando foldLeft: " + sumaLeft);

		Integer productoRight = lista.fold(1, x -> acc -> x * acc, false);
		System.out.println("Producto usando foldRight: " + productoRight);

		Integer maximo = lista.fold(Integer.MIN_VALUE, x -> acc -> Math.max(x, acc), true);
		System.out.println("Máximo elemento: " + maximo);

		Integer minimo = lista.fold(Integer.MAX_VALUE, x -> acc -> Math.min(x, acc), true);
		System.out.println("Mínimo elemento: " + minimo);

		String concatenacion = lista.fold("", x -> acc -> x + (acc.isEmpty() ? "" : ", " + acc), false);
		System.out.println("Concatenación de elementos: " + concatenacion);

		Integer cantidad = lista.fold(0, x -> acc -> acc + 1, true);
		System.out.println("Cantidad de elementos: " + cantidad);

		Integer factorial = lista.fold(1, x -> acc -> x * acc, false);
		System.out.println("Factorial del primer elemento: " + factorial);

		Integer sumaCuadrados = lista.fold(0, x -> acc -> acc + (x * x), true);
		System.out.println("Suma de cuadrados: " + sumaCuadrados);
	}

}
