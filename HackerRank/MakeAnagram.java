public class MakeAnagram {

    public static int makeAnagram(String a, String b) {
        if (a == null && b == null) {
            return 0;
        }
        if (a == null || a.length() == 0) {
            return b.length();
        }
        if (b == null || b.length() == 0) {
            return a.length();
        }

        int[] aCounts = new int[26];
        int[] bCounts = new int[26];

        // Populate aCounts
        for (char c : a.toCharArray()) {
            aCounts[c - 'a']++;
        }

        // Populate bCounts
        for (char c : b.toCharArray()) {
            bCounts[c - 'a']++;
        }

        // Calculate deletions
        int deletions = 0;
        for (int i = 0; i < 26; i++) {
            deletions += Math.abs(aCounts[i] - bCounts[i]);
        }

        return deletions;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(makeAnagram("cde", "abc")); // Expected: 4
        System.out.println(makeAnagram("cde", "dcf")); // Expected: 2
        System.out.println(makeAnagram("bacdc", "dcbac")); // Expected: 0
        System.out.println(makeAnagram("bacdc", "dcbad")); // Expected: 2
        System.out.println(makeAnagram("", "")); // Expected: 0
        System.out.println(makeAnagram("a", "")); // Expected: 1
        System.out.println(makeAnagram("", "abc")); // Expected: 3
        System.out.println(makeAnagram("a", "aaa")); // Expected: 2
    }
}
