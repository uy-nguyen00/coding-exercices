package LeetCode150.Array_String;

public class LeetCode101_SymmetricTree {

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

        private boolean isMirror(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            return (
                left.val == right.val &&
                isMirror(left.left, right.right) &&
                isMirror(left.right, right.left)
            );
        }

        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isMirror(root.left, root.right);
        }
    }
}
