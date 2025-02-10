package Deber;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		int sum = IntegerFolder.fold(numbers, 0);
		System.out.println("Suma de la lista: " + sum);

		GenericFolder<String> stringFolder = new GenericFolder<>();
		List<String> words = List.of("Hola", " ", "Mundo", "!");
		String concatenated = stringFolder.fold(words, "", new GenericFolder.Combiner<String>() {
			@Override
			public String combine(String a, String b) {
				return a + b;
			}
		});

		System.out.println("Concatenación: " + concatenated);
	}
}
