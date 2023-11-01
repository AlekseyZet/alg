package part3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class TwoBicycle {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            int days = Integer.parseInt(reader.readLine());
            BicycleCostCalculator bicycleCostCalculator = new BicycleCostCalculator(days);
            bicycleCostCalculator.convertStringToSavingsValue(reader.readLine());
            int cost = Integer.parseInt(reader.readLine());
            bicycleCostCalculator.findDayWhenHasMoneyOnOneBicycle(cost, 0, days - 1);
            String firstDayWhenHasMoneyOnABicycle = bicycleCostCalculator.getSavingsOnBicycle();
            bicycleCostCalculator.setSavingsOnBicycle(-1);
            bicycleCostCalculator.findDayWhenHasMoneyOnOneBicycle(cost * 2, 0, days - 1);
            String firstDayWhenHasMoneyOnTwoBicycles = bicycleCostCalculator.getSavingsOnBicycle();
            String result = String.join(" ", firstDayWhenHasMoneyOnABicycle, firstDayWhenHasMoneyOnTwoBicycles);
            writer.write(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class BicycleCostCalculator {
        private final int[] savings;
        private int savingsOnBicycle = -1;

        public BicycleCostCalculator(int size) {
            this.savings = new int[size];
        }

        public void findDayWhenHasMoneyOnOneBicycle(int bicycleCost, int left, int right) {
            int mid = (right + left) / 2;
            if (left >= right) {
                if (savings[left] >= bicycleCost) {
                    savingsOnBicycle = left;
                }
                return;
            } else if (savings[mid] >= bicycleCost) {
                savingsOnBicycle = mid;
                findDayWhenHasMoneyOnOneBicycle(bicycleCost, left, mid - 1);
            } else if (right - left == 1) {
                if (savings[left] >= bicycleCost) {
                    savingsOnBicycle = left;
                } else if (savings[right] >= bicycleCost) {
                    savingsOnBicycle = right;
                }
                return;
            } else {
                findDayWhenHasMoneyOnOneBicycle(bicycleCost, mid, right);
            }
        }

        public void convertStringToSavingsValue(String line) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            int day = 0;
            while (stringTokenizer.hasMoreTokens()) {
                int moneyAmount = Integer.parseInt(stringTokenizer.nextToken());
                savings[day] = moneyAmount;
                day++;
            }
        }

        public void setSavingsOnBicycle(int savingsOnBicycle) {
            this.savingsOnBicycle = savingsOnBicycle;
        }

        public String getSavingsOnBicycle() {
            return String.valueOf(savingsOnBicycle != -1 ? savingsOnBicycle + 1 : -1);
        }
    }
}
