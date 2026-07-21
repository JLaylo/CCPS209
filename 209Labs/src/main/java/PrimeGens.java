import java.math.BigInteger;
import java.util.Iterator;

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
        private static int k = 0;

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
            // to do
            return 0;
        }
    }

    public static class StrongPrimes implements Iterator<Integer> {
        private int k = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            // to do
            return 0;
        }
    }

}
