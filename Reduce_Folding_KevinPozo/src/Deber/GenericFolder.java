package Deber;

import java.util.List;

class GenericFolder<T> {
	public interface Combiner<T> {
		T combine(T a, T b);
	}

	public T fold(List<T> list, T identity, Combiner<T> combiner) {
		T result = identity;
		for (T element : list) {
			result = combiner.combine(result, element);
		}
		return result;
	}
}
