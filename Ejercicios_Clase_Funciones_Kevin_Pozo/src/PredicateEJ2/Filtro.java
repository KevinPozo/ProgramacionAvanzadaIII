package PredicateEJ2;

@FunctionalInterface
public interface Filtro<T> {
    boolean aplicar(T elemento);
}
