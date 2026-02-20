package LeetCode150.Array_String;

import java.util.HashSet;
import java.util.Set;

public class LeetCode202_HappyNumber {

    /**
     * Detect Cycle with a HashSet
     *
     * Time complexity: O(log N)
     *
     * Space complexity: O(log N)
     */
    class Solution1 {

        private int getNext(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }

        public boolean isHappy(int n) {
            Set<Integer> seen = new HashSet<>();
            while (n != 1 && !seen.contains(n)) {
                seen.add(n);
                n = getNext(n);
            }
            return n == 1;
        }
    }

    /**
     * Floyd's Cycle Finding Algorithm
     *
     * Time complexity: O(log N)
     *
     * Space complexity: O(1)
     */
    class Solution2 {

        private int getNext(int n) {
            int totalSum = 0;
            int d = n % 10;
            while (n > 0) {
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }

        public boolean isHappy(int n) {
            int slowRunner = n;
            int fastRunner = getNext(n);

            while (slowRunner != fastRunner && fastRunner != 1) {
                slowRunner = getNext(slowRunner);
                fastRunner = getNext(getNext(fastRunner));
            }

            return fastRunner == 1;
        }
    }
}
