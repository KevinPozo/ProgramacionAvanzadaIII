package funcional;

import java.util.Scanner;

public class AppFuncional {
	public static void main(String[] args) {
		EnviarCorreo e = new EnviarCorreo();
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese su correo electrónico: ");
		String email = entrada.next();
		try {
			e.validateEmail(email);
		} catch (NullPointerException ex) {
			System.out.println("Error: Debe proporcionar un correo electrónico válido.");
		} catch (Exception ex) {
			System.out.println("Ha ocurrido un error inesperado: " + ex.getMessage());
		}
	}

}
