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
     * Time complexity: O(h*n)
     *
     * Space complexity: O(1)
     */
    class Solution2 {

        public int strStr(String haystack, String needle) {
            int h = haystack.length();
            int n = needle.length();

            for (int windowStart = 0; windowStart <= h - n; windowStart++) {
                for (int i = 0; i < n; i++) {
                    if (haystack.charAt(windowStart + i) != needle.charAt(i)) {
                        break;
                    }

                    if (i == n - 1) return windowStart;
                }
            }

            return -1;
        }
    }
}
