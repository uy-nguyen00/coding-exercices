package LeetCode150.Array_String;

public class LeetCode28_FindIndexOfFirstOccurrenceString {

    /**
     * Using built-in function
     *
     * Time complexity: O(N*M)
     *
     * Space complexity: O(1)
     */
    class Solution1 {

        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }

    /**
     * Sliding Window
     *
     * Time complexity: O(N*M)
     *
     * Space complexity: O(1)
     */
    class Solution2 {

        public int strStr(String haystack, String needle) {
            int m = needle.length();
            int n = haystack.length();

            for (int windowStart = 0; windowStart <= n - m; windowStart++) {
                for (int i = 0; i < m; i++) {
                    if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
                        break;
                    }
                    if (i == m - 1) {
                        return windowStart;
                    }
                }
            }

            return -1;
        }
    }
}
