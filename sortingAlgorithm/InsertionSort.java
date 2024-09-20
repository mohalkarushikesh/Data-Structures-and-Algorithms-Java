import java.util.*;
/*
Insertion Sort
Concept: Build the sorted array one item at a time.
Steps:
Start with the second element.
Compare it with the elements before it and insert it into its correct position.
Repeat for all elements.
Visualization: Think of sorting a hand of playing cards by picking one card at a time and placing it in the correct position.
*/

// insertion sort 
// for(1 to n)
//      temp=arr[i]
//      j=i-1
//      while(j>=0 && arr[j]>temp)
//          arr[j+1]=j
//          j--
//      arr[j+1]=temp // insert temp

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
	            j--; // move next ele on left/decrement j
            } 
            arr[j+1]=temp; // insert temp at correct postion
        }      
   }
}

