package LeetCode150.Array_String;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode637_AverageOfLevelsInBinaryTree {

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
     * BFS
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(M), where M is the maximum number of nodes at any level in the input tree
     */
    public class Solution1 {

        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                long sum = 0,
                    count = 0;
                Deque<TreeNode> temp = new ArrayDeque<>();

                while (!queue.isEmpty()) {
                    TreeNode n = queue.remove();
                    sum += n.val;
                    count++;

                    if (n.left != null) temp.add(n.left);
                    if (n.right != null) temp.add(n.right);
                }

                queue = temp;
                res.add((sum * 1.0) / count);
            }

            return res;
        }
    }

    /**
     * DFS
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(H), where H is the height of the tree
     */
    public class Solution2 {

        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> sums = new ArrayList<>();
            List<Integer> counts = new ArrayList<>();
            dfs(root, 0, sums, counts);
            for (int level = 0; level < sums.size(); level++) {
                sums.set(level, sums.get(level) / counts.get(level));
            }
            return sums;
        }

        private void dfs(
            TreeNode node,
            int level,
            List<Double> sums,
            List<Integer> counts
        ) {
            if (node == null) return;
            if (level < sums.size()) {
                sums.set(level, sums.get(level) + node.val);
                counts.set(level, counts.get(level) + 1);
            } else {
                sums.add((double) node.val);
                counts.add(1);
            }
            dfs(node.left, level + 1, sums, counts);
            dfs(node.right, level + 1, sums, counts);
        }
    }
}
