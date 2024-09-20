import java.util.*;
/*
Bubble Sort
Concept: Repeatedly swap adjacent elements if they are in the wrong order.
Steps:
Compare each pair of adjacent elements.
Swap them if they are in the wrong order.
Repeat until the list is sorted.
Visualization: Imagine bubbles rising to the surface, with the largest bubble (element) moving to the end in each pass.
*/
// Bubble sort : 
// 1. check arr[j] > arr[j+1]
// yes swap elements

cpackage sortingAlgorithms;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 2, 5, 1, 6, 0, 4, 5, 9};
        // Call the Bubblesort function to sort the array
        Bubblesort(arr);
        
        // Print the sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void Bubblesort(int arr[]) {
        int n = arr.length;
        // Outer loop to traverse through all elements
        for (int i = 0; i < n - 1; i++) { 
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) { 
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}


