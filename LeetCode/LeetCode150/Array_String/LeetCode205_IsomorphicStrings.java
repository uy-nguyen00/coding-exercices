package LeetCode150.Array_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode205_IsomorphicStrings {

    /**
     * Using 2 arrays
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(1)
     */
    class Solution1 {

        public boolean isIsomorphic(String s, String t) {
            int[] mappingDictStoT = new int[256];
            Arrays.fill(mappingDictStoT, -1);

            int[] mappingDictTtoS = new int[256];
            Arrays.fill(mappingDictTtoS, -1);

            for (int i = 0; i < s.length(); ++i) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                // Case 1: No mapping exists in either of the dictionaries
                if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                    mappingDictStoT[c1] = c2;
                    mappingDictTtoS[c2] = c1;
                }
                // Case 2: Either mapping doesn't exist in one of the dictionaries or Mapping exists and
                // it doesn't match in either of the dictionaries or both
                else if (
                    !(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)
                ) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * Using 2 HashMap
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(N)
     */
    class Solution2 {

        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;

            Map<Character, Character> mapS2T = new HashMap<>();
            Map<Character, Character> mapT2S = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);

                if (mapS2T.containsKey(charS) && mapS2T.get(charS) != charT) {
                    return false;
                }

                if (mapT2S.containsKey(charT) && mapT2S.get(charT) != charS) {
                    return false;
                }

                mapS2T.put(charS, charT);
                mapT2S.put(charT, charS);
            }

            return true;
        }
    }

    /**
     * Using arrays instead of HashMap
     *
     * Time complexity: O(N)
     *
     * Space complexity: O(1)
     *
     * ==============================
     * Example 1: s = "egg"; t = "add"
     * Initial: mapS = [0,0,0,...], mapT = [0,0,0,...]
     *
     * i=0: charS='e'(101), charT='a'(97)
     * mapS[101] == mapT[97]? (0 == 0) ✅ Yes
     * mapS[101] = 1, mapT[97] = 1
     *
     * i=1: charS='g'(103), charT='d'(100)
     * mapS[103] == mapT[100]? (0 == 0) ✅ Yes
     * mapS[103] = 2, mapT[100] = 2
     *
     * i=2: charS='g'(103), charT='d'(100)
     * mapS[103] == mapT[100]? (2 == 2) ✅ Yes
     * mapS[103] = 3, mapT[100] = 3
     *
     * Return true ✅
     * ==============================
     * Example 2: s = "badc"; t = "baba"
     *
     * i=0: charS='b', charT='b'
     * mapS['b'] == mapT['b']? (0 == 0) ✅
     * mapS['b'] = 1, mapT['b'] = 1
     *
     * i=1: charS='a', charT='a'
     * mapS['a'] == mapT['a']? (0 == 0) ✅
     * mapS['a'] = 2, mapT['a'] = 2
     *
     * i=2: charS='d', charT='b'
     * mapS['d'] == mapT['b']? (0 == 1) ❌ No!
     *
     * Return false ❌
     */
    class Solution3 {

        public boolean isIsomorphic(String s, String t) {
            int[] mapS = new int[256];
            int[] mapT = new int[256];

            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);

                if (mapS[charS] != mapT[charT]) {
                    return false;
                }

                mapS[charS] = i + 1;
                mapT[charT] = i + 1;
            }

            return true;
        }
    }
}
