package LeetCode150.Array_String;

public class LeetCode112_PathSum {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Recursion
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution1 {

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;

            targetSum -= root.val;
            if (root.left == null && root.right == null) return targetSum == 0;
            return (
                hasPathSum(root.left, targetSum) ||
                hasPathSum(root.right, targetSum)
            );
        }
    }
}
