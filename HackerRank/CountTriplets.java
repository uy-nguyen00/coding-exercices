import java.util.*;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        if (arr == null || arr.size() < 3) {
            return 0;
        }

        Map<Long, Long> potentialPairs = new HashMap<>();
        Map<Long, Long> completedTriplets = new HashMap<>();
        long count = 0;

        for (long num : arr) {
            //Check for completed triplets
            if (completedTriplets.containsKey(num)) {
                count += completedTriplets.get(num);
            }

            // If this number could be the *second* element of a triplet,
            // update the count of potential *third* elements.
            if (potentialPairs.containsKey(num)) {
                completedTriplets.put(
                    num * r,
                    completedTriplets.getOrDefault(num * r, 0L) +
                        potentialPairs.get(num)
                );
            }

            // This number could be the *first* element of a triplet.
            // Update the count of potential *second* elements.
            potentialPairs.put(
                num * r,
                potentialPairs.getOrDefault(num * r, 0L) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(countTriplets(Arrays.asList(1L, 4L, 16L, 64L), 4)); // Expected: 2
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2)); // Expected: 2
        System.out.println(
            countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3)
        ); // Expected: 6
        System.out.println(
            countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5)
        ); // Expected: 4
        System.out.println(countTriplets(Arrays.asList(1L, 1L, 1L, 1L), 1)); // Expected: 4
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 4L), 2)); // Expected 1;
        System.out.println(countTriplets(Arrays.asList(1L), 2)); //Expected 0
        System.out.println(countTriplets(Arrays.asList(1L, 2L), 2)); //Expected 0
        System.out.println(
            countTriplets(
                Arrays.asList(
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L,
                    1L
                ),
                1
            )
        ); //Expected 161700
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 1L, 2L, 4L), 2)); //Expected 3
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 1L, 2L, 4L), 2)); //Expected: 3
    }
}
