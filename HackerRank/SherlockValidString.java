import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SherlockValidString {

    public static String isValid(String s) {
        if (s == null || s.isEmpty()) {
            return "YES";
        }

        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Use a List to store distinct frequencies.
        List<Integer> frequencies = new ArrayList<>();
        for (int freq : charCounts) {
            if (freq > 0 && !frequencies.contains(freq)) {
                frequencies.add(freq);
            }
        }

        if (frequencies.size() == 1) {
            return "YES";
        }

        if (frequencies.size() > 2) {
            return "NO";
        }

        // Exactly two distinct frequencies.
        int freq1 = frequencies.get(0);
        int freq2 = frequencies.get(1);

        int freq1Count = 0;
        int freq2Count = 0;
        for (int count : charCounts) {
            if (count == freq1) {
                freq1Count++;
            } else if (count == freq2) {
                freq2Count++;
            }
        }

        //Case 1: One of the frequency is 1, and only appears once.
        if (
            (freq1 == 1 && freq1Count == 1) || (freq2 == 1 && freq2Count == 1)
        ) {
            return "YES";
        }

        //Case 2: The difference between the frequency is 1. And only one instance of the bigger frequency exist.
        if (
            (Math.abs(freq1 - freq2) == 1) && (freq1 > freq2 && freq1Count == 1)
        ) {
            return "YES"; // Removing one instance makes it valid
        }

        if (
            (Math.abs(freq1 - freq2) == 1) && (freq2 > freq1 && freq2Count == 1)
        ) {
            return "YES"; // Removing one instance makes it valid
        }

        return "NO";
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(isValid("abc")); // YES
        System.out.println(isValid("abcc")); // YES
        System.out.println(isValid("abccc")); // NO
        System.out.println(isValid("aabbcd")); // NO
        System.out.println(isValid("aabbcc")); // YES
        System.out.println(isValid("aabbc")); // YES
        System.out.println(isValid("")); // YES
        System.out.println(isValid("a")); //YES
        System.out.println(isValid("abcdefghhgfedecba")); // YES
    }
}
