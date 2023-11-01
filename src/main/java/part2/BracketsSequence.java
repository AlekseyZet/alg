package part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Stack;

public class BracketsSequence {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";
    private static final Map<Character, Character> bracketsMap = Map.of(')', '(', ']', '[', '}', '{');

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            String brackSeq = reader.readLine();
            writer.write(isCorrectBracketSeq(brackSeq));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static String isCorrectBracketSeq(String brackSeq) {
        if (brackSeq.isEmpty()) {
            return "True";
        } else if (brackSeq.length() == 1) {
            return "False";
        } else if (bracketsMap.get(brackSeq.charAt(0)) != null) {
            return "False";
        }

        Stack<Character> stack = new Stack<>();
        int i = 0;
        do {
            char c = brackSeq.charAt(i);
            if (bracketsMap.get(c) != null) {
                if (stack.isEmpty()) {
                    return "False";
                }
                Character pop = stack.pop();
                if (bracketsMap.get(c) != pop) {
                    return "False";
                }
                i++;
                continue;
            }
            stack.push(c);
            i++;
        } while (i < brackSeq.length());

        if (stack.isEmpty()) {
            return "True";
        }

        return "False";
    }
}
