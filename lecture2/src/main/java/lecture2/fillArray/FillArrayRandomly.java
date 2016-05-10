package lecture2.fillArray;
import  java.util.Random;

public class FillArrayRandomly {
	private static Random random = new Random();
	public static void FillArray(int[] inputArray) {
		for(int i = 0 ;i < inputArray.length; i++) {
			inputArray[i] = random.nextInt();
		}	
	}
}
