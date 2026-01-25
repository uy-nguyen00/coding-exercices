package LeetCode150.Array_String;

public class LeetCode80_RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        int insertIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[insertIndex - 2] != nums[i]) {
                nums[insertIndex++] = nums[i];
            }
        }
        return insertIndex;
    }
}
