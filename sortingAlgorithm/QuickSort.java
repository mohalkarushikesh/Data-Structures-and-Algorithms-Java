

import java.util.*;

public class Main {
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


