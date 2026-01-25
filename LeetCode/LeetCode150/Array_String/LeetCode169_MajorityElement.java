package LeetCode150.Array_String;

import java.util.HashMap;
import java.util.Map;

public class LeetCode169_MajorityElement {

    // Time complexity: O(N)
    // Space complexity: O(N)
    public int majorityElement1(int[] nums) {
        int threshold = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > threshold) return key;
        }
        return 0;
    }

    // Boyer-Moore Voting Algorithm
    // Time complexity: O(N)
    // Space complexity: O(1)
    public int majorityElement2(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
