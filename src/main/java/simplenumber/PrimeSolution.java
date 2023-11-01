package simplenumber;

import java.util.Arrays;

public class PrimeSolution {

    public static void main(String[] args) {
        System.out.println("result isPrimeThroughSquareRoot: " + isPrimeThroughSquareRoot(1000000));
        System.out.println("result isPrimeEnumeration: " + isPrimeEnumeration(1000000));
    }

    /**
     * Вычисление обычным перебором с использованием квадратного корня.
     * Подразумевается, что не имеет смысла рассматривать числа, которые больше Square(n) корня
     * входного числа, так как корень - это дорогая операция, то мы просто умножаем числа
     *
     * @param n входящее значение
     * @return результат вычисления
     */
    private static boolean isPrimeThroughSquareRoot(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i * i < n + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Вычисление обычным перебором.
     *
     * @param n входящее значение
     * @return результат вычисления
     */
    private static boolean isPrimeEnumeration(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Вычисление через решето эратосфена.
     * Сначала мы начинаем с 2 и первым делом во втором цикле умножаем число само на себя,
     * это гарантирует что оно делится как минимум на другое число, затем прибавляем к каждому
     * следующему j число i (если это 2, то мы проходим по всем четным, если 3 то по нечетным)
     * Сложность n log(n)
     * @param n входящее значение
     * @return результат вычисления
     */
    private static boolean[] eratosthenes_effective(int n) {
        boolean[] numbers = new boolean[n + 1];
        Arrays.fill(numbers, true);

        for (int i = 2; i < n + 1; i++) {
            if (numbers[i]) {
                for (int j = i * i; j < n + 1; j += i) {
                    numbers[j] = false;
                }
            }
        }

        return numbers;
    }
}
