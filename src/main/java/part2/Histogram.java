package part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;

public class Histogram {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            HistogramCalculator calculator = new HistogramCalculator();
            int [] arr = new int[] {1,2,3,2};
            calculator.calculateLargestArea(arr);
            writer.write(String.valueOf(calculator.maxArea));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    static class HistogramCalculator {
        int maxArea = 0; // Initialize max area
        int tp; // To store top of stack
        int areaWithTop;
        int i = 0;
        private Stack<Integer> stack = new Stack<>();

        public void calculateLargestArea(int [] heights){
            while (i < heights.length) {
                if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                    stack.push(i++);
                } else {
                    tp = stack.pop();
                    areaWithTop = heights[tp] * (stack.empty() ? i : i - stack.peek() - 1);
                    if (maxArea < areaWithTop) {
                        maxArea = areaWithTop;
                    }
                }
            }

            while (!stack.isEmpty()) {
                tp = stack.pop();
                areaWithTop = heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if (maxArea < areaWithTop) {
                    maxArea = areaWithTop;
                }
            }
        }
    }

}
