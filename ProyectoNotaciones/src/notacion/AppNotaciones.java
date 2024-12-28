package notacion;

//Me ayuda a diseñar mis propios metodos manipulando sus funciones
@FunctionalInterface
interface Function {
	int apply(int x);
}
//COn Genericos:
//interface Function2<T, R>{
//	R apply(T x);
//}

public class AppNotaciones {
	public static int suma(int x, int y) {
		return x + y;
	}

	public static int doble(int x) {
		return x * x;
	}

	public static int triple(int x) {
		return x * 3;
	}

	public static int cuadruple(int x) {
		return x * 4;
	}

//	public static int compose(int x, int y) {
//		return x + y;
//	}
	// Composicion de funciones
	public static Function compose(Function f, Function g) {
		return new Function() {

			@Override
			public int apply(int x) {
				return f.apply(g.apply(x));
			}
		};
	}

	public static void main(String[] args) {
		int res = doble(2);
		int res2 = triple(3);
		int res3 = doble(triple(2));
		// int res4 = compose(triple(2), doble(4));
		// Composición de funciones:
		// var h = doble(triple(2)); // Ejemplo base
		// Funcion con interface
		Function triple = new Function() {

			@Override
			public int apply(int x) {
				return x * 3;
			}
		};
		Function cuadrado = new Function() {

			@Override
			public int apply(int x) {
				return x * x;
			}
		};
		Function fg = compose(triple, cuadrado);
		System.out.println("F compuesta de G: " + fg.apply(2));
		Function gf = compose(cuadrado, triple);
		System.out.println("G compuesta de F: " + gf.apply(2));
		
	}

}
