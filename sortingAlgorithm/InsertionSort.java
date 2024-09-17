import java.util.*;
class InsertionSort{
	public static void main(String[], args){
		int arr[] = {32, 53, 32, 13, 65, 33, 77, 3, 8, 6};
		insertionsort(arr);
		for(int i: arr){
	        System.out.print(i+” ”); 
        }
    }
    public static void insertionsort(int arr[]){
	    for(int i=1;i<arr.length;i++){ //loop through each ele starting from 2nd ele
		    int temp = arr[i]; // store current ele in temp variable
    		int j = i – 1; // initialize j to index in previous element
	    	while(j>=0 && arr[j] > temp){ // shift ele in sorted order if they are > temp
	            arr[j+1] = j;  // push j to j+1
	            j--; // move next ele on left 
            } 
            arr[j+1]=temp; // insert temp at correct postion
        }      
   }
}

