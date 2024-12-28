package Main;

public record Persona(int id, String name, int age) {
	static int count = 0;
	
	public Persona(String name, int age) {
		this(count++,name,age);
	}

}
