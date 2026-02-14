package LeetCode150.Array_String;

import java.util.HashMap;
import java.util.Map;

public class LeetCode01_TwoSum {

    /**
     * One-pass Hash Table
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
