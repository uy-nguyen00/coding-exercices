import java.util.ArrayList;
import java.util.List;

public class LeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        if (a == null || a.isEmpty()) {
            return new ArrayList<>(); // Return an empty list if input is empty
        }

        int n = a.size();
        int effectiveRotations = d % n;

        if (effectiveRotations == 0) {
            return new ArrayList<>(a); // Return a copy if no rotation needed
        }
        List<Integer> rotatedList = new ArrayList<>(a);

        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveRotations) % n;
            rotatedList.set(i, a.get(newIndex));
        }

        return rotatedList;
    }

    public static void main(String[] args) {
        // Test Cases
        List<Integer> a1 = List.of(1, 2, 3, 4, 5);
        int d1 = 4;
        System.out.println("Test Case 1: " + rotLeft(a1, d1)); // Expected: [5, 1, 2, 3, 4]

        List<Integer> a2 = List.of(1, 2, 3, 4, 5);
        int d2 = 0;
        System.out.println("Test Case 2: " + rotLeft(a2, d2)); // Expected: [1, 2, 3, 4, 5]

        List<Integer> a3 = List.of(1, 2, 3, 4, 5);
        int d3 = 5;
        System.out.println("Test Case 3: " + rotLeft(a3, d3)); // Expected: [1, 2, 3, 4, 5]

        List<Integer> a4 = List.of(1, 2, 3, 4, 5);
        int d4 = 2;
        System.out.println("Test Case 4: " + rotLeft(a4, d4)); // Expected: [3, 4, 5, 1, 2]

        List<Integer> a5 = List.of(1, 2, 3, 4, 5);
        int d5 = 7; // d > n
        System.out.println("Test Case 5: " + rotLeft(a5, d5)); // Expected: [3, 4, 5, 1, 2]
    }
}