package LeetCode150.Array_String;

import java.util.ArrayDeque;

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

    /**
     * Iteration
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution {

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;

            var nodeStack = new ArrayDeque<TreeNode>();
            var sumStack = new ArrayDeque<Integer>();
            nodeStack.add(root);
            sumStack.add(targetSum - root.val);

            while (!nodeStack.isEmpty()) {
                var node = nodeStack.pop();
                var currentSum = sumStack.pop();
                if (
                    node.right == null && node.left == null && currentSum == 0
                ) return true;

                if (node.right != null) {
                    nodeStack.add(node.right);
                    sumStack.add(currentSum - node.right.val);
                }
                if (node.left != null) {
                    nodeStack.add(node.left);
                    sumStack.add(currentSum - node.left.val);
                }
            }

            return false;
        }
    }
}
