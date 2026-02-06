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
}
