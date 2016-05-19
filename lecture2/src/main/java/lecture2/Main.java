package lecture2;
import java.util.Arrays;

import lecture2.fillArray.FillArrayRandomly;
import lecture2.sortAndSearch.CoctailSortAndInterpolatedSearch;
import lecture2.sortAndSearch.QuickSortAndBinarySearch;
import lecture2.sortAndSearch.SortAndSearch;

public class Main {

	public static void main(String[] args) {
		//
		int[] testArray = new int[10];
		SortAndSearch quickBinary = new QuickSortAndBinarySearch();
		fillAndSort(quickBinary, testArray);
		quickBinary.search(testArray, 100500);
		System.out.println("\n");
		
		SortAndSearch coctailInterp = new CoctailSortAndInterpolatedSearch();
		fillAndSort(coctailInterp, testArray);
		coctailInterp.search(testArray, 100500);
	}

	public static void fillAndSort(SortAndSearch inputClass,int[] inputArray) {
		//
		FillArrayRandomly.fillArray(inputArray);
		System.out.println("class" + inputClass.toString());
		System.out.println("Unsorted random array: " +Arrays.toString(inputArray));
		inputClass.sort(inputArray);
		System.out.println("Sorted random array:   " +Arrays.toString(inputArray));
	}
}
