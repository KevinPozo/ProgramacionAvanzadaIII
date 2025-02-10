package iteracion;

import java.util.function.Function;
import java.util.stream.Stream;

public class ListaRecur<T> {
	private T head;
	private ListaRecur<T> tail;

	public ListaRecur(T head, ListaRecur<T> tail) {
		this.head = head;
		this.tail = tail;
	}

	public T head() {
		return head;
	}

	public ListaRecur<T> tail() {
		return tail;
	}

	public static <T> ListaRecur<T> of(T head, ListaRecur<T> tail) {
		return new ListaRecur<T>(head, tail);
	}

	@SafeVarargs
	public static <T> ListaRecur<T> of(T... values) {
		ListaRecur<T> fin = ListaRecur.of(null, null);
		for (int i = values.length - 1; i >= 0; i--) {
			ListaRecur<T> tmp = ListaRecur.of(values[i], fin);
			fin = tmp;
		}
		return fin;
	}

	@Override
	public String toString() {
		if (this.head == null) {
			return "";
		}
		return String.format("[%s,%s]", head, tail);
	}

	public T reduce(Function<T, Function<T, T>> fn, T vi) {
		if (this.head == null) {
			return vi;
		} else {
			return fn.apply(this.head).apply(this.tail.reduce(fn, vi));
		}
	}

	public static void main(String[] args) {
		ListaRecur<Integer> ls = ListaRecur.of(1, 2, 3, 4, 5, 6);
		System.out.println(ls);
		var total = ListaRecur.of(1, 2, 3, 4, 5).reduce(x -> y -> x + y, 0);
		System.out.println(total);
		var t = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).reduce((x, y) -> x + y);
		System.out.println(t);

	}
}
