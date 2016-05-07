package lecture2;

public class CoctailSortAndInterpolatedSearch extends AbstractClass {
	/*
     * InterpolatedSearch 
     */
	
	@Override
	public  int SearchMethod (int[] inputArray, int x) {
		 if(inputArray != null) {
			 int low = 0;
			 int high = inputArray.length-1;
			 int middle;
			 while((inputArray[low] < x && inputArray[high] > x)) {
			 middle = (int) (low + ((long) x - (long) inputArray[low]) * (high - low) / ((long) inputArray[high] - (long) inputArray[low]));

				 if(inputArray[middle] < x) {
					 low = (middle +1);				 
				 }
				 else if(x < inputArray[middle]) {
					 high = (middle -1);
				 }
				 else {
					 return middle;
				 }
			 }
			 if(x == inputArray[low]) {
				 return low;
			 }
			 else if(x ==inputArray[high]) {
				 return high;
			 }
			 else {
				 System.out.println("no match");
				 return -1;
			 }
		 }
		 else{
			 System.out.println("InterpolatedSearch:inputArray = null");
		 }
		 return -1;
	    }
	/*
     * CoctailSort 
     */
	
	@Override
	public void SortMethod (int[] inputArray) {
    	if(inputArray != null) {
    		int firstUnsortedElement = 0;
    		int lastUnsortedElement = inputArray.length-1;
    		boolean swapFlag = false;
    		int swapVar;
    	
    		do {
    			for(int i = firstUnsortedElement; i < lastUnsortedElement; i++) {
    				if(inputArray[i] > inputArray[i+1]) {
    					swapVar = inputArray[i];
    					inputArray[i] = inputArray[i+1];
    					inputArray[i+1] = swapVar;		
    					swapFlag = true;
    				}
    			}
    			lastUnsortedElement--;
    			if(swapFlag == false) { 
    				break;
    			}
    			swapFlag = false;
    			for(int i = lastUnsortedElement; i > firstUnsortedElement; i-- ) {
    				if(inputArray[i] < inputArray[i-1]) {
    					swapVar = inputArray[i];
    					inputArray[i] = inputArray[i-1];
    					inputArray[i-1] = swapVar;   				
    					swapFlag = true;
    				}
    			}
    			firstUnsortedElement++;
    		}	while(swapFlag == true);
    	}
    	else {
    		System.out.println("CoctailSort:inputArray = null");
   	 	}
    }

}
