package LeetCode150.Array_String;

public class LeetCode14_LongestCommonString {

    /**
     * Approach 1: Horizontal scanning
     *
     * Time complexity: Time complexity: O(S), where S is the sum of all characters in all strings
     *
     * Space complexity: Space complexity: O(1), we only use constant extra space
     */
    class Solution1 {

        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";

            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) while (
                strs[i].indexOf(prefix) != 0
            ) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }

            return prefix;
        }
    }

    /**
     * Approach 2: Vertical Scanning
     *
     * Time complexity: O(S), where S is the sum of all characters in all strings
     *
     * Space complexity: O(1), we only use constant extra space
     */
    class Solution2 {

        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";

            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }

            return strs[0];
        }
    }
}
