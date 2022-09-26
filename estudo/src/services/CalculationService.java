package services;

import java.util.List;

public class CalculationService {

    //public static <T extends Comparable<? super T>> T max(List<T> list) { //<- this is the correct/better way to do it (Devido a poder usar compareTo de qualquer claasse pai que implemente Comparable)
	public static <T extends Comparable<T>> T max(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("List can't be empty");
		} 
		T max = list.get(0);
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		return max;
	}
}