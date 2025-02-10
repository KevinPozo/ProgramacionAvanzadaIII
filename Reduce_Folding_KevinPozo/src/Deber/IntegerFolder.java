package Deber;

import java.util.List;

class IntegerFolder {
	public static int fold(List<Integer> list, int identity) {
		int result = identity;
		for (int num : list) {
			result = result + num;
		}
		return result;
	}
}
