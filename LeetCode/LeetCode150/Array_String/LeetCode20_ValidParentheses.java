package LeetCode150.Array_String;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Using Stacks
 *
 * Time complexity: O(N)
 *
 * Space complexity: O(N), as we push all opening brackets onto the stack
 * and in the worst case, we will end up pushing all the brackets onto
 * the stack, e.g. (((((((((((
 */
public class LeetCode20_ValidParentheses {

    private final HashMap<Character, Character> mappings = new HashMap<>(
        Map.of(')', '(', '}', '{', ']', '[')
    );

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
