public class testFermatQ23 {

    public static void main(String[] args) {
        System.out.println("--- Demonstrating Fermat Number Primality Test ---");
        System.out.println("Checking first 5 Fermat numbers: F_p = 2^(2^p) + 1");
        
        // The loop for 'p' from 0 to 4
        for (int p = 0; p < 5; p++) {
            // Use long to prevent potential overflow during calculation
            long fermatN_long = (long) Math.pow(2, Math.pow(2, p)) + 1;
            
            System.out.print("p = " + p + ", n = " + fermatN_long + ": ");

            // We call the static isPrime method from the primeSieveQ21 class
            if (primeSieveQ21.isPrime((int) fermatN_long)) {
                System.out.println("Is prime.");
            } else {
                // Check why it might not be prime
                if (fermatN_long >= 1000) { // Using the SIZE from the other class
                     System.out.println("Is not prime (or is out of sieve bounds).");
                } else {
                     System.out.println("Is not prime.");
                }
            }
        }
         System.out.println("Note: F_4 = 65537 is prime, but is outside the sieve's bounds of 1000.");
    }
}