import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return "NO";
        }

        Set<Character> s1Chars = new HashSet<>();
        for (char c : s1.toCharArray()) {
            s1Chars.add(c);
        }

        for (char c : s2.toCharArray()) {
            if (s1Chars.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(twoStrings("hello", "world")); // Expected: YES
        System.out.println(twoStrings("hi", "world")); // Expected: NO
        System.out.println(twoStrings("and", "art")); // Expected: YES
        System.out.println(twoStrings("be", "cat")); // Expected: NO
        System.out.println(twoStrings("a", "b")); // Expected: NO
        System.out.println(twoStrings("a", "a")); // Expected: YES
        System.out.println(twoStrings("", "a")); // Expected: NO
        System.out.println(twoStrings("a", "")); // Expected: NO
    }
}
