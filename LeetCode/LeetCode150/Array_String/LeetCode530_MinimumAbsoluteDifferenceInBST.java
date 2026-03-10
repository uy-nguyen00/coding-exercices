package LeetCode150.Array_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode530_MinimumAbsoluteDifferenceInBST {

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
     * DFS
     *
     * Time complexity: O(N logN)
     *
     * Space complexity: O(N)
     */
    class Solution1 {

        // List to store the node values.
        List<Integer> nodeValues = new ArrayList<>();

        void dfs(TreeNode node) {
            if (node == null) {
                return;
            }

            nodeValues.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }

        int getMinimumDifference(TreeNode root) {
            dfs(root);

            Collections.sort(nodeValues);
            int minDifference = Integer.MAX_VALUE;
            // Find the diff between every two consecutive values in the list.
            for (int i = 1; i < nodeValues.size(); i++) {
                minDifference = Math.min(
                    minDifference,
                    nodeValues.get(i) - nodeValues.get(i - 1)
                );
            }

            return minDifference;
        }
    }
}
