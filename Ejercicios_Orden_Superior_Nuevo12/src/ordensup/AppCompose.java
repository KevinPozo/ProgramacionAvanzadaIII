package ordensup;

public class AppCompose {
	public static void main(String[] args) {
		// Nombre: Kevin Pozo
		// Trabajo en CLases 16-12-2024
		Function<Integer, Double> f = x -> x * 1.2;
		Function<Double, Double> g = x -> x / 3;
		var resultado = Function.<Integer, Double, Double>higherCompose().apply(g).apply(f).apply(2);

		System.out.println("Resultado de higherCompose: " + resultado);
		Function<Double, Integer> f2 = x -> (int) (x * 3);
		Function<Long, Double> g2 = x -> x * 1.2;
		var resultado2 = Function.<Long, Double, Integer>higherCompose().apply(f2).apply(g2).apply(Long.valueOf("2"));
		System.out.println("Resultado de higherCompose2: " + resultado2);

		Function<Double, Double> f3 = x -> Math.PI / 2 - x;
		Function<Double, Double> sin = Math::sin;
		var cons = Function.compose(f3, g).apply(2.0);
		System.out.println("Resultado Ejercicio: " + cons);

		Function<Double, Double> f4 = x -> Math.cos(x);
		Function<Double, Double> pow = x -> Math.pow(x, x);
		var cons2 = Function.compose(f4, pow).apply(1.0);
		System.out.println("Resultado Nuevo Ejercicio: " + cons2);

		Function<Double, Double> f5 = x -> Math.tan(Math.E / Math.PI * x);
		Function<Double, Double> radication = x -> Math.sqrt(x);
		var cons3 = Function.compose(f5, radication).apply(15.0);
		System.out.println("Resultado Nuevo Ejercicio: " + cons3);
	}
}
