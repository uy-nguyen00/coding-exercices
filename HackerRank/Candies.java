import java.util.Arrays;
import java.util.List;

public class Candies {

    public static long candies(int n, List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long[] candies = new long[n];
        Arrays.fill(candies, 1); // Initialize all to 1 candy

        // Left-to-right pass
        for (int i = 1; i < n; i++) {
            if (arr.get(i) > arr.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right-to-left pass
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) > arr.get(i + 1)) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate total candies
        long totalCandies = 0;
        for (long count : candies) {
            totalCandies += count;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(candies(3, List.of(1, 2, 2))); // Expected: 4
        System.out.println(candies(6, List.of(4, 6, 4, 5, 6, 2))); // Expected: 10
        System.out.println(candies(1, List.of(5))); // Expected: 1
        System.out.println(candies(5, List.of(5, 5, 5, 5, 5))); // Expected: 5
        System.out.println(candies(5, List.of(1, 2, 3, 4, 5))); // Expected: 15
        System.out.println(candies(5, List.of(5, 4, 3, 2, 1))); // Expected: 15
        System.out.println(candies(10, List.of(2, 4, 2, 6, 1, 7, 8, 9, 2, 1))); //Expected: 19
        System.out.println(candies(8, List.of(2, 4, 3, 5, 2, 6, 4, 5))); // Expected: 12
    }
}
