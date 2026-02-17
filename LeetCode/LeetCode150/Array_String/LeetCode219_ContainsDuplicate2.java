package LeetCode150.Array_String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode219_ContainsDuplicate2 {

    /**
     * Using HashMap for value - index pairs
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution1 {

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (
                    map.containsKey(nums[i]) &&
                    Math.abs(map.get(nums[i]) - i) <= k
                ) {
                    return true;
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }

    /**
     * Using Set with sliding window
     *
     * Time copmlexity: O(N)
     *
     * Space complexity: O(min(N, k))
     */
    class Solution2 {

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; ++i) {
                if (set.contains(nums[i])) return true;
                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
}
