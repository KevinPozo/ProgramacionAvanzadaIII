package PolimorficaEJ1;

@FunctionalInterface
interface Transformador<T, R> {
    R aplicar(T entrada);
}
