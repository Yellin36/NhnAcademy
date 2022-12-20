import java.util.BitSet;

public class Prime {
    public static class Primes {
        private static final int SIZE = 1000;
        private static int size  = SIZE;
        private static BitSet sieve = new BitSet(size);
        private static int last = 1;
        static {
            for (int i = 2; i < SIZE; i++) {
                sieve.set(i);
            }
            for(int n= 2; 2*n < SIZE; n++) {
                if(sieve.get(n)) {
                    for(int m = n; m*n<SIZE; m++) {
                        sieve.clear(m*n);
                    }
                }
            }
        }
        public static void setLast(int n) {}
        public static void setLast() {}
        public static void setSize(int n) {}
        public static void setSize() {}
        public static boolean isPrime(int n) {
            BitSet check = new BitSet();
            for (int i = 2; i * i <= n; i++) {
                if(check.get(i)) continue;

                for (int j = i*i; j <= n; j += i) {
                    if(j == n) return false;
                    check.set(j);
                }
            }
            return true;
        }
        public static int next() {
            return 0;
        }
        public static void printPrimes() {}
    }

}
