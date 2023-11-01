package part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class FibonacciModulo {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
            String fibonacciValue = fibonacciCalculator.getFibonacciValue(11, 1);
            System.out.println(fibonacciValue);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class FibonacciCalculator {

        //Будем вычислять по формуле Бине
        String getFibonacciValue(int n, int k) {
//            MathContext _mc = new MathContext(20, RoundingMode.UP);
//            double sqrt5 = Math.sqrt(5);
//            BigDecimal sqrt5Big = new BigDecimal(sqrt5, _mc);
//            BigDecimal phi = new BigDecimal((1 + sqrt5) / 2, _mc);
//            BigDecimal divide = phi.pow(n, _mc).divide(sqrt5Big, RoundingMode.UP).;
//            BigInteger bigInteger = divide.toBigInteger();
//            BigDecimal bigDecimal = new BigDecimal(Math.pow(10, k));
//            return bigInteger.mod(bigDecimal.toBigInteger()).toString();
            return null;
        }
    }
}
