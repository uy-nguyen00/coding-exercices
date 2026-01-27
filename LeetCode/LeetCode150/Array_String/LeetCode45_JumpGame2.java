package LeetCode150.Array_String;

import java.util.Arrays;

public class LeetCode45_JumpGame2 {

    /**
     * Greedy Approach
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    class Solution1 {

        public int jump(int[] nums) {
            int jumps = 0;
            int currentJumpEnd = 0;
            int farthestReachable = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                farthestReachable = Math.max(farthestReachable, i + nums[i]);

                if (i == currentJumpEnd) {
                    jumps++;
                    currentJumpEnd = farthestReachable;
                }
            }

            return jumps;
        }
    }

    /**
     * Top-down DP Approach
     * Time complexity: O(N^2)
     * Space complexity: O(2N) = O(N)
     */
    class Solution2 {

        private int[] memo;

        public int jump(int[] nums) {
            memo = new int[nums.length];
            Arrays.fill(memo, -1); // -1 means not computed yet
            return minJumpsFrom(0, nums);
        }

        private int minJumpsFrom(int position, int[] nums) {
            // Base case: already at the end
            if (position >= nums.length - 1) {
                return 0;
            }

            // Return cached result if already computed
            if (memo[position] != -1) {
                return memo[position];
            }

            int minJumps = Integer.MAX_VALUE;
            int maxReach = Math.min(position + nums[position], nums.length - 1);

            // Try all possible jump lengths from this position
            for (int nextPos = position + 1; nextPos <= maxReach; nextPos++) {
                int jumpsFromNext = minJumpsFrom(nextPos, nums);
                if (jumpsFromNext != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, 1 + jumpsFromNext);
                }
            }

            // Cache and return result
            memo[position] = minJumps;
            return minJumps;
        }
    }

    /**
     * Bottom-up DP Approach
     * Time complexity: O(N^2)
     * Space complexity: O(N)
     */
    class Solution3 {

        public int jump(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 0; i < n; i++) {
                if (dp[i] == Integer.MAX_VALUE) continue;

                int maxReach = Math.min(i + nums[i], n - 1);
                for (int j = i + 1; j <= maxReach; j++) {
                    if (dp[j] > dp[i] + 1) {
                        dp[j] = dp[i] + 1;

                        // Early termination: if we reached the end, stop
                        if (j == n - 1) return dp[n - 1];
                    }
                }
            }

            return dp[n - 1];
        }
    }
}
