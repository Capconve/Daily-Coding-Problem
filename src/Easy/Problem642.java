/*
This problem was asked by Pivotal.

A step word is formed by taking a given word, adding a letter, and anagramming the result.
For example, starting with the word "APPLE", you can add an "A" and anagram to get "APPEAL".

Given a dictionary of words and an input word, create a function that returns all valid step words.
 */

package Easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem642 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String stepWord = sc.nextLine().toLowerCase();

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 26; i++)
            arr.add(0);

        for (char i : stepWord.toCharArray()) {
            arr.set(i - 'a', arr.get(i - 'a') + 1);
        }

        BufferedReader dict = new BufferedReader(new FileReader("words.txt"));
        ArrayList<String> wordList = new ArrayList<>();
        String s = "";
        while ((s = dict.readLine()) != null) {
            wordList.add(s.toLowerCase());
        }

        dict.close();

        System.out.println("Valid Stepwords are :-");

        for (String value : wordList) {

            if (value.length() <= stepWord.length())
                continue;

            ArrayList<Integer> currentLetters = new ArrayList<>();
            for (int k = 0; k < 26; k++)
                currentLetters.add(0);

            for (char j : value.toCharArray()) {
                if (Character.isAlphabetic(j))
                    currentLetters.set(j - 'a', currentLetters.get(j - 'a') + 1);
            }

            int diff = 0;

            for (int k = 0; k < 26; k++) {
                diff += Math.abs(currentLetters.get(k) - arr.get(k));

            }

            if (diff == 1) {
                System.out.println(value);
            }
        }
    }
}
