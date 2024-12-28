package Main;

public class Ejemplo {
	private static int count = 1;

//Funcion normal Pura:
	public static int sumar(int a, int b) {
		return a + b;
	}

//Funcion devuelve el mismo resultado:
	public static int incrementar(int a) {
		return a + count++;
	}

}
