import java.util.List;

public class Abbreviation {

    public static String abbreviation(String a, String b) {
        /** 
        I will use dynamic programming (tabulation) with a 2D boolean table 
        to track whether prefixes of 'a' can be transformed into prefixes of 'b'. 
        This approach will have O(|a|*|b|) time and space complexity
        **/

        int n = a.length();
        int m = b.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case : empty string 'a' can transform to empty string 'b'
        dp[0][0] = true;

        /** 
        Optimization: Fill the first column.  
        An empty 'b' can be matched 
        only if the prefix of 'a' consists of all lowercase letters (which can be deleted).
        **/
        for (int i = 1; i <= n; i++) {
            if (Character.isLowerCase(a.charAt(i - 1))) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = false; // Uppercase can't be deleted
            }
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            char charA = a.charAt(i - 1);

            for (int j = 1; j <= m; j++) {
                // Start j from 1 (no need to re-check the first column)
                char charB = b.charAt(j - 1);

                if (Character.isLowerCase(charA)) {
                    // Delete or capitalize
                    dp[i][j] =
                        dp[i - 1][j] ||
                        (Character.toUpperCase(charA) == charB &&
                            dp[i - 1][j - 1]);
                } else {
                    // Must match
                    dp[i][j] = (charA == charB) && dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m] ? "YES" : "NO";
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(abbreviation("daBcd", "ABC")); // YES
        System.out.println(abbreviation("AbcDE", "ABDE")); // YES
        System.out.println(abbreviation("AbcDE", "AFDE")); // NO
        System.out.println(abbreviation("beFgH", "EFH")); // YES
        System.out.println(abbreviation("beFgH", "EFG")); // NO
        System.out.println(abbreviation("BFZZ", "BFZ")); // NO
        System.out.println(abbreviation("A", "A")); // YES
        System.out.println(abbreviation("a", "A")); // YES
        System.out.println(abbreviation("a", "")); // YES
        System.out.println(abbreviation("", "A")); // NO
    }
}
