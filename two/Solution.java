package two;

import parsing.ParseInput;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(ParseInput.inputToLines("two\\input.txt")));
    }

    public static int solution(String[] input) {
        int count = 0;
        for (String line : input) {
            String[] readLine = line.split("\\s+");

            boolean conditionsMet = true;
            int diff = Integer.parseInt(readLine[1]) - Integer.parseInt(readLine[0]);
            boolean increasingOrDecreasing; // increasing is true, decreasing is false

            if (diff > 0) increasingOrDecreasing = true;
            else if (diff < 0) increasingOrDecreasing = false;
            else continue;
            if ((( increasingOrDecreasing ? 1 : -1 ) * diff) > 3)
                continue;

            for (int i = 1; i < readLine.length - 1; i++) {
                diff = Integer.parseInt(readLine[i+1]) - Integer.parseInt(readLine[i]);
                if ((diff == 0) || (diff > 0 && !increasingOrDecreasing) || (diff < 0 && increasingOrDecreasing) || ((( increasingOrDecreasing ? 1 : -1 ) * diff) > 3)) {
                    conditionsMet = false;
                    break;
                } //if NOT strictly monotonic OR if difference is > 3
            }
            
            if (conditionsMet) count++;
        }
        return count;
    }
}