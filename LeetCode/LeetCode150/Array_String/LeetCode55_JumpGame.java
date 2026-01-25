package LeetCode150.Array_String;

public class LeetCode55_JumpGame {

    class Solution1 {

        /**
         * Recursive Backtracking with Time Limit Exceeded
         * Time complexity: O(2^n)
         * Space complexity: O(n), since Recursive requires additional memory for the stack frames
         */
        public boolean canJumpFromPosition(int position, int[] nums) {
            if (position == nums.length - 1) {
                return true;
            }

            int furthestJump = Math.min(
                position + nums[position],
                nums.length - 1
            );
            for (
                int nextPosition = furthestJump;
                nextPosition > position;
                nextPosition--
            ) {
                if (canJumpFromPosition(nextPosition, nums)) {
                    return true;
                }
            }

            return false;
        }

        public boolean canJump(int[] nums) {
            return canJumpFromPosition(0, nums);
        }
    }

    /**
     * Top-down Dynamic Programming
     * Time complexity: O(n - 1 + n - 2 + ... + 1 + 0) = O(n(n - 1)/2) = O(n^2)
     * Space complexity: O(2n) = O(n). First n comes from recursion. Second n comes from the usage of memo table
     */
    class Solution2 {

        enum Index {
            GOOD,
            BAD,
            UNKNOWN,
        }

        class Solution {

            Index[] memo;

            public boolean canJumpFromPosition(int position, int[] nums) {
                if (memo[position] != Index.UNKNOWN) {
                    return memo[position] == Index.GOOD ? true : false;
                }

                int furthestJump = Math.min(
                    position + nums[position],
                    nums.length - 1
                );
                for (
                    int nextPosition = furthestJump;
                    nextPosition > position;
                    nextPosition--
                ) {
                    if (canJumpFromPosition(nextPosition, nums)) {
                        memo[position] = Index.GOOD;
                        return true;
                    }
                }

                memo[position] = Index.BAD;
                return false;
            }

            public boolean canJump(int[] nums) {
                this.memo = new Index[nums.length];
                for (int i = 0; i < memo.length; i++) {
                    memo[i] = Index.UNKNOWN;
                }
                memo[memo.length - 1] = Index.GOOD;
                return canJumpFromPosition(0, nums);
            }
        }
    }

    /**
     * Bottom-up DP
     * Time complexity: O(n^2)
     * Space complexity: O(n), since memo
     */
    class Solution3 {

        public boolean canJump(int[] nums) {
            Boolean[] memo = new Boolean[nums.length];
            memo[nums.length - 1] = true;

            for (int i = nums.length - 2; i >= 0; i--) {
                int furthestJump = Math.min(i + nums[i], nums.length - 1);

                for (int j = i + 1; j <= furthestJump; j++) {
                    if (memo[j] != null && memo[j] == true) {
                        memo[i] = true;
                        break;
                    }
                }
            }

            return memo[0] != null && memo[0] == true;
        }
    }
}
