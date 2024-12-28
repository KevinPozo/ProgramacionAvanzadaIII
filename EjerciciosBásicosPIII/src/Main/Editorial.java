package Main;

import java.util.ArrayList;
import java.util.List;

public class Editorial {
    private String nombre;
    private String direccion;
    private List<Libro> listaLibros;

    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaLibros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    @Override
    public String toString() {
        return "Editorial [nombre=" + nombre + ", dirección=" + direccion + "]";
    }
}
