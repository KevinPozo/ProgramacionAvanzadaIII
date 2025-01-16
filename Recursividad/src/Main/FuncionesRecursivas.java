package Main;

import java.util.function.Function;

public class FuncionesRecursivas {
	static Function<Integer, Integer> factorialNumero;
	static Function<Integer, Integer> fibonaciSerie;
	static Function<Integer, Integer> sumaNumerosNaturales;

	static {
		factorialNumero = n -> n == 0 ? 1 : n * factorialNumero.apply(n - 1);
	}

	static {
		fibonaciSerie = n -> n == 0 ? 0 : n == 1 ? 1 : fibonaciSerie.apply(n - 1) + fibonaciSerie.apply(n - 2);
	}

	static {
		sumaNumerosNaturales = n -> n == 0 ? 0 : n + sumaNumerosNaturales.apply(n - 1);
	}

	static <T> Function<T, T> identidad() {
		return t -> t;
	};

	public static void main(String[] args) {
		int x = 6;

		System.out.println("Factorial de " + x + " es: " + factorialNumero.apply(x));
		System.out.println("Serie de Fibonacci en posición " + x + " es: " + fibonaciSerie.apply(x));
		System.out.println("Suma de los primeros " + x + " números naturales es: " + sumaNumerosNaturales.apply(x));
		Function<Integer, Integer> t = identidad();
		System.out.println("Funcion identidad de " + x + " es: " + t.apply(x));
		Function<Integer, Integer> suc = n -> n + 1;
		Function<Integer, Integer> pre = n -> n - 1;
		int res3 = suc.apply(x);
		int res4 = pre.apply(x);
		System.out.println("El sucesor y predecesor de " + x + " es: " + res3 + " y " + res4);
		Function<Function<Integer, Integer>, Function<Integer, Integer>> f = identidad();
		Function<Integer, Integer> resultadoSuc = f.apply(suc);
		Function<Integer, Integer> resultadoPre = f.apply(pre);
		int resSuc = resultadoSuc.apply(x);
		int restPre = resultadoPre.apply(x);
		System.out.println("Resultado suc identidad: " + resSuc);
		System.out.println("Resultado pre identidad: " + restPre);

	}
}
