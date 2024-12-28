package Main;

import java.util.function.Function;

public class KevinPozo_JordyChamba_FuncionesVariosArgumentos {
	interface BinaryOperatior<T> extends Function<T, Function<T, T>> {

	}

	interface TriOperatior<T> extends Function<T, Function<T, Function<T, T>>> {

	}

	// Funcion simple:
	public static Integer sumar(Integer x, Integer y) {
		return x + y;
	}

	public static void main(String[] args) {
		System.out.println("Kevin Pozo y Jordy Chamba: ");
		// Binary:
		BinaryOperatior<Integer> fn4 = p -> l -> p + l;
		System.out.println("Suma con dos parametros binaryoperatior: " + fn4.apply(2).apply(1));
		// Tri:
		TriOperatior<Integer> fn5 = q -> w -> e -> +q + w + e;
		System.out.println("Suma con tres parametros trioperatior: " + fn5.apply(1).apply(1).apply(1));
		// Composicion de funciones:
		Function<Integer, Function<Integer, Integer>> fn = new Function<Integer, Function<Integer, Integer>>() {

			@Override
			public Function<Integer, Integer> apply(Integer x) {
				// TODO Auto-generated method stub
				return new Function<Integer, Integer>() {

					@Override
					public Integer apply(Integer y) {
						// TODO Auto-generated method stub
						return x + y;
					}
				};
			}
		};

		Function<Integer, Integer> y = fn.apply(4);
		Integer yres = y.apply(3);
		System.out.println("Suma de dos parametros: " + yres);
		// Tres Operaciones:
		Function<Integer, Function<Integer, Function<Integer, Integer>>> gn = new Function<Integer, Function<Integer, Function<Integer, Integer>>>() {

			@Override
			public Function<Integer, Function<Integer, Integer>> apply(Integer x) {
				// TODO Auto-generated method stub
				return new Function<Integer, Function<Integer, Integer>>() {

					@Override
					public Function<Integer, Integer> apply(Integer y) {
						// TODO Auto-generated method stub
						return new Function<Integer, Integer>() {

							@Override
							public Integer apply(Integer z) {
								// TODO Auto-generated method stub
								return x + y + z;
							}
						};
					}
				};
			}
		};
		Function<Integer, Function<Integer, Integer>> a = gn.apply(2);
		Function<Integer, Integer> b = a.apply(3);
		Integer c = b.apply(5);
		System.out.println("Suma de tres parametros: " + c);
		// System.out.println(fn.apply(3).apply(2));
		// Forma con lambdas:
		Function<Integer, Function<Integer, Integer>> fn2 = new Function<Integer, Function<Integer, Integer>>() {

			@Override
			public Function<Integer, Integer> apply(Integer x) {
				Function<Integer, Integer> f = y -> {
					return x + y;
				};
				return f;
			}
		};
		Function<Integer, Integer> y1 = fn2.apply(3);
		Integer yresultado = y1.apply(3);
		System.out.println("Suma de dos parámetros con lambda: " + yresultado);
		Function<Integer, Function<Integer, Integer>> fn3 = k -> u -> k + u;
		System.out.println("Suma de dos parametros con lambda reducido: " + fn3.apply(3).apply(2));

	}

}
