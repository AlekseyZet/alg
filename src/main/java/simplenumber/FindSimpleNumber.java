package simplenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSimpleNumber {

    public static void main(String[] args) {
        eratosthenes(15);
    }

    public static void eratosthenes(int n) {
        int[] lp = new int[n + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                primes.add(i);
            }
            for (int p : primes) {
                int x = p * i;
                if (p > lp[i] || x > n) {
                    break;
                }
                lp[x] = p;
            }
        }
    }
}
