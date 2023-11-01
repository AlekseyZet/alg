package part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Monitoring {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            int rows = Integer.parseInt(reader.readLine());
            int cols = Integer.parseInt(reader.readLine());
            Matrix matrix = new Matrix(rows, cols);
            String line;
            while ((line = reader.readLine()) != null) {
                matrix.setDataFromLine(line);
            }

            int[][] transposeData = matrix.getTransposeData(rows, cols);
            writer.write(matrix.convertToString(transposeData));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static class Matrix {
        private int cols = 0;
        private int rows = 0;
        private final int[][] data;

        public Matrix(int rows, int cols) {
            data = new int[rows][cols];
        }

        public void setDataFromLine(String line) {
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            while (stringTokenizer.hasMoreTokens()) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                data[rows][cols++] = value;
            }
            rows++;
            cols = 0;
        }

        public int[][] getTransposeData(int cols, int rows) {
            int[][] transposeData = new int[rows][cols];

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    transposeData[j][i] = data[i][j];
                }
            }
            return transposeData;
        }

        public String convertToString(int[][] data) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    stringBuilder.append(data[i][j]).append(" ");
                }
                stringBuilder.append("\r\n");
            }

            return stringBuilder.toString();
        }
    }
}
