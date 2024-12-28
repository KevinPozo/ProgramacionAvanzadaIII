package Main;

public class Libro {
private String titulo;
private Autor autor;
private String ISBN;
private int anioPublicacion;
public Libro(String titulo, Autor autor, String iSBN, int anioPublicacion) {
	super();
	this.titulo = titulo;
	this.autor = autor;
	ISBN = iSBN;
	this.anioPublicacion = anioPublicacion;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public Autor getAutor() {
	return autor;
}
public void setAutor(Autor autor) {
	this.autor = autor;
}
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public int getAnioPublicacion() {
	return anioPublicacion;
}
public void setAnioPublicacion(int anioPublicacion) {
	this.anioPublicacion = anioPublicacion;
}
@Override
public String toString() {
	return "Libro [titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", anioPublicacion=" + anioPublicacion
			+ "]";
}

}
