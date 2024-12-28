package Main;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nombre;
    private String nacionalidad;
    private List<Libro> librosEscritos;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.librosEscritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void agregarLibro(Libro libro) {
        librosEscritos.add(libro);
    }

    public List<Libro> getLibrosEscritos() {
        return librosEscritos;
    }

    @Override
    public String toString() {
        return "Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
    }
}
