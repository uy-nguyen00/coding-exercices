package LeetCode150.Array_String;

import java.util.HashMap;
import java.util.Map;

public class LeetCode219_ContainsDuplicate2 {

    /**
     * Using HashMap for value - index pairs
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (
                map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k
            ) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
