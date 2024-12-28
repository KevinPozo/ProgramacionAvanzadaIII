package Main;

import java.util.function.Function;

public class AppOrdenSuperior {

	public static void main(String[] args) {
		Function<Integer, Integer> triple = x -> x * 3;
		Function<Integer, Integer> square = x -> x * x;

		Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> compos = new Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>>() {

			@Override
			public Function<Function<Integer, Integer>, Function<Integer, Integer>> apply(
					Function<Integer, Integer> x) {
				return new Function<Function<Integer, Integer>, Function<Integer, Integer>>() {

					@Override
					public Function<Integer, Integer> apply(Function<Integer, Integer> y) {
						return new Function<Integer, Integer>() {

							@Override
							public Integer apply(Integer z) {
								return x.apply(y.apply(z));
							}
						};
					}
				};
			}
		};
		Function<Integer, Integer> f = compos.apply(x -> x * x).apply(x -> x * 3);
		// Function<Integer, Integer> f = compos.apply(square).apply(triple);
		System.out.println("Funcion compuesta de square y triple: " + f.apply(2));
		// Hecho con lambdas:
		Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> compos2 = x -> y -> z -> x
				.apply(y.apply(z));
		// Idea:
		// T = Function<Integer, Integer>
		// Function<T, Function<T, R>>

	}
}
