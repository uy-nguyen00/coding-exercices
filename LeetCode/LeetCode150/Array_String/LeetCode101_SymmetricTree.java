package LeetCode150.Array_String;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * Iteration
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution2 {

        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode t1 = q.poll();
                TreeNode t2 = q.poll();
                if (t1 == null && t2 == null) continue;
                if (t1 == null || t2 == null) return false;
                if (t1.val != t2.val) return false;
                q.add(t1.left);
                q.add(t2.right);
                q.add(t1.right);
                q.add(t2.left);
            }
            return true;
        }
    }
}
