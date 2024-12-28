package ordensup;

public class Persona {
	private String nombre;
	private int edad;
	private String direccion;
	private double salaraio;
	
	public Persona(String nombre, int edad, String direccion, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.salaraio = salario;
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public double getSalaraio() {
		return salaraio;
	}
	
	
}
