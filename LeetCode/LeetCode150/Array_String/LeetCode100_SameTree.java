package LeetCode150.Array_String;

import java.util.ArrayDeque;
import java.util.Queue;

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

    /**
     * Iteration (BFS)
     *
     * Traverses both trees level-by-level using two parallel queues.
     * At each step, a pair of corresponding nodes is dequeued and their
     * children are validated before being enqueued for the next level.
     *
     * Note: Java's ArrayDeque does not allow null elements, so null children
     * are checked eagerly (before enqueueing) rather than being stored.
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution2 {

        private boolean nodesMatch(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            return p.val == q.val;
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (!nodesMatch(p, q)) return false;
            if (p == null) return true; // both are null

            Queue<TreeNode> queueP = new ArrayDeque<>();
            Queue<TreeNode> queueQ = new ArrayDeque<>();
            queueP.add(p);
            queueQ.add(q);

            while (!queueP.isEmpty()) {
                TreeNode nodeP = queueP.poll();
                TreeNode nodeQ = queueQ.poll();

                // Check left children; only enqueue if both are non-null
                if (!nodesMatch(nodeP.left, nodeQ.left)) return false;
                if (nodeP.left != null) {
                    queueP.add(nodeP.left);
                    queueQ.add(nodeQ.left);
                }

                // Check right children; only enqueue if both are non-null
                if (!nodesMatch(nodeP.right, nodeQ.right)) return false;
                if (nodeP.right != null) {
                    queueP.add(nodeP.right);
                    queueQ.add(nodeQ.right);
                }
            }
            return true;
        }
    }
}
