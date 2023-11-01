package part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Поиск дополнительного символа.
 */
public class SearchExtraLetter {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            String source = reader.readLine();
            String target = reader.readLine();
            Map<Character, Integer> sourceMap = getMapWithLetterNumber(source);
            Map<Character, Integer> targetMap = getMapWithLetterNumber(target);

            Optional<Character> letter = targetMap.keySet().stream()
                    .filter(key -> Objects.isNull(sourceMap.get(key)) || (!sourceMap.get(key).equals(targetMap.get(key))))
                    .findFirst();
            if (letter.isPresent()) {
                writer.write(letter.get());
                return;
            }
            writer.write("");
        } catch (Exception e) {
            System.err.println("Возникла ошибка " + e);
        }
    }

    private static Map<Character, Integer> getMapWithLetterNumber(String line) {
        HashMap<Character, Integer> lettersMap = new HashMap<>();
        char[] chars = line.toCharArray();
        for (char ch : chars) {
            Integer value = lettersMap.getOrDefault(ch, 0);
            lettersMap.put(ch, value + 1);
        }

        return lettersMap;
    }
}
