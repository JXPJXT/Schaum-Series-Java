import java.util.BitSet;

public class primeSieveQ20 {

    private static final int SIZE = 1000;
    private static final BitSet sieve = new BitSet(SIZE);
    private static int iteratorPosition = 1;

    static {
        initializeSieve();
    }

    public static void main(String[] args) {
        System.out.println("--- All primes less than " + SIZE + " ---");
        printSieve();

        System.out.println("\n\n--- Demonstrating isPrime() ---");
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("Is 10 prime? " + isPrime(10));
        System.out.println("Is 997 prime? " + isPrime(997));

        System.out.println("\n--- Demonstrating the prime iterator ---");
        resetIterator();
        System.out.println("First 5 primes:");
        for (int i = 0; i < 5; i++) {
            System.out.print(nextPrime() + " ");
        }
        System.out.println("\nNext 5 primes:");
        for (int i = 0; i < 5; i++) {
            System.out.print(nextPrime() + " ");
        }
        System.out.println();
        
        System.out.println("\n--- Demonstrating the factor() method ---");
        System.out.println("Factors of 72: " + factor(72));
        System.out.println("Factors of 199: " + factor(199));
        System.out.println("Factors of 879: " + factor(879));
    }

    private static void initializeSieve() {
        sieve.set(2, SIZE);
        for (int n = 2; n * n < SIZE; n++) {
            if (sieve.get(n)) {
                for (int m = n * n; m < SIZE; m += n) {
                    sieve.clear(m);
                }
            }
        }
    }

    public static void printSieve() {
        int primeCount = 0;
        for (int i = 2; i < SIZE; i++) {
            if (sieve.get(i)) {
                System.out.printf("%5d%s", i, ++primeCount % 16 == 0 ? "\n" : "");
            }
        }
        System.out.printf("%n%d primes less than %d%n", primeCount, SIZE);
    }

    public static boolean isPrime(int n) {
        if (n >= SIZE || n < 2) {
            return false;
        }
        return sieve.get(n);
    }

    public static int nextPrime() {
        while (++iteratorPosition < SIZE) {
            if (sieve.get(iteratorPosition)) {
                return iteratorPosition;
            }
        }
        return -1;
    }

    public static void resetIterator() {
        iteratorPosition = 1;
    }

    public static String factor(int n) {
        if (n <= 1) {
            return String.valueOf(n);
        }
        if (n >= SIZE) {
            return "Input is out of bounds for the current sieve.";
        }

        resetIterator();
        StringBuilder factors = new StringBuilder();
        int tempN = n;
        int p = nextPrime();

        while (tempN > 1 && p != -1) {
            if (tempN % p == 0) {
                if (factors.length() > 0) {
                    factors.append("*");
                }
                factors.append(p);
                tempN /= p;
            } else {
                p = nextPrime();
            }
        }
        
        if (tempN > 1) {
             if (factors.length() > 0) {
                factors.append("*");
            }
            factors.append(tempN);
        }

        return factors.toString();
    }
}