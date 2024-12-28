package ordensup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class AppOrden {

	public static List<Persona> list = Arrays.asList(new Persona("Ana", 20, "dir1", 450),
			new Persona("Juan", 30, "dir2", 850), new Persona("Carlos", 25, "dir3", 750),
			new Persona("Mary", 27, "dir4", 650), new Persona("Leonor", 15, "dir5", 550),
			new Persona("Perdo", 34, "dir6", 350)

	);

	public static List<String> imprimir(List<Persona> per) {
		// Se convierte en una función:
		List<String> res = new ArrayList<String>();
		for (var it : list) {
			res.add(it.getNombre());
		}
		return res;
	}

	public static double promedio(List<Persona> list) {
		Integer tot = 0;
		for (var it : list) {
			tot += it.getEdad();
		}
		double prom = tot / list.size();
		return prom;
	}

	// Util para cualquier operación es un Genérico:
	public static <T> T reducir(T startValue, Function<Persona, T> fn, BinaryOperator<T> op) {

		T total = startValue;
		for (var it : list) {
			T value = fn.apply(it);
			total = op.apply(total, value);
		}
		return total;
	}

	public static void main(String[] args) {
		List<String> result = imprimir(list);
		List<String> resul2 = Arrays.asList("Ana", "Juan");
		Function<Persona, String> f = p -> p.getNombre();
		Function<String, String> g = p -> p.toUpperCase();
		Function<Persona, String> comp = g.compose(f);
		for (var it : list) {
			String tmp = comp.apply(it);
			System.out.println(tmp);
		}

		System.out.println("-------------------------------------");
		System.out.println("Funcional");
		list.stream().map(s -> s.getNombre()).map(s -> s.toUpperCase()).forEach(System.out::println);

		System.out.println("-------------------------------------");
		System.out.println("Promedio");

		System.out.println(promedio(list));

		// operar sobre los datos de cualquier forma
		BinaryOperator<Integer> sum = (x, y) -> x + y;
		Function<Persona, Integer> h = p -> p.getEdad();
		Integer total = 0;
		for (var it : list) {
			Integer edad = h.apply(it);
			total = sum.apply(total, edad);
		}
		double promedio = total / list.size();
		System.out.println(promedio);

		// equivalente a lo que se hizo arriba
		System.out.println("Promedio Funcional");
		Integer pr = list.stream().map(p -> p.getEdad()).reduce(0, (x, y) -> x + y);
		double prom = pr / list.size();
		// System.out.println(pr);
		Integer totRed = reducir(0, p -> p.getEdad(), (x, y) -> x + y);
		System.out.println(totRed / list.size());

		// salario total
		System.out.println("Salario total");
		Double SalTot = reducir(0.0, p -> p.getSalaraio(), (x, y) -> x + y);
		System.out.println(SalTot);
		// total nombre
		System.out.println("Nombre total");
		String totNombre = reducir("", p -> p.getNombre(), (x, y) -> x + y + ",");
		System.out.println(totNombre);

	}

}
