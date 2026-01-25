public class AlternatingCharacters {

    public static int alternatingCharacters(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int deletions = 0;
        char previousChar = ' '; // Initialize to a non-matching character

        for (char currentChar : s.toCharArray()) {
            if (currentChar == previousChar) {
                deletions++;
            } else {
                previousChar = currentChar;
            }
        }

        return deletions;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(alternatingCharacters("AAAA")); // Expected: 3
        System.out.println(alternatingCharacters("BBBBB")); // Expected: 4
        System.out.println(alternatingCharacters("ABABABAB")); // Expected: 0
        System.out.println(alternatingCharacters("BABABA")); // Expected: 0
        System.out.println(alternatingCharacters("AAABBB")); // Expected: 4
        System.out.println(alternatingCharacters("A")); // Expected: 0
        System.out.println(alternatingCharacters("")); // Expected: 0
        System.out.println(alternatingCharacters("ABBA")); // Expected: 1
    }
}
