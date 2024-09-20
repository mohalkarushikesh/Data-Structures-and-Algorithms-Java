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

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {32, 53, 32, 13, 65, 33, 77, 3, 8, 6};
        // Call the insertionsort function to sort the array
        insertionsort(arr);
        
        // Print the sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
    private static void insertionsort(int arr[]) {
        // Iterate over each element starting from the second element
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // Store the current element in temp
            int j = i - 1;
            
            // Shift elements of the sorted segment forward if they are greater than temp
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert the temp element at the correct position
            arr[j + 1] = temp;
        }
    }
}

