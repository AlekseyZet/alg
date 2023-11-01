package part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Factorization {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(INPUT));
                BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            int value = Integer.parseInt(reader.readLine());
            StringBuilder stringBuilder = new StringBuilder();
            int source = value;
            int divide = 2;
            int result = 1;
            while (true) {
                if (value % divide == 0) {
                    value = value / divide;
                    stringBuilder.append(divide).append(" ");
                    result = result * divide;
                } else {
                    divide++;
                }

                if (result == source) {
                    break;
                }

                if (isPrime(value)) {
                    stringBuilder.append(value);
                    break;
                }
            }
            writer.write(stringBuilder.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }
}
