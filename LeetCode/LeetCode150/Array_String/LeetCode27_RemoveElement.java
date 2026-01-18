package LeetCode150.Array_String;
public class LeetCode27_RemoveElement {

    // Approach 1: Two Pointers
    // Time complexity: O(2n) = O(n)
    // Space complexity: O(1)
    public int remove1(int[] nums, int val) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    // Approach 2: Two Pointers when elements to remove are rare
    // Time complexity: O(n). Both i and n traverse at most n steps. However, number of assignment ops = number of elements to remove
    // Space complexity: O(1)
    public int remove2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }

        return n;
    }
}
