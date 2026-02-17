package LeetCode150.Array_String;

import java.util.ArrayList;
import java.util.List;

public class LeetCode228_SummaryRanges {

    /**
     * Accepted solution - but not optimized
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(1)
     */
    class Solution1 {

        public List<String> summaryRanges(int[] nums) {
            List<String> output = new ArrayList<>();
            if (nums.length == 0) return output;

            String range = String.valueOf(nums[0]);
            int[] suite = new int[2];
            suite[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == 1) {
                    suite[1] = nums[i];
                    range =
                        String.valueOf(suite[0]) +
                        "->" +
                        String.valueOf(suite[1]);
                } else {
                    output.add(range);
                    range = String.valueOf(nums[i]);
                    suite[0] = nums[i];
                }
            }

            output.add(range);
            return output;
        }
    }

    /**
     * Optimized version of Solution 1
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(1)
     */
    class Solution2 {

        public List<String> summaryRanges(int[] nums) {
            List<String> output = new ArrayList<>();
            if (nums.length == 0) return output;

            int rangeStart = nums[0];

            for (int i = 1; i < nums.length; i++) {
                // If sequence breaks, finalize current range
                if (nums[i] - nums[i - 1] != 1) {
                    if (rangeStart == nums[i - 1]) {
                        output.add(String.valueOf(rangeStart));
                    } else {
                        output.add(rangeStart + "->" + nums[i - 1]);
                    }
                    rangeStart = nums[i];
                }
            }

            // Add the last range
            if (rangeStart == nums[nums.length - 1]) {
                output.add(String.valueOf(rangeStart));
            } else {
                output.add(rangeStart + "->" + nums[nums.length - 1]);
            }

            return output;
        }
    }
}
