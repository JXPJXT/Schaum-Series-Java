public class testGoldbachQ22 {
    public static void main(String[] args) {
        System.out.println("Testing Goldbach's conjecture for even numbers up to 100:");
        System.out.println("4 = 2 + 2");
        for (int n = 6; n <= 100; n += 2) {
            boolean found = false;
            for (int p = 3; p <= n / 2; p += 2) {
                if (primeSieveQ21.isPrime(p) && primeSieveQ21.isPrime(n - p)) {
                    System.out.println(n + " = " + p + " + " + (n - p));
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Could not find a pair for " + n);
            }
        }
    }
}