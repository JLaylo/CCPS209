import java.util.*;

public class PrimeGens
{
    public static class PalindromicPrimes implements Iterator<Integer> {
        private int k = 0; // Current position in the prime sequence

        @Override
        public boolean hasNext() {
            return true; //infinite sequence
        }

        @Override public Integer next() {
            while(true) {
                int p = Primes.kthPrime(k++);
                String digits = "" + p;
                if(digits.equals(new StringBuilder(digits).reverse().toString())) {
                    return p;
                }
            }
        }
    }

    public static class Composites implements Iterator<Integer> {
        private int curr = 4, k = 2, nextPrime = Primes.kthPrime(2);

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            if (curr == nextPrime) {
                nextPrime = Primes.kthPrime(++k);
                curr++;
            }
            return curr++;
        }
    }

    public static class TwinPrimes implements Iterator<Integer> {
        private int k = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            while (true) {
                int p = Primes.kthPrime(k++);

                if (Primes.isPrime(p+2))
                {
                    return p;
                }
            }
        }
    }

    public static class SafePrimes implements Iterator<Integer> {
        private int k = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            while (true) {
                int p = Primes.kthPrime(k++);

                if (Primes.isPrime(2*p+1))
                {
                    return 2*p+1;
                }
            }
        }
    }

    public static class StrongPrimes implements Iterator<Integer> {
        private int k = 1;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            while (true) {
                int p = Primes.kthPrime(k);
                int avg_p = (Primes.kthPrime(k+1) + Primes.kthPrime(k-1)) / 2;
                k++;

                if (p > avg_p)
                {
                    return p;
                }
            }
        }
    }
}
