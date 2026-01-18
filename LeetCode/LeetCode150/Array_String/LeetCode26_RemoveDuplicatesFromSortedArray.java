package LeetCode150.Array_String;

public class LeetCode26_RemoveDuplicatesFromSortedArray {

    // Time complexity: O(N)
    // Space complexity: O(1)
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }
}
