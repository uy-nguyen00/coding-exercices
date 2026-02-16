package LeetCode150.Array_String;

import java.util.HashSet;
import java.util.Set;

public class LeetCode217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) return true;
        }
        return false;
    }
}
