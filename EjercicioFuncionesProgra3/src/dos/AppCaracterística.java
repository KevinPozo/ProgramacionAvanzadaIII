package dos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AppCaracterística {
	public static void main(String[] args) {
		Operaciones op = new Operaciones();
		System.out.println("Suma: " + op.sumar(3, 2));
		System.out.println("Elevar: " + op.potencia(2, 2));
		System.out.println("Multiplicar: " + op.multiplicar(2, 2));
		System.out.println("----------------------------");
		int count = 0;
		List<Persona> persona = Arrays.asList(new Persona("Ana", 25), new Persona("Pedro", 14),
				new Persona("Andrade", 17), new Persona("Carlos", 27));
		// POO:
		System.out.println("POO:");
		for (var it : persona) {
			if (it.getEdad() > 18) {
				System.out.println(it);
				count++;
			}
		}
		System.out.println("(POO)Personas mayores a 18: " + count);
		System.out.println("----------------------");
		// PROGRA Funcional:
		System.out.println("Programación Funcional");
		long contar = persona.stream().filter(p -> p.getEdad() > 18).peek(System.out::println).count();
		System.out.println("(PF)Personas mayores a 18: " + contar);
		System.out.println("----------------------");
		// CLosures:
		System.out.println("Closures:");
		int f = 7;
		Operacion suma = a -> a + f;
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println(f);

			}
		};
		System.out.println("Suma Closure: ");
		runnable.run();
		System.out.println("----------------------");
		// Currying:
		System.out.println("Currying:");
		Function<Integer, Function<Integer, Integer>> sumarF = a -> b -> a + b;
		Function<Integer, Integer> sumarUno = sumarF.apply(5);
		int respuesta = sumarUno.apply(3);
		System.out.println("Suma Currying:");
		System.out.println(respuesta);
		// otra forma de hacerlo:
		BiFunction<Integer, Integer, Integer> sumaBi = (a, b) -> a + b;
		Function<Integer, Integer> sumaUno = a -> sumaBi.apply(2, a);
		int respuestaBi = sumaUno.apply(9);
		System.out.println("respuestaBI: " + respuestaBi);

		Function<Integer, Function<Integer, Function<Integer, Integer>>> multiplicarF = a -> b -> c -> a * b * c;
		int resultadoMultiplicacion = multiplicarF.apply(2).apply(3).apply(4);
		System.out.println("Resultado de la multiplicación: " + resultadoMultiplicacion);
	}

}
