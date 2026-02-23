package LeetCode150.Array_String;

public class LeetCode100_SameTree {

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
     * Space complexity: O(N) in the worst case of completely unbalanced tree,
     * to keep a recursion stack
     */
    class Solution1 {

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;

            if (q == null || p == null) return false;

            if (p.val != q.val) return false;

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
