package lecture2;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//
		int[] testArray = new int[10];
		AbstractClass QuickBinary = new QuickSortAndBinarySearch();
		JustMethodForSearchAndSort(QuickBinary, testArray);
		QuickBinary.SearchMethod(testArray, 100500);
		System.out.println("\n");
		
		AbstractClass CoctailInterp = new CoctailSortAndInterpolatedSearch();
		JustMethodForSearchAndSort(CoctailInterp, testArray);
		CoctailInterp.SearchMethod(testArray, 100500);
	}

	public static void JustMethodForSearchAndSort(AbstractClass someAbstractClass,int[] inputArray) {
		//
		GetRandomArray.GetArray(inputArray);
		System.out.println("class" + someAbstractClass.toString());
		System.out.println("Unsorted random array: " +Arrays.toString(inputArray));
		someAbstractClass.SortMethod(inputArray);
		System.out.println("Sorted random array:   " +Arrays.toString(inputArray));
	}
}
