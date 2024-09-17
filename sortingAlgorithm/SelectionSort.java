import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
      int arr[] = {9, 1, 8, 2, 7, 3, 6, 4, 5};
      
      selectionsort(arr);
      
      for(int i: arr){
        System.out.print(i+ " ");
      }
  }
   public static void selectionsort(int arr[]){
     for(int i=0; i<arr.length-1;i++){
       int min = i; // current min 
       for(int j=i+1; j<arr.length;j++){ //inner loop
         if(arr[j]<arr[min]){ // find min 
           min = j; // update min 
         }
       }
        // swap i with min
        int temp=arr[i];
        arr[i]=arr[min];
        arr[min]=temp;
     }
     
   }
}
