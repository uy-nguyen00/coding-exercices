/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Map<TreeNode, TreeNode> parentMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
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

    private void buildParentMap(TreeNode node, TreeNode parentNode) {
        if (node == null) return;

        this.parentMap.put(node, parentNode);
        this.buildParentMap(node.left, node);
        this.buildParentMap(node.right, node);
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