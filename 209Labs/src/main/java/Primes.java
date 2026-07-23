import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Primes {
    private static List<Integer> primes = new ArrayList<>(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23));

    public static boolean isPrime(int n) {
        if  (n <= 1) { return false; }

        int foundIdx = Collections.binarySearch(primes, n);

        if (foundIdx < 0) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int kthPrime(int k) {
        if (k >= primes.size()) {
            int lastNum = primes.getLast() + 1;
            while (k >= primes.size()) {
                if (Primes.isPrime(lastNum)) {
                    primes.add(lastNum);
                }
                lastNum++;
            }
        }
        return primes.get(k);
    }

    public static List<Integer> factorize(int n) {
        List<Integer> factors = new ArrayList<>();

        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }
}
