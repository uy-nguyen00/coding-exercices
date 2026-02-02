package LeetCode150.Array_String;

class LeetCode392_IsSubsequence {

    /**
     * Two-Pointers
     *
     * Time complexity: O(|T|), where |T| is the length of the target string
     *
     * Space complexity: O(1)
     */
    public boolean isSubsequence(String s, String t) {
        Integer leftBound = s.length(),
            rightBound = t.length();
        Integer pLeft = 0,
            pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }
}
