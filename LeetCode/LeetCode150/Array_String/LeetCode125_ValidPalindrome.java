package LeetCode150.Array_String;

public class LeetCode125_ValidPalindrome {

    /**
     * Compare with reverse
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution1 {

        public boolean isPalindrome(String s) {
            StringBuilder builder = new StringBuilder();

            s
                .chars()
                .filter(c -> Character.isLetterOrDigit(c))
                .mapToObj(c -> Character.toLowerCase((char) c))
                .forEach(builder::append);

            return builder.toString().equals(builder.reverse().toString());
        }
    }

    /**
     * Two Pointers
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(1)
     */
    class Solution2 {

        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                // Skip non-alphanumeric from both sides
                while (left < right && !isAlphanumeric(s.charAt(left))) {
                    left++;
                }
                while (left < right && !isAlphanumeric(s.charAt(right))) {
                    right--;
                }

                // Compare normalized characters
                if (!charsEqual(s.charAt(left), s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }

        private boolean isAlphanumeric(char c) {
            return Character.isLetterOrDigit(c);
        }

        private boolean charsEqual(char a, char b) {
            return Character.toLowerCase(a) == Character.toLowerCase(b);
        }
    }
}
