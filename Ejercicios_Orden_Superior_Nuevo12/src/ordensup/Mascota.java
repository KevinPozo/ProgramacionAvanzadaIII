package ordensup;

public class Mascota {
	private int edad;
	private String nombre;
	private String raza;

	public Mascota(int edad, String nombre, String raza) {
		super();
		this.edad = edad;
		this.nombre = nombre;
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

}
