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

class BubbleSort{
	public static void main(String[] args){
		int arr[] = {4, 1, 55, 32, 44 ,776, 64, 77, 99};
		Bubblesort(arr);		
		for(int i: arr){
			System.out.print(i+" ");
        }
    }
    public static void Bubblesort(int arr[]){
		int n = arr.length;
        for(int i=0;i<n-1;i++){
		    for(int j=0; j<n-i-1;j++){
			    if(arr[j] > arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
                }
            }
        }
    }
}

