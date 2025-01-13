package Arrays;

public class BinarySearch {

	public static int binarysearch(int arr[], int x) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == x) {
				return mid;
			}
			if (arr[mid] < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 10;

		int result = binarysearch(arr, x);

		if (result == -1) {
			System.out.println("element not found");
		} else {
			System.out.println("element found at index : " + result);
		}
	}

}
