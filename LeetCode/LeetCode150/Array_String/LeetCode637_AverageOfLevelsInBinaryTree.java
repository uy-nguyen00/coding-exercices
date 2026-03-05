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
}
