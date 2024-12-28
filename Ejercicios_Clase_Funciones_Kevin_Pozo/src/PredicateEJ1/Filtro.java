package PredicateEJ1;

@FunctionalInterface
public interface Filtro<T> {
    boolean aplicar(T elemento);
}

