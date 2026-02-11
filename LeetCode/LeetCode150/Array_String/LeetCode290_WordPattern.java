package LeetCode150.Array_String;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290_WordPattern {

    /**
     * Using 2 HashMap
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(1), since lower case English letters and spaces
     */
    class Solution1 {

        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            if (words.length != pattern.length()) return false;

            Map<Character, String> charToWord = new HashMap<>();
            Map<String, Character> wordToChar = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                char c = pattern.charAt(i);
                String w = words[i];

                // Check character -> word mapping
                if (charToWord.containsKey(c)) {
                    if (!charToWord.get(c).equals(w)) {
                        return false;
                    }
                } else {
                    charToWord.put(c, w);
                }

                // Check word -> character mapping
                if (wordToChar.containsKey(w)) {
                    if (wordToChar.get(w) != c) {
                        return false;
                    }
                } else {
                    wordToChar.put(w, c);
                }
            }

            return true;
        }
    }
}
