/*
Merge Sort
Concept: Divide and conquer by splitting the list into halves.
Steps:
Divide the list into two halves.
Recursively sort each half.
Merge the two sorted halves back together.
Visualization: Think of splitting a deck of cards into smaller piles, sorting each pile, and then merging them back together.
*/

class MergeSort{
    public static void main(String[] args){
        int arr[] = {4, 22, 33, 75, 3, 0, 3, 9, 32};
        for(int i:arr){
            System.out.print(i+" "); 
        }
    }
     public static void mergesort(int arr[]) {
        int len = arr.length;
        if (len <= 1) return; // Base condition: if the array has 1 or no elements, it's already sorted
        int mid = len / 2; // Find the midpoint of the array
        int leftarr[] = new int[mid]; // Create left subarray
        int rightarr[] = new int[len - mid]; // Create right subarray

        int i = 0;
        int j = 0;

        // Split the array into left and right subarrays
        for (; i < len; i++) {
            if (i < mid) {
                leftarr[i] = arr[i];
            } else {
                rightarr[j] = arr[i];
                j++;
            }
        }

        // Recursively sort both subarrays
        mergesort(leftarr);
        mergesort(rightarr);
        // Merge the sorted subarrays back into the original array
        merge(leftarr, rightarr, arr);
    }

    public static void merge(int leftarr[], int rightarr[], int arr[]) {
        int leftsize = arr.length / 2; // Size of the left subarray
        int rightsize = arr.length - leftsize; // Size of the right subarray
        int i = 0, l = 0, r = 0;

        // Merge the left and right subarrays into the original array
        while (l < leftsize && r < rightsize) {
            if (leftarr[l] < rightarr[r]) {
                arr[i] = leftarr[l];
                i++;
                l++;
            } else {
                arr[i] = rightarr[r];
                i++;
                r++;
            }
        }

        // Copy any remaining elements of the left subarray
        while (l < leftsize) {
            arr[i] = leftarr[l];
            i++;
            l++;
        }

        // Copy any remaining elements of the right subarray
        while (r < rightsize) { // Corrected condition to rightsize
            arr[i] = rightarr[r];
            i++;
            r++;
        }
    }
}
