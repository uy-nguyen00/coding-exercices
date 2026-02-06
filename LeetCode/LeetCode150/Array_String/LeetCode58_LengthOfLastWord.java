package LeetCode150.Array_String;

public class LeetCode58_LengthOfLastWord {

    /**
     * Using built-in functions
     *
     * Time complexity: O(N), since String.trim() and String.lastIndexOf() have complexity of O(N)
     *
     * Space complexity: O(N), since String.trim() returns a copy of the input string
     */
    class Solution1 {

        public int lengthOfLastWord(String s) {
            s = s.trim();
            return s.length() - s.lastIndexOf(" ") - 1;
        }
    }

    /**
     * String Index Manipulation with 2 loops
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(1)
     */
    class Solution2 {

        public int lengthOfLastWord(String s) {
            // Remove trailing spaces
            int p = s.length() - 1;
            while (p >= 0 && s.charAt(p) == ' ') {
                p--;
            }

            int length = 0;
            while (p >= 0 && s.charAt(p) != ' ') {
                p--;
                length++;
            }

            return length;
        }
    }

    /**
     * One loop approach
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(1)
     */
    class Solution3 {

        public int lengthOfLastWord(String s) {
            int p = s.length() - 1;
            int length = 0;

            while (p >= 0) {
                if (s.charAt(p) != ' ') {
                    length++;
                } else if (length > 0) {
                    return length;
                }
                p--;
            }

            return length;
        }
    }
}
