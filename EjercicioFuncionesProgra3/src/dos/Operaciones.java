package dos;

//SI tiene efecto secundario no recomdable poner el print dentro
//de un metodo
//System.out.println(x);
public class Operaciones {

	int respuesta;
	
	public int sumar(int x, int y) {
		while (y != 0) {

			x++;
			y--;
		}
		respuesta = x;
		return respuesta;
	}

	public int multiplicar(int x, int y) {
		int resultado = 0;
		while (y != 0) {
			resultado = sumar(resultado, x);
			y--;
		}
		respuesta = resultado;
		return respuesta;
	}

	public int potencia(int base, int exponente) {
		int resultado = 1;
		while (exponente != 0) {
			resultado = multiplicar(resultado, base);
			exponente--;
		}
		respuesta = resultado;
		return respuesta;
	}

}
