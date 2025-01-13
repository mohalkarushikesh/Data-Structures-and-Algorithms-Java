package Arrays;

public class LinearSearch {

	public static int linearsearch(int arr[], int x) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int arr[] = { 10, 8, 30, 4, 5 };
		int x = 5;

		int result = linearsearch(arr, x);

		if (result == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found at index : " + result);
		}
	}

}
