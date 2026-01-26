package LeetCode150.Array_String;

public class LeetCode45_JumpGame2 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
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
