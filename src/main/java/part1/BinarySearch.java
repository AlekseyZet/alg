package part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BinarySearch {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            String value1 = reader.readLine();
            String value2 = reader.readLine();
            CalculatorBinary calculatorBinary = new CalculatorBinary();
            String result = value1.length() > value2.length()
                    ? calculatorBinary.sumTwoValue(value1, value2)
                    : calculatorBinary.sumTwoValue(value2, value1);
            writer.write(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class CalculatorBinary {
        private static final char ONE = '1';

        public String sumTwoValue(String greaterValue, String lessValue) {
            boolean temp = false;
            int gPointer = greaterValue.length() - 1;
            int lPointer = lessValue.length() - 1;
            StringBuilder stringBuilder = new StringBuilder();
            for (int gp = gPointer; gp >= 0; gp--) {
                if (lPointer >= 0) {
                    boolean l = lessValue.charAt(lPointer) == ONE;
                    boolean g = greaterValue.charAt(gp) == ONE;
                    if (l && g) {
                        if (temp) {
                            stringBuilder.append(1);
                        } else {
                            stringBuilder.append(0);
                        }
                        temp = true;
                    } else if (l || g) {
                        if (temp) {
                            stringBuilder.append(0);
                        } else {
                            stringBuilder.append(1);
                        }
                    } else {
                        if (temp) {
                            stringBuilder.append(1);
                        } else {
                            stringBuilder.append(0);
                        }
                        temp = false;
                    }
                    lPointer--;
                    continue;
                }

                boolean g = greaterValue.charAt(gp) == ONE;
                if (temp && g) {
                    stringBuilder.append(0);
                } else if (temp || g) {
                    stringBuilder.append(1);
                    temp = false;
                } else {
                    stringBuilder.append(0);
                }
            }

            if (temp){
                stringBuilder.append(1);
            }
            return stringBuilder.reverse().toString();
        }
    }
}
