package LeetCode150.Array_String;

public class LeetCode242_ValidAnagram {

    /**
     * Counting frenquencies with fixed-size array
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(1)
     *
     * Note: Another solution is sorting both strings and compare the results.
     * However, the complexity would be O(n logn), since Arrays.sort() cost O(n logn),
     * and Arrays.equals() costs O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) return false;
        }

        return true;
    }
}
