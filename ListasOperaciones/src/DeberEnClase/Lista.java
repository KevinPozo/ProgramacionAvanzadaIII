//Nombre: Kevin Fernando Pozo Maldonado
//Curso: C7-001
//Fecha: 2025/01/27
package DeberEnClase;

import java.util.function.Consumer;
import java.util.function.Function;

public sealed interface Lista<T> permits Const, Empty {
	T head();

	Lista<T> tail();

	boolean isEmpty();

	Lista Empty = new Empty();

	public static <T> Lista<T> of(T head, Lista<T> tail) {
		return new Const(head, tail);
	}

	public static <T> Lista<T> of(T... values) {
		Lista<T> fin = Empty;
		for (int i = values.length - 1; i >= 0; i--) {
			Lista<T> tmp = Lista.of(values[i], fin);
			fin = tmp;
		}
		return fin;
	}

	default Lista<T> invert() {
		var tmp = this;
		Lista<T> ret = Empty;
		while (!tmp.isEmpty()) {
			ret = Lista.of(tmp.head(), ret);
			tmp = tmp.tail();
		}
		return ret;
	}

	default Lista<T> removeFirst() {
		return this.tail();
	}

	default T reduce(Function<T, Function<T, T>> fn, T vi) {
		if (isEmpty()) {
			return vi;
		} else {
			return fn.apply(head()).apply(tail().reduce(fn, vi));
		}
	}

	default void forEach(Consumer<T> con) {
		if (!this.isEmpty()) {
			con.accept(this.head());
			this.tail().forEach(con);
		}
	}

	default int count() {
		return isEmpty() ? 0 : 1 + tail().count();
	}

	default Lista<T> prepend(T value) {
		return Lista.of(value, this);
	}

	default Lista<T> append(T value) {
		return this.invert().prepend(value).invert();
	}

	default <U> U foldLeft(U initial, Function<U, Function<T, U>> fn) {
		var tmp = this;
		U result = initial;
		while (!tmp.isEmpty()) {
			result = fn.apply(result).apply(tmp.head());
			tmp = tmp.tail();
		}
		return result;
	}

	default <U> U foldRight(U initial, Function<T, Function<U, U>> fn) {
		if (isEmpty()) {
			return initial;
		} else {
			return fn.apply(head()).apply(tail().foldRight(initial, fn));
		}
	}

	default <U> U fold(U initial, Function<T, Function<U, U>> fn, boolean isLeftFold) {
		if (isEmpty()) {
			return initial;
		}
		if (isLeftFold) {
			U result = initial;
			Lista<T> tmp = this;
			while (!tmp.isEmpty()) {
				result = fn.apply(tmp.head()).apply(result);
				tmp = tmp.tail();
			}
			return result;
		} else {
			return fn.apply(head()).apply(tail().fold(initial, fn, false));
		}
	}

}

record Const<T>(T head, Lista<T> tail) implements Lista<T> {

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s]", head, tail);
	}

}

final class Empty implements Lista {

	@Override
	public Object head() {
		return null;
	}

	@Override
	public Lista tail() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public String toString() {
		return "Lista Vacia";
	}
}
