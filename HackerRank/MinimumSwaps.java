public class MinimumSwaps {

    static int minimumSwaps(int[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                int correctIndex = arr[i] - 1;

                // Swap arr[i] with arr[correctIndex]
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] arr1 = { 7, 1, 3, 2, 4, 5, 6 };
        System.out.println("Test Case 1: " + minimumSwaps(arr1)); // Expected: 5

        int[] arr2 = { 4, 3, 1, 2 };
        System.out.println("Test Case 2: " + minimumSwaps(arr2)); // Expected: 3

        int[] arr3 = { 1, 2, 3, 4 };
        System.out.println("Test Case 3: " + minimumSwaps(arr3)); // Expected: 0

        int[] arr4 = { 2, 1 };
        System.out.println("Test Case 4: " + minimumSwaps(arr4)); // Expected: 1

        int[] arr5 = { 2, 3, 4, 1, 5 };
        System.out.println("Test Case 5: " + minimumSwaps(arr5)); // Expected: 3
    }
}
