package LeetCode150.Array_String;

public class LeetCode21_MergeTwoSortedLists {

    class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Recursion
     *
     * Time complexity: O(N + M)
     *
     * Space complexity: O(N + M), the first call to mergeTwoLists does not return
     * until the ends of both list1 and list2 have been reached,
     * so (N + M) stack frames consume O(N + M) space
     */
    class Solution1 {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            } else if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }

    /**
     * Iteration with a "false" prehead
     *
     * Time complexity: O(N + M)
     *
     * Space complexity: O(1)
     */
    class Solution2 {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // Maintain an unchanging reference to node ahead of the return node
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    prev.next = list1;
                    list1 = list1.next;
                } else {
                    prev.next = list2;
                    list2 = list2.next;
                }
                prev = prev.next;
            }

            // At least one of list1 and list2 can still have nodes at this point,
            // so connect the non-null list to the end of the merged list.
            prev.next = list1 == null ? list2 : list1;

            return prehead.next;
        }
    }

    /**
     * A clearer approach for Iteration
     *
     * Time complexity: O(N + M)
     *
     * Space complexity: O(1)
     */
    class Solution3 {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode prehead = new ListNode(-1);
            // Harmonizing pointers
            ListNode p = prehead;
            ListNode p1 = list1;
            ListNode p2 = list2;

            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }

            p.next = p1 == null ? p2 : p1;
            return prehead.next;
        }
    }
}
