import java.util.*;
/*
Quick Sort
Concept: Use a pivot to partition the list into smaller and larger elements.
Steps:
Choose a pivot element.
Partition the list into elements less than the pivot and elements greater than the pivot.
Recursively apply the same process to the sub-lists.
Visualization: Imagine picking a pivot and sorting elements around it, like organizing books on a shelf by size.
*/
// Quick sort : 


package sortingAlgorithms;

public class Temp {

	// Method to perform QuickSort on the array
	public static void quicksort(int arr[], int start, int end) {
		if (start < end) {
			// Find the partition index
			int partitionIndex = partition(arr, start, end);
			// Recursively sort elements before and after partition
			quicksort(arr, start, partitionIndex - 1);
			quicksort(arr, partitionIndex + 1, end);
		}
	}

	// Method to partition the array and return the partition index
	public static int partition(int arr[], int start, int end) {
		int pivot = arr[end]; // Choose the last element as pivot
		int partitionIndex = start; // Initial partition index
		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				// Swap if element is less than pivot
				swap(arr, i, partitionIndex);
				partitionIndex++;
			}
		}
		// Swap the pivot element with the element at the partition index
		swap(arr, partitionIndex, end);
		return partitionIndex;
	}

	// Method to swap two elements in the array
	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 33, 29, 5, 11, 67, 55, 22, 44, 24, 77, 0 };
		
		int end = arr.length - 1;
		// Call QuickSort on the array
		quicksort(arr, 0, end);

		// Print the sorted array
		System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
	}
}
