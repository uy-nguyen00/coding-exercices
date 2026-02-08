package LeetCode150.Array_String;

import java.util.HashMap;
import java.util.Map;

public class LeetCode383_RansomNote {

    /**
     * Using HashMap
     *
     * Time complexity: O(R + M) = O(M), since M > R
     *
     * Space complexity: O(k) = O(1), since k <= 26
     */
    class Solution1 {

        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }

            Map<Character, Integer> charCount = new HashMap<>();

            for (char c : magazine.toCharArray()) {
                charCount.merge(c, 1, Integer::sum);
            }

            for (char c : ransomNote.toCharArray()) {
                int count = charCount.getOrDefault(c, 0);
                if (count == 0) return false;
                charCount.put(c, count - 1);
            }

            return true;
        }
    }

    /**
     * Using fixed-size array
     *
     * Time complexity: O(M)
     *
     * Space complexity: O(1)
     */
    class Solution2 {

        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }

            int[] charCount = new int[26];

            for (char c : magazine.toCharArray()) {
                charCount[c - 'a']++;
            }

            for (char c : ransomNote.toCharArray()) {
                if (--charCount[c - 'a'] < 0) return false;
            }

            return true;
        }
    }
}
