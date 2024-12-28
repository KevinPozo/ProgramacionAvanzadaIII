package Main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		System.out.println("----------------------");
		System.out.println("POO:");
		// POO:
		// --------------------------------------------
		// 1: Ejemplo con un autor y un libro
		System.out.println("----------------------");
		Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano");
		Libro libro1 = new Libro("Cien años de soledad", autor1, "978-3-16-148410-0", 1967);
		Libro libro2 = new Libro("El amor en los tiempos del cólera", autor1, "978-84-376-0494-7", 1985);
		Libro libro3 = new Libro("Crónica de una muerte anunciada", autor1, "978-84-376-0495-4", 1981);

		autor1.agregarLibro(libro1);
		autor1.agregarLibro(libro2);
		autor1.agregarLibro(libro3);

		Editorial editorial1 = new Editorial("Editorial Sudamericana", "Buenos Aires");
		editorial1.agregarLibro(libro1);
		editorial1.agregarLibro(libro2);
		editorial1.agregarLibro(libro3);

		System.out.println(libro1);
		System.out.println("Libros escritos por " + autor1.getNombre() + ":");
		for (Libro libro : autor1.getLibrosEscritos()) {
			System.out.println(libro.getTitulo());
		}

		// 2: Ejemplo con otro autor y más libros
		Autor autor2 = new Autor("Julio Cortázar", "Argentino");
		Libro libro4 = new Libro("Rayuela", autor2, "978-84-663-1043-3", 1963);
		Libro libro5 = new Libro("Final del juego", autor2, "978-84-663-1044-0", 1956);

		autor2.agregarLibro(libro4);
		autor2.agregarLibro(libro5);

		Editorial editorial2 = new Editorial("Editorial Alfaguara", "Madrid");
		editorial2.agregarLibro(libro4);
		editorial2.agregarLibro(libro5);

		System.out.println("\n" + libro4);
		System.out.println("Libros escritos por " + autor2.getNombre() + ":");
		for (Libro libro : autor2.getLibrosEscritos()) {
			System.out.println(libro.getTitulo());
		}

		// 3: Ejemplo con dos autores y tres libros compartidos entre ellos
		Autor autor3 = new Autor("Isabel Allende", "Chilena");
		Autor autor4 = new Autor("Pablo Neruda", "Chileno");

		Libro libro6 = new Libro("La casa de los espíritus", autor3, "978-84-663-1045-7", 1982);
		Libro libro7 = new Libro("Cien sonetos de amor", autor4, "978-84-663-1046-4", 1959);
		Libro libro8 = new Libro("Los cuentos de Eva Luna", autor3, "978-84-663-1047-1", 1989);

		autor3.agregarLibro(libro6);
		autor3.agregarLibro(libro8);
		autor4.agregarLibro(libro7);

		Editorial editorial3 = new Editorial("Editorial Plaza & Janés", "Barcelona");
		editorial3.agregarLibro(libro6);
		editorial3.agregarLibro(libro7);
		editorial3.agregarLibro(libro8);

		System.out.println("\n" + libro6);
		System.out.println("Libros escritos por " + autor3.getNombre() + ":");
		for (Libro libro : autor3.getLibrosEscritos()) {
			System.out.println(libro.getTitulo());
		}

		System.out.println("\n" + libro7);
		System.out.println("Libros escritos por " + autor4.getNombre() + ":");
		for (Libro libro : autor4.getLibrosEscritos()) {
			System.out.println(libro.getTitulo());
		}
		// --------------------------------------------
		System.out.println("----------------------");
		System.out.println("Programación Funcional: ");
		System.out.println("----------------------");
		// Programación Funcional:
		// 1: Factorial
		List<Integer> numeros = Arrays.asList(1, 16, 81, 36);

		Transformacion factorial = n -> {
			int resultado = 1;
			for (int i = 1; i <= n; i++) {
				resultado *= i;
			}
			return resultado;
		};

		List<Integer> resultadosFactorial = numeros.stream().map(factorial::aplicar)
				.peek(n -> System.out.println("Después de calcular el factorial: " + n)).filter(n -> n % 5 == 0)
				.peek(n -> System.out.println("Después de filtrar múltiplos de 5: " + n)).collect(Collectors.toList());

		System.out.println("\nResultados finales (Factorial y múltiplos de 5):");
		resultadosFactorial.forEach(System.out::println);
		// 2: Potencia de n valor
		int potencia = 3;
		Transformacion elevarAPotencia = n -> (int) Math.pow(n, potencia);

		List<Integer> resultadosPotencia = numeros.stream().map(elevarAPotencia::aplicar)
				.peek(n -> System.out.println("Después de elevar a la potencia " + potencia + ": " + n))
				.filter(n -> n > 10).peek(n -> System.out.println("Después de filtrar > 10: " + n))
				.collect(Collectors.toList());

		System.out.println("\nResultados finales (Potencia " + potencia + " > 10):");
		resultadosPotencia.forEach(System.out::println);
		// 3: Raiz de n valor
		int indiceRaiz = 2;
		Transformacion calcularRaiz = n -> (int) Math.pow(n, 1.0 / indiceRaiz);

		List<Integer> resultadosRaiz = numeros.stream().map(calcularRaiz::aplicar)
				.peek(n -> System.out.println("Después de calcular la raíz de índice " + indiceRaiz + ": " + n))
				.filter(n -> n % 2 != 0).peek(n -> System.out.println("Después de filtrar números impares: " + n))
				.collect(Collectors.toList());

		System.out.println("\nResultados finales (Raíz de índice " + indiceRaiz + " e impares):");
		resultadosRaiz.forEach(System.out::println);
		// --------------------------------------------
		System.out.println("----------------------");
		System.out.println("Closure:");
		System.out.println("----------------------");
		// Closure:
		// 1: Función Acumuladora con descuento
		final double[] totalConDescuento = { 0 };
		double descuento = 5.0;

		Acumulador acumuladorConDescuento = valor -> {
			totalConDescuento[0] += valor;
			totalConDescuento[0] -= descuento;
			return (int) totalConDescuento[0];
		};

		System.out.println("Total acumulado con descuento: " + acumuladorConDescuento.acumular(100));
		System.out.println("Total acumulado con descuento: " + acumuladorConDescuento.acumular(50));
		System.out.println("Total acumulado con descuento: " + acumuladorConDescuento.acumular(30));

		// 2: Función Acumuladora que tiene siempre el valor máximo
		final int[] maxValor = { Integer.MIN_VALUE };

		Acumulador acumuladorMaximo = valor -> {
			if (valor > maxValor[0]) {
				maxValor[0] = valor;
			}
			return maxValor[0];
		};

		System.out.println("Valor máximo: " + acumuladorMaximo.acumular(50));
		System.out.println("Valor máximo: " + acumuladorMaximo.acumular(100));
		System.out.println("Valor máximo: " + acumuladorMaximo.acumular(75));
		// 3: Función Acumuladora con numeros pares
		final int[] totalPares = { 0 };

		Acumulador acumuladorPares = valor -> {
			if (valor % 2 == 0) {
				totalPares[0] += valor;
			}
			return totalPares[0];
		};

		System.out.println("Total acumulado (pares): " + acumuladorPares.acumular(50));
		System.out.println("Total acumulado (pares): " + acumuladorPares.acumular(30));
		System.out.println("Total acumulado (pares): " + acumuladorPares.acumular(15));
		System.out.println("----------------------");
		System.out.println("Currying:");
		System.out.println("----------------------");
		// --------------------------------------------
		//Currying:
		// 1: Sumar dos valores
        Function<Integer, Function<Integer, Function<Integer, Integer>>> sumaF = a -> b -> c -> a + b + c;
        int resultadoSuma = sumaF.apply(5).apply(10).apply(15);  
        System.out.println("Resultado de la suma: " + resultadoSuma);

		// 2: Multiplicar dos valores
        Function<Integer, Function<Integer, Function<Integer, Integer>>> multiplicarF = a -> b -> c -> a * b * c;
        int resultadoMultiplicacion = multiplicarF.apply(2).apply(3).apply(4); 
        System.out.println("Resultado de la multiplicación: " + resultadoMultiplicacion);

		// 3: Potencia de un número
		Function<Integer, Function<Integer, Integer>> potenciaF = base -> exponente -> (int) Math.pow(base, exponente);

		int resultadoPotencia = potenciaF.apply(2).apply(3);
		System.out.println("Resultado de la potencia: " + resultadoPotencia);
		// --------------------------------------------
	}

}
