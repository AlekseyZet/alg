package part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DegreeFour {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            int number = Integer.parseInt(reader.readLine());
            CalculatingDegree calculatingDegree = new CalculatingDegree();
            if (calculatingDegree.isPrime(number)) {
                writer.write("False");
            } else {
                String result = calculatingDegree.checkDegreeByBase(4, number) ? "True" : "False";
                writer.write(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class CalculatingDegree {

        public boolean checkDegreeByBase(int base, int number) {
            while (true) {
                if (number % 4 == 0) {
                    number /= 4;
                } else {
                    return false;
                }

                if (number == 1) {
                    return true;
                }
            }
        }

        public boolean isPrime(int number) {
            for (int i = 2; i * i < number + 1; i++) {
                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
