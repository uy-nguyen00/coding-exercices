package LeetCode150.Array_String;

public class LeetCode35_SearchInsertPosition {

    /**
     * Binary Search approach
     *
     * Time complexity: O(log N)
     *
     * Space complexity: O(1)
     */
    class Solution1 {

        public int searchInsert(int[] nums, int target) {
            int pivot,
                left = 0,
                right = nums.length - 1;

            while (left <= right) {
                pivot = left + (right - left) / 2;
                if (nums[pivot] == target) return pivot;
                if (target < nums[pivot]) right = pivot - 1;
                else left = pivot + 1;
            }

            return left;
        }
    }
}
