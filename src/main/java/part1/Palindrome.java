package part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Палиндром
 */
public class Palindrome {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            String line = reader.readLine();
            writer.write(checkPalindrome(line));
        } catch (Exception e) {
            System.err.println("Возникла ошибка " + e);
        }
    }

    private static String checkPalindrome(String line) {
        String s = line.replaceAll("[^\\da-zA-Z]+", "");
        StringBuilder stringBuilder = new StringBuilder(s);
        if (s.equalsIgnoreCase(stringBuilder.reverse().toString())) {
            return "True";
        }
        return "False";
    }
}
