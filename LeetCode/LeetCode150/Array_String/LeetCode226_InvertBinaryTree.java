package LeetCode150.Array_String;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode226_InvertBinaryTree {

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

        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            TreeNode right = invertTree(root.right);
            TreeNode left = invertTree(root.left);

            root.left = right;
            root.right = left;

            return root;
        }
    }

    /**
     * Iteration with DFS
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution2 {

        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }

            return root;
        }
    }
}
