package lecture2;
import  java.util.Random;

public class GetRandomArray {
	private static Random random = new Random();
	public static void GetArray(int[] inputArray) {
		for(int i = 0 ;i < inputArray.length; i++) {
			inputArray[i] = random.nextInt();
		}	
	}
}
