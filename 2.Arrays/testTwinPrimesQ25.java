public class testTwinPrimesQ25 {
    public static void main(String[] args) {
        System.out.println("Finding twin primes (p, p+2) where p is less than 900:");
        
        int limit = 900;
        primeSieveQ21.resetIterator();
        
        int p = primeSieveQ21.nextPrime();
        
        while (p != -1 && p < limit) {
            if (primeSieveQ21.isPrime(p + 2)) {
                System.out.println("(" + p + ", " + (p + 2) + ")");
            }
            p = primeSieveQ21.nextPrime();
        }
    }
}