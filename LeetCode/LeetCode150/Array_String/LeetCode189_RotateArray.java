package LeetCode150.Array_String;

public class LeetCode189_RotateArray {

    /**
     * Brute Force.
     * Time complexity: O(N k).
     * Space complexity: O(1).
     * But exceeds time limit when input array too large and number of rotations big enough.
     */
    public void rotate1(int[] nums, int k) {
        // Minimal rotations needed
        k %= nums.length;

        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * Using an extra array by putting elements of the new array at indexes (i + k) % nums.length
     * Time complexity: O(N)
     * Space complexity: O(N), another array of the same size is used
     */
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * Using Reverse :
     *
     * Let n = 7, k = 3
     * Original List                   : 1 2 3 4 5 6 7
     * After reversing all numbers     : 7 6 5 4 3 2 1
     * After reversing first k numbers : 5 6 7 4 3 2 1
     * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     *
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
