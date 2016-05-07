package lecture2;

public class QuickSortAndBinarySearch extends AbstractClass {
	
	/*
     * QuickSort 
     */
	
	@Override
	public void SortMethod(int[] inputArray) {
		QSort(inputArray, 0, inputArray.length-1);
	}
	
	public static void QSort(int[] inputArray, int low, int hi) {
    	if(inputArray != null) {
	    	if (low < hi) {
	                int pivot = Partition(inputArray, low, hi);
	                QSort(inputArray, low, pivot - 1);
	                QSort(inputArray, pivot + 1, hi);
	    	}
    	}   	
    }
	
    public static int Partition(int[] inputArray, int low, int hi) {
    	int x = inputArray[hi];
    	int i = low - 1;
    	int swap;
    	for (int j = low; j <= hi - 1; j++) {
    		if (inputArray[j] <= x) {
    			i++;
    			swap = inputArray[i];
    			inputArray[i] = inputArray[j];
    			inputArray[j] = swap;
    		}
    	}
    	swap = inputArray[i + 1];
    	inputArray[i + 1] = inputArray[hi];
    	inputArray[hi] = swap;
    	
    	return i + 1;
    }
   
    /*
     * Binary Search 
     */
    @Override 
    public int SearchMethod (int[] inputArray,int x) {
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
		else {
			System.out.println("BinarySearch:inputArray = null");
		}
		System.out.println("no match");
		return i;
	}

}