import java.util.function.Function;

public class AppLambda {
	interface Function<T,R> {
		int apply(int x);
	}
	// Composición genérica de funciones
    public static <T, R, V> Function<T, V> compose(Function<R, V> f, Function<T, R> g) {
        return x -> f.apply(g.apply(x));
    }
public static void main(String[] args) {
	Function<Integer, Integer> triple = x->x*3;
	Function<Integer, Integer> cuadrado = x->x*x;
	Function<Integer, Integer> fg = compose(cuadrado, triple);
	System.out.println(fg.apply(2));
}
}
