package LeetCode150.Array_String;

public class LeetCode108_ConvertSortedArrayToBinarySearchTree {

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
     * Preorder Traversal
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(log N)
     */
    class Solution1 {

        private TreeNode helper(int[] nums, int left, int right) {
            if (left > right) return null;

            int mid = (left + right) / 2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid - 1);
            root.right = helper(nums, mid + 1, right);
            return root;
        }

        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
    }
}
