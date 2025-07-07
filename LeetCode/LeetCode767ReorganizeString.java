class LeetCode767ReorganizeString {
    public static String reorganizeString(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        int[] counts = new int[26];
        int maxFreq = 0;
        char maxChar = ' ';

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            counts[index]++;
            if (counts[index] > maxFreq) {
                maxFreq = counts[index];
                maxChar = c;
            }
        }

        if (maxFreq > (n + 1) / 2) {
            return "";
        }

        char[] result = new char[n];
        int idx = 0;

        while(counts[maxChar - 'a'] > 0) {
            result[idx] = maxChar;
            idx += 2;
            counts[maxChar - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            char currentChar = (char) ('a' + i);
            while (counts[i] > 0) {
                if (idx >= n) {
                    idx = 1;
                }
                result[idx] = currentChar;
                idx += 2;
                counts[i]--;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}

/**
 * Test cases:
 *
 * 1. s = "aab"
 * ---> Expected output: "aba"
 *
 * 2. s = "aaab"
 * ---> Expected output: ""
 */