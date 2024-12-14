package one;

import parsing.ParseInput;
import java.util.Arrays;

 public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(ParseInput.inputToString("one\\input.txt")));
    }

    public static int solution(String input) {
        int[] listOne, listTwo;
        int difference = 0;
        String[] inputArray = input.split("\\s+");
        listOne = new int[inputArray.length / 2];
        listTwo = new int[inputArray.length / 2];


        int listIndex = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 == 0) {
                listOne[listIndex] = Integer.parseInt(inputArray[i]);
            }
            else {
                listTwo[listIndex] = Integer.parseInt(inputArray[i]);
                listIndex++;
            }
        }

        Arrays.sort(listOne);
        Arrays.sort(listTwo);

        for (int i = 0; i < listOne.length; i++) {
            difference += Math.abs(listOne[i] - listTwo[i]);
        }

        return difference;
    }
 }