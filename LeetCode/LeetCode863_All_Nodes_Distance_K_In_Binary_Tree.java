/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class LeetCode863_All_Nodes_Distance_K_In_Binary_Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    private static Map<TreeNode, TreeNode> parentMap;

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null || k < 0) {
            return result;
        }

        // 1. Build map where key=node, value=parent node
        parentMap = new HashMap<>();
        buildParentMap(root, null); // DFS to populate the map

        // 2. Initialize BFS structures
        Queue<TreeNode> queue = new LinkedList<>(); // Queue for BFS
        Set<TreeNode> visited = new HashSet<>(); // Keep track of visited nodes

        // Start BFS from the target node
        queue.offer(target);
        visited.add(target);
        int currentDistance = 0;

        // 3. Perform Level-Order BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current distance level

            // If we've reached the target distance k
            if (currentDistance == k) {
                // All nodes currently in the queue are at distance k
                for (int i = 0; i < levelSize; i++) {
                    result.add(queue.poll().val);
                }
                return result; // Found all nodes at distance k
            }

            // Process nodes at the current level and add neighbors for the next level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Add neighbors (left, right, parent) if they exist and haven't been visited

                // Left Child
                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    visited.add(currentNode.left);
                    queue.offer(currentNode.left);
                }

                // Right Child
                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    visited.add(currentNode.right);
                    queue.offer(currentNode.right);
                }

                // Parent
                TreeNode parent = parentMap.get(currentNode);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
            // Move to the next distance level
            currentDistance++;
        }

        // If the loop finishes, k was larger than any reachable distance
        return result; // Result will be empty
    }

    private static void buildParentMap(TreeNode node, TreeNode parentNode) {
        if (node == null) return;

        parentMap.put(node, parentNode);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }

    public static void main(String[] args) {
        // Test case 1
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        System.out.println(distanceK(node1, node2, 2));

        //Test case 2
        TreeNode node10 = new TreeNode(1);
        System.out.println(distanceK(node10, node10, 3));
    }
}

/**
 * Test cases:
 *
 * 1. root = [3,5,1,6,2,0,8,null,null,7,4]
 *    target = 5
 *    k = 2
 *
 * ---> Expected output: [7,4,1]
 *
 * 2. root = [1]
 *    target = 1
 *    k = 3
 *
 * ---> Expected output: []
 */