import java.util.*;
/*
Selection Sort
Concept: Divide the list into a sorted and an unsorted region.
Steps:
Find the smallest element in the unsorted region.
Swap it with the first unsorted element.
Move the boundary between sorted and unsorted regions one element to the right.
Visualization: Imagine selecting the smallest item from a list and moving it to the front.
*/
// selection sort : 
// for(0 to n-1)
//      current min
//      for(i+1 to n) inner loop 
//          fin min
//          update min
//      swap arr[i],arr[min]
 public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        
        // Call the selectionsort function to sort the array
        selectionsort(arr);
        
        // Print the sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void selectionsort(int arr[]) {
        // Outer loop to traverse through all elements
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i; // Assume the current element is the minimum
            
            // Inner loop to find the minimum element in the unsorted part
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) { // If a smaller element is found
                    min = j; // Update the index of the minimum element
                }
            }
            
            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}

