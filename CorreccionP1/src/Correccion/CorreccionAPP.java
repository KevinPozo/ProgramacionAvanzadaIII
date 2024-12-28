package Correccion;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CorreccionAPP {
	// static double impFijo = 0.12; afecta al programa y no brinda ayuda
	// a la funcion pura y no se puede usar para modelo de sustitucion
	public static void main(String[] args) {
		// Primer Ejercicio:
		BiFunction<Double, Double, Double> calcularPrecio = (precio, descuento) -> {
			return precio - (precio * (descuento) / 100);
		};
		System.out.println(calcularPrecio.apply(250.0, 12.5));
		// Segundo Ejercicio:
		Function<Integer, Integer> f = x -> 2 * x;
		Function<Integer, Integer> g = x -> x * x;
		Function<Integer, Integer> fg = f.compose(g);
		Function<Integer, Integer> gf = f.andThen(g); // similar a g.compose(f)
		System.out.println(fg.apply(4));
		System.out.println(gf.apply(4));
		// Tercer Ejercicio:
		double impFijo = 0.12;
		double precioBase = 1000.00;
		IEstrategiaPago estrategiaPago = precio -> precio * impFijo;
		BiFunction<Double, IEstrategiaPago, Double> calcularPrecio2Impuesto = (precio, estrategia) -> estrategia
				.IcalcularImp(precio);
		double impuesto = calcularPrecio2Impuesto.apply(precioBase, estrategiaPago);
		double precioTotal = precioBase + impuesto;
		System.out.println("Impuesto: " + impuesto);
		System.out.println("Precio total con impuesto: " + precioTotal);
		// Cuarto Ejercicio:
		Function<Integer, Function<Integer, Boolean>> esDivisiblePor = divisor -> numero -> numero % divisor == 0;

        // Usamos la función curried para determinar si un número es par o impar
        Function<Integer, Boolean> esPar = esDivisiblePor.apply(2); // Divisor = 2
        Function<Integer, Boolean> esImpar = numero -> !esPar.apply(numero); // Complemento de esPar

        // Ejemplos
        int numero1 = 4;
        int numero2 = 7;

        System.out.println("¿" + numero1 + " es par? " + esPar.apply(numero1)); // true
        System.out.println("¿" + numero1 + " es impar? " + esImpar.apply(numero1)); // false
        System.out.println("¿" + numero2 + " es par? " + esPar.apply(numero2)); // false
        System.out.println("¿" + numero2 + " es impar? " + esImpar.apply(numero2)); // true

	}
}
