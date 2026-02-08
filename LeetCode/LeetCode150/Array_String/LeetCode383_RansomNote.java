package LeetCode150.Array_String;

import java.util.HashMap;
import java.util.Map;

public class LeetCode383_RansomNote {

    /**
     * Using HashMap
     *
     * Time complexity: O(R + M)
     *
     * Space complexity: O(M)
     */
    class Solution1 {

        public boolean canConstruct(String ransomNote, String magazine) {
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
}
