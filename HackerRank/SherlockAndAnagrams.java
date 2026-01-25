import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagramsSorted {

    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> substringFrequencies = new HashMap<>();

        // Generate all substrings and their canonical representations
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                String canonicalString = getCanonicalString(substring); // Use sorting
                substringFrequencies.put(
                    canonicalString,
                    substringFrequencies.getOrDefault(canonicalString, 0) + 1
                );
            }
        }

        // Calculate the number of anagrammatic pairs
        int anagramPairs = 0;
        for (int frequency : substringFrequencies.values()) {
            anagramPairs += (frequency * (frequency - 1)) / 2;
        }

        return anagramPairs;
    }

    // Helper function to create a canonical representation (sorting)
    private static String getCanonicalString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(sherlockAndAnagrams("abba")); // Expected: 4
        System.out.println(sherlockAndAnagrams("abcd")); // Expected: 0
        System.out.println(sherlockAndAnagrams("ifailuhkqq")); // Expected: 3
        System.out.println(sherlockAndAnagrams("kkkk")); // Expected: 10
        System.out.println(sherlockAndAnagrams("cdcd")); // Expected: 5
        System.out.println(sherlockAndAnagrams("mom")); // Expected: 2
    }
}
