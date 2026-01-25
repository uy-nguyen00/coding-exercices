import java.util.List;

public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {
        if (q == null || q.isEmpty()) {
            System.out.println(0);
            return;
        }

        int bribes = 0;
        for (
            int currentIndex = q.size() - 1;
            currentIndex >= 0;
            currentIndex--
        ) {
            int stickerNumber = q.get(currentIndex);
            int currentPositionInLine = currentIndex + 1;

            if (stickerNumber - currentPositionInLine > 2) {
                System.out.println("Too chaotic");
                return;
            }

            // Count the number of people ahead of the current person who have
            // larger sticker numbers (meaning they were originally behind).
            // We only need to check people who COULD have bribed the current person.
            for (
                int j = Math.max(0, stickerNumber - 2);
                j < currentIndex;
                j++
            ) {
                // If q.get(j) > stickerNumber, it means person 'j' bribed the current person.
                if (q.get(j) > stickerNumber) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        // Test Cases
        minimumBribes(List.of(2, 1, 5, 3, 4)); // Expected: 3
        minimumBribes(List.of(2, 5, 1, 3, 4)); // Expected: Too chaotic
        minimumBribes(List.of(1, 2, 3, 4, 5)); // Expected: 0
        minimumBribes(List.of(1, 2, 5, 3, 7, 8, 6, 4)); // Expected: 7
        minimumBribes(List.of(5, 1, 2, 3, 7, 8, 6, 4)); // Expected: Too chaotic
        minimumBribes(List.of(1, 2, 5, 3, 4, 7, 8, 6)); //Expected: 4
    }
}
