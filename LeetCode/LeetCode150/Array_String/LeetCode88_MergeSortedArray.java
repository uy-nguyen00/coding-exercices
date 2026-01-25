package LeetCode150.Array_String;

import java.util.Arrays;

public class LeetCode88_MergeSortedArray {

    // Time complexity: O((n + m) log(n + m))
    // Space complexity: O(n)
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    // Time complexity: O(n + m)
    // Space complexity: O(m)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        // Read pointers for nums1Copy and nums2
        int p1 = 0;
        int p2 = 0;

        // Compare elements from nums1Copy and nums2 and write the smallest to nums1
        for (int p = 0; p < m + n; p++) {
            // Check for out-of-bound cases of each array
            if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
                nums1[p] = nums1Copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
    }

    // Time complexity: O(n + m)
    // Space complexity: O(1)
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        // Set pointers to the end of nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;

        // Move the 3rd pointer through the array, each time writing
        // the largest value pointed at by p1 and p2
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}
