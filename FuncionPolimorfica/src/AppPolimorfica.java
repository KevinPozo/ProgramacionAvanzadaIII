
public class AppPolimorfica {
	
	// Métodos estáticos genéricos
    public static Function2<Integer, Integer> doble = x -> x * 2;
    public static Function2<Integer, Integer> triple = x -> x * 3;
    public static Function2<Integer, Integer> cuadruple = x -> x * 4;

    // Composición genérica de funciones
    public static <T, R, V> Function2<T, V> compose(Function2<R, V> f, Function2<T, R> g) {
        return x -> f.apply(g.apply(x));
    }

    public static void main(String[] args) {
        // Ejemplo de uso directo de las funciones
        System.out.println("Doble de 2: " + doble.apply(2)); // 4
        System.out.println("Triple de 3: " + triple.apply(3)); // 9
        System.out.println("Cuádruple de 4: " + cuadruple.apply(4)); // 16

        // Composición de funciones
        Function2<Integer, Integer> dobleDeTriple = compose(doble, triple); // (x * 3) * 2
        System.out.println("Doble del triple de 2: " + dobleDeTriple.apply(2)); // 12

        Function2<Integer, Integer> tripleDeDoble = compose(triple, doble); // (x * 2) * 3
        System.out.println("Triple del doble de 2: " + tripleDeDoble.apply(2)); // 12

        // Composición de funciones personalizadas
        Function2<Integer, Integer> cuadrado = x -> x * x;
        Function2<Integer, Integer> tripleDeCuadrado = compose(triple, cuadrado); // (x^2) * 3
        System.out.println("Triple del cuadrado de 2: " + tripleDeCuadrado.apply(2)); // 12
    }

}
