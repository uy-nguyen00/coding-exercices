import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList; // For testing example
import java.util.Arrays;    // For testing example
import java.util.Collections; // If choosing the Collections.max route

public class Solution {

    /**
     * Calculates the minimum number of operations to ship all products.
     *
     * @param locations A List containing the location ID for each product.
     * @return The minimum number of operations required.
     */
    public int minOperation(List<Integer> locations) {
        int n = locations.size();

        if (n == 0) {
            return 0;
        }

        // Step 1: Count frequencies of each location
        Map<Integer, Integer> locationCounts = new HashMap<>();
        // Enhanced for loop works seamlessly with List<Integer>
        for (int locationId : locations) {
            locationCounts.put(locationId, locationCounts.getOrDefault(locationId, 0) + 1);
        }

        // Step 2: Find the maximum frequency (maxCount)
        int maxCount = 0;
        // No need to check if map is empty because n > 0 guarantees elements
        for (int count : locationCounts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        // Alternatively using Collections.max (slightly more concise):
        // if (!locationCounts.isEmpty()) { // Still good practice for robustness
        //    maxCount = Collections.max(locationCounts.values());
        // }


        // Step 3: Calculate the general minimum ops based on pairing (ceil(n/2))
        // Using integer division: (n + 1) / 2 calculates ceil(n / 2.0)
        int generalOps = (n + 1) / 2;

        // Step 4: The result is the maximum of the bottleneck count and the general pairing minimum
        return Math.max(maxCount, generalOps);
    }

    // Example Usage (optional, for testing - updated to use List<Integer>)
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Using Arrays.asList for easy List creation
        List<Integer> locations1 = Arrays.asList(1, 8, 6, 7, 7);
        System.out.println("Example 1 Output: " + sol.minOperation(locations1)); // Expected: 3

        List<Integer> locations2 = Arrays.asList(1, 1, 1, 1, 8); // n=5, maxCount=4. Expected: 4
        System.out.println("Test Case 1 Output: " + sol.minOperation(locations2));

        List<Integer> locations3 = Arrays.asList(1, 2, 3, 4, 5); // n=5, maxCount=1. Expected: 3
        System.out.println("Test Case 2 Output: " + sol.minOperation(locations3));

        List<Integer> locations4 = Arrays.asList(1, 1, 2, 2); // n=4, maxCount=2. Expected: 2
        System.out.println("Test Case 3 Output: " + sol.minOperation(locations4));

        List<Integer> locations5 = Arrays.asList(1); // n=1, maxCount=1. Expected: 1
        System.out.println("Test Case 4 Output: " + sol.minOperation(locations5));

        // Using List.of() (for Java 9+) or Collections.emptyList()
        List<Integer> locations6 = Collections.emptyList(); // n=0. Expected: 0
        // List<Integer> locations6 = List.of(); // Java 9+ alternative
        System.out.println("Test Case 5 Output: " + sol.minOperation(locations6));
    }
}