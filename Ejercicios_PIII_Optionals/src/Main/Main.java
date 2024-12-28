package Main;

import java.util.Optional;
import java.util.function.Function;

public class Main {
	public static Optional<Integer> convertStringToInteger(String input) {
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
	public static void main(String[] args) {
		Optional<Integer> result1 = convertStringToInteger("234");
        result1.ifPresentOrElse(
            System.out::println, 
            () -> System.out.println("Error: No es una cadena válida")
        );

        Optional<Integer> result2 = convertStringToInteger("666");
        result2.ifPresentOrElse(
            System.out::println, 
            () -> System.out.println("Error: No es una cadena válida")
        );
        
		// 1 forma no recomendada, sustituyendo o arreglando el bug:
		// Function<Integer, Integer> f = x->1/x;
		// f.apply(0);
		
		// 2. FORMA RECOMENDADA PARA USAR PROGRA FUNCIONAL
//		Function<Integer, Optional<Integer>> f0 = x -> {
//			if (x == 0) {
//				return Optional.empty();
//			} else {
//				return Optional.of(1 / x);
//			}
//		};
//		
//		Optional<Integer> ret = f0.apply(1);
//		System.out.println(ret);
		
		//3. CUrrying y optional:
//		Optional<Integer> resp = div(10, 5);
//		resp.ifPresentOrElse(System.out::print, ()->System.out.println("error"));
	}
//	public static Optional<Integer> div (int x, int y){
//		if(y==0) {
//			return Optional.empty();
//		}else {
//			return Optional.of(x/y);
//		}
//	}
	
}
