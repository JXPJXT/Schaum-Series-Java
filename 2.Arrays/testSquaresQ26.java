public class testSquaresQ26 {
    public static void main(String[] args) {
        System.out.println("Finding the first prime between consecutive squares (n^2 and (n+1)^2):");
        
        int sieveLimit = 1000;
        
        for (int n = 1; (n + 1) * (n + 1) < sieveLimit; n++) {
            for (int i = n * n + 1; i < (n + 1) * (n + 1); i++) {
                if (primeSieveQ21.isPrime(i)) {
                    System.out.printf("%d < %d < %d%n", n * n, i, (n + 1) * (n + 1));
                    break;
                }
            }
        }
    }
}
