package LeetCode150.Array_String;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
    class Solution1 {

        public List<Double> averageOfLevels(TreeNode root) {
            var avgs = new ArrayList<Double>();
            var queue = new ArrayDeque<TreeNode>();
            queue.add(root);

            while (!queue.isEmpty()) {
                long sum = 0;
                long count = 0;
                var nextLevelQueue = new ArrayDeque<TreeNode>();

                while (!queue.isEmpty()) {
                    var currentNode = queue.poll();
                    sum += currentNode.val;
                    count++;

                    if (currentNode.left != null) nextLevelQueue.add(
                        currentNode.left
                    );
                    if (currentNode.right != null) nextLevelQueue.add(
                        currentNode.right
                    );
                }

                queue = nextLevelQueue;
                avgs.add((sum * 1.0) / count);
            }

            return avgs;
        }
    }

    /**
     * Same as Solution1 except using a single queue
     */
    public class Solution1bis {

        public List<Double> averageOfLevels(TreeNode root) {
            var avgs = new ArrayList<Double>();
            var queue = new ArrayDeque<TreeNode>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                long sum = 0;

                for (int i = 0; i < size; i++) {
                    var node = queue.poll();
                    sum += node.val;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }

                avgs.add((double) sum / size);
            }

            return avgs;
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
