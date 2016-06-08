package Lect1.Lecture1;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
	
			
		int [] testArray = {5, 3, 2, 6, 0, 9, 7, 1, 4, 8};	
		//int[] testArray = new int[10];
		//Arrays.fill(testArray, 0);		
		testArray = null;
		
		
		QSort ( testArray, 0, 9 );						
		System.out.println("int[] testArray = " + Arrays.toString(testArray));
		System.out.println("find = " +find(testArray, 4));
	}

	
    /*
     * QuickSort 
     */
	
    public static void QSort(int[] inputArray, int p, int r) {
    	if(inputArray != null) {
	    	if (p < r) {
	                int q = Partition(inputArray, p, r);
	                QSort(inputArray, p, q - 1);
	                QSort(inputArray, q + 1, r);
	    	}
    	}   	
    }
	
    public static int Partition(int[] inputArray, int p, int r) {
    	int x = inputArray[r];
    	int i = p - 1;
    	int swap;
    	for (int j = p; j <= r - 1; j++) {
    		if (inputArray[j] <= x) {
    			i++;
    			swap = inputArray[i];
    			inputArray[i] = inputArray[j];
    			inputArray[j] = swap;
    		}
    	}
    	swap = inputArray[i + 1];
    	inputArray[i + 1] = inputArray[r];
    	inputArray[r] = swap;
    	
    	return i + 1;
    }
  
    
    /*
     * Binary Search (первое вхождение)
     */
    
    public static int find(int[] inputArray,int x) {
		int i = -1;
		if (inputArray != null) {
			int low = 0, high = inputArray.length, mid;
			while (low < high) {
				mid = (low + high) >>> 1;
				if (x == inputArray[mid]) {
					i = mid;
					while(inputArray[i] == inputArray[i-1]) {i--;}
					break;
				} else {
					if (x < inputArray[mid]) {
						high = mid;
					} else {
						low = mid + 1;
					}
				}
			}
		}
		return i;
	}
    
    
    
    
}

