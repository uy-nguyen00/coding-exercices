package LeetCode150.Array_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LeetCode380_InsertDeleteGetRandomO1 {

    /**
     * HashMap + ArrayList
     *
     * Time complexity: O(1),
     * O(N) when the operation exceeds the capacity of currently allocated array/hashmap
     * and invokes space reallocation
     *
     * Space complexity: O(N), to store N elements
     */
    class RandomizedSet {

        Map<Integer, Integer> dict;
        List<Integer> list;
        Random rand = new Random();

        public RandomizedSet() {
            dict = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (dict.containsKey(val)) return false;

            dict.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }

        public boolean remove(int val) {
            if (!dict.containsKey(val)) return false;

            // move the last element to the place idx of the element to delete
            int lastElement = list.get(list.size() - 1);
            int idx = dict.get(val);
            list.set(idx, lastElement);
            dict.put(lastElement, idx);
            // delete the last element
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
