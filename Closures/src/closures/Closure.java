package closures;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Closure {
	// Closure es el contexto donde se encierra la función:
	// en C++ se define que cosas quiero que sean visibles
	// en Java se define por defecto todo lo visible
	// static int x = 3;
	static final int x = 3;
	static double taxRate = 0.09;

	public static void main(String[] args) {
		// int x = 3;
		Function<Integer, Integer> f = p -> p * 3 + x;
		BiFunction<Integer, Integer, Integer> f2 = (p, q) -> p * 3 + q;
		System.out.println("Sin cambio: " + f.apply(5));
		System.out.println("BIFunction: " + f2.apply(x, 3));
		// x = 10;
		System.out.println("Con cambio: " + f.apply(5));
		// ----------------------------------------------
		Function<Double, Double> addTax = price -> price + price * taxRate;
		System.out.println("Tarifa: " + addTax.apply(2.0));
		List<Integer> datos = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		datos.stream().reduce(0, (x, y) -> x + y);
		// Forma tradicional:
		int total = 0;
		for (int a : datos) {
			total += a;
		}
		BiFunction<Double, Double, Double> addTax2 = (price, rate) -> price + price * rate;
		System.out.println("Con final: " + addTax2.apply(2.0, taxRate));
		System.out.println("Con valor directo: " + addTax2.apply(2.0, 0.1));

		Function<Double, Function<Double, Function<Double, Double>>> add3 = taxRate -> price -> x -> price
				+ price * taxRate + x;
		Double res = add3.apply(2.0).apply(3.0).apply(5.0);
		System.out.println("Resultado: " + res);
		System.out.println(addTax2.apply(2.0, 0.9));

	}

}
