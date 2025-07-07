import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

    public static long substrCount(int n, String s) {
        int result = 0;
        int i = 0;

        while (i < n) {
            int charCount = 1;
            
            while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                charCount++;
            }
            
            result += charCount * (charCount + 1) / 2;
            i++;
        }
        
        for (int j = 1; j < n; j++) {
            int charCount = 1;
                
            while (
                j + charCount < n &&
                j - charCount >= 0 &&
                s.charAt(j) != s.charAt(j - 1) &&
                s.charAt(j - charCount) == s.charAt(j + charCount) &&
                s.charAt(j - 1) == s.charAt(j - charCount)
            ) {
                charCount++;
            }
                
            result += charCount - 1;            
        }
        
        return result;
    }

    public static void main(String[] args) {
       
    }
}