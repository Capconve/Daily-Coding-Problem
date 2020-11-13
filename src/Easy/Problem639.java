/*
This problem was asked by Yelp.

Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent.
You can assume each valid number in the mapping is a single digit.

For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
*/

package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem639 {
    public static void main(String[] args) throws Exception {
        HashMap<Character, ArrayList<String>> arr = new HashMap<>();
        arr.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        arr.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        arr.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        arr.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        arr.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        arr.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        arr.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        arr.put('9', new ArrayList<>(Arrays.asList("v", "w", "x", "z")));

        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();

        ArrayList<String> result = new ArrayList<>();

        for (char i : input) {
            if (!Character.isDigit(i))
                throw new Exception("Invalid Input, should only contain digits");

            if (result.size() == 0) {
                ArrayList<String> temp = arr.get(i);
                result.addAll(temp);
            } else {
                ArrayList<String> temp = arr.get(i);
                ArrayList<String> res = new ArrayList<>();
                for (int l = 0; l < result.size(); l++) {
                    for (int k = 0; k < temp.size(); k++) {
                        res.add(result.get(l) + temp.get(k));
                    }
                }
                result = res;
            }
        }
        System.out.println(result);
    }
}
