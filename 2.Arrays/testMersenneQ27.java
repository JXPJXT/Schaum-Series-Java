public class testMersenneQ27 {
    public static void main(String[] args) {
        System.out.println("Testing Mersenne numbers M(p) = 2^p - 1 for primality, where p is a prime < 30:");
        int sieveLimit = 1000;
        
        primeSieveQ21.resetIterator();
        int p = primeSieveQ21.nextPrime();

        while (p != -1 && p < 30) {
            int n = (1 << p) - 1;
            
            System.out.printf("p=%-2d, M(p) = 2^%d - 1 = %-5d -> ", p, p, n);

            if (n >= sieveLimit) {
                System.out.println("Out of sieve bounds.");
            } else {
                if (primeSieveQ21.isPrime(n)) {
                    System.out.println("Is a Mersenne prime.");
                } else {
                    System.out.println("Is composite.");
                }
            }
            p = primeSieveQ21.nextPrime();
        }
    }
}