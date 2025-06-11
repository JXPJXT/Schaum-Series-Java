public class testEulerPolynomialQ24 {
    //Babbage
    public static void main(String[] args) {
        System.out.println("Testing Euler's prime-generating polynomial: n = x*x + x + 41");
        int sieveLimit = 1000;

        for (int x = 0; x < 50; x++) {
            int n = x * x + x + 41;
            System.out.print("For x = " + String.format("%-2d", x) + ", n = " + String.format("%-4d", n) + " -> ");

            if (n >= sieveLimit) {
                System.out.println("Out of sieve bounds.");
            } else {
                if (primeSieveQ21.isPrime(n)) {
                    System.out.println("Is prime.");
                } else {
                    System.out.println("Is composite. Factors: " + primeSieveQ21.factor(n));
                }
            }
        }
        System.out.println("\nNote: The polynomial n=x*x+x+41 produces primes for x=0 to 39.");
        System.out.println("At x=40, n=1681 (41*41). At x=41, n=1763 (41*43).");
    }
}