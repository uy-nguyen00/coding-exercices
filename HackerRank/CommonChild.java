public class CommonChild {

    public static int commonChild(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return 0;
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialization (first row and column are already 0) is not needed.

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char char1 = s1.charAt(i - 1);
                char char2 = s2.charAt(j - 1);

                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(commonChild("HARRY", "SALLY")); // Expected: 2
        System.out.println(commonChild("AA", "BB")); // Expected: 0
        System.out.println(commonChild("SHINCHAN", "NOHARAA")); // Expected: 3
        System.out.println(commonChild("ABCDEF", "FBDAMN")); // Expected: 2
        System.out.println(commonChild("", "")); // Expected: 0
        System.out.println(commonChild("A", "")); // Expected: 0
        System.out.println(commonChild("", "B")); // Expected: 0
        System.out.println(commonChild("ABCD", "ABDC")); //Expected 3
    }
}
