import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        if (c == null || c.isEmpty()) {
            return 0;
        }

        int jumps = 0;
        int currentPosition = 0;

        while (currentPosition < c.size() - 1) {
            // Try to jump 2 clouds ahead
            if (
                currentPosition + 2 < c.size() &&
                c.get(currentPosition + 2) == 0
            ) {
                currentPosition += 2;
                jumps++;
            } else {
                currentPosition++;
                jumps++;
            }
        }

        return jumps;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in)
        );
        BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(
            bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")
        )
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
