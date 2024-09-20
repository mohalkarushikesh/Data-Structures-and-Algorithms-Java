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
//quick()
//  if(end<=start) return; //base condition
//  updated pivot=partition()
//  quicksort(arr, start, pivot-1)
//  quicksort(arr, pivot+1,end)
//
// recursion()
// pivot = end
// i = start - 1
// for ( j to n)
// if j < pivot
//      i++
//      swap arr[i],arr[j]
// i++ // increase i 
// swap pivot,arr[i]

public class QuickSort {
    public static void main(String[] args) {
      int arr[] = {4, 1, 55, 32, 44 ,776, 64, 77, 99};
      quicksort(arr, 0, arr.length-1);
      for(int i: arr){
        System.out.print(i+" ");
      }
  }
  public static void quicksort(int arr[], int start, int end){
    if(end<=start){ return; } // base condition
    int pivot = partition(arr, start, end); // updated pivot
    quicksort(arr, start, pivot-1); // recursive call : left partition
    quicksort(arr, pivot+1, end);// recursive call right partition
  }
  public static int partition(int arr[], int start, int end){
    int pivot = arr[end]; // pivot element last element in arr
    int i = start - 1; 	// -1 position
    for(int j=start; j<=end-1;j++){
      if(arr[j] < pivot){
        i++;
        int temp=arr[i]; // swap i = j
        arr[i]=arr[j];
        arr[j]=temp;
      }
    }
    i++; // increment i ie. i+1 to move swap pivot 
    int temp=arr[i]; // swap pivot with i+1
    arr[i]=arr[end];
    arr[end]=temp;
    return i; // updated pivot element base on this partition takes place 
  }
}


