package LeetCode150.Array_String;

public class LeetCode58_LengthOfLastWord {

    /**
     * Using built-in functions
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution1 {

        public int lengthOfLastWord(String s) {
            s = s.trim();
            return s.length() - s.lastIndexOf(" ") - 1;
        }
    }
}
