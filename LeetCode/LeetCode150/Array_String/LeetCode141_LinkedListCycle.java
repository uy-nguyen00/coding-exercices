package LeetCode150.Array_String;

import java.util.HashSet;
import java.util.Set;

public class LeetCode141_LinkedListCycle {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Using Hash Table
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution1 {

        public boolean hasCycle(ListNode head) {
            Set<ListNode> nodesSeen = new HashSet<>();
            ListNode currentNode = head;
            while (currentNode != null) {
                if (nodesSeen.contains(currentNode)) return true;
                nodesSeen.add(currentNode);
                currentNode = currentNode.next;
            }
            return false;
        }
    }

    /**
     * Using Floyd's Finding Algorithm
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(1)
     */
    class Solution2 {

        public boolean hasCycle(ListNode head) {
            if (head == null) return false;

            ListNode slowPointer = head;
            ListNode fastPointer = head.next;

            while (slowPointer != fastPointer) {
                if (fastPointer == null || fastPointer.next == null) {
                    return false;
                }

                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }

            return true;
        }
    }
}
