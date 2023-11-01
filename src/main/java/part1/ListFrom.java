package part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 * Списочная форма.
 */
public class ListFrom {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            String xSymbolCount = reader.readLine();
            String xLine = reader.readLine();
            String kLine = reader.readLine();

            String number1 = getNumber(xLine);
            String v1 = number1.length() > kLine.length() ? number1 : kLine;
            String v2 = number1.length() <= kLine.length() ? number1 : kLine;
            writer.write(sum(v1, v2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getNumber(String line) {
        StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
        StringBuilder stringBuilder = new StringBuilder();
        while (stringTokenizer.hasMoreTokens()) {
            stringBuilder.append(stringTokenizer.nextToken());
        }

        return stringBuilder.toString();
    }

    private static String sum(String value1, String value2) {
        int poinerv1 = value1.length() - 1;
        int poinerv2 = value2.length() - 1;
        int temp = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (poinerv1 >= 0) {
            int v1 = Integer.parseInt(String.valueOf(value1.charAt(poinerv1)));
            int v2 = 0;
            if (poinerv2 >= 0) {
                v2 = Integer.parseInt(String.valueOf(value2.charAt(poinerv2)));
                poinerv2--;
            }
            int result = v1 + v2 + temp;
            if (result >= 10) {
                result = result - 10;
                temp = 1;
            } else {
                temp = 0;
            }
            String s = String.valueOf(result);
            stringBuilder.append(s).append(" ");
            poinerv1--;
        }

        if (temp > 0) {
            stringBuilder.append(temp);
        }

        return stringBuilder.reverse()
                .toString();
    }
}
