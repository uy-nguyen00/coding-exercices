import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomNote {

    public static void checkMagazine(List<String> magazine, List<String> note) {
        if (magazine == null || magazine.isEmpty()) {
            if (note != null && !note.isEmpty()) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
            return;
        }
        if (note == null || note.isEmpty()) {
            System.out.println("Yes");
            return;
        }

        Map<String, Integer> magazineWordCounts = new HashMap<>();
        for (String word : magazine) {
            magazineWordCounts.put(
                word,
                magazineWordCounts.getOrDefault(word, 0) + 1
            );
        }

        for (String word : note) {
            if (
                !magazineWordCounts.containsKey(word) ||
                magazineWordCounts.get(word) == 0
            ) {
                System.out.println("No");
                return;
            }
            magazineWordCounts.put(word, magazineWordCounts.get(word) - 1);
        }

        System.out.println("Yes");
    }

    public static void main(String[] args) {
        // Test Cases
        checkMagazine(
            List.of("give", "me", "one", "grand", "today", "night"),
            List.of("give", "one", "grand", "today")
        ); // Expected: Yes

        checkMagazine(
            List.of("two", "times", "three", "is", "not", "four"),
            List.of("two", "times", "two", "is", "four")
        ); // Expected: No

        checkMagazine(
            List.of("ive", "got", "a", "lovely", "bunch", "of", "coconuts"),
            List.of("ive", "got", "some", "coconuts")
        ); //Expected No

        checkMagazine(List.of(), List.of()); // Expected: Yes
        checkMagazine(List.of(), List.of("test")); //Expected: No
        checkMagazine(List.of("test"), List.of()); // Expected: Yes
        checkMagazine(
            List.of("attack", "at", "dawn"),
            List.of("Attack", "at", "dawn")
        ); //Expected: No
    }
}
