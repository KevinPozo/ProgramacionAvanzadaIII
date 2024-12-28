@FunctionalInterface
public interface Function2<T,R> {
	R apply(T x);
//Definicionnde metodos por :
//default: OBLIGATORIAMENTE DEBE TENER UNA IMPL
//Estaticos: NO SE HEREDAN BAJO NINGUNA CIRCUNSTANCIA
//Abstracto: SE DEBEN DE MODIFICAR EN CADA CLASE
}
