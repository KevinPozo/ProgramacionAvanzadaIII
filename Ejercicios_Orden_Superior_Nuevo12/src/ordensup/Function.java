package ordensup;

public interface Function<T, R> {
	R apply(T x);

	default <V> Function<V, R> compose(Function<V, T> o) {
		return (V x) -> this.apply(o.apply(x));
	}

	static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose() {
		return f -> g -> x -> f.apply(g.apply(x));
	}

	static Function<Double, Double> compose(Function<Double, Double> f, Function<Double, Double> g) {
		return new Function<Double, Double>() {
			@Override
			public Double apply(Double x) {
				return f.apply(g.apply(x));
			}
		};
	}
}
