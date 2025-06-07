import java.util.Arrays;
import java.util.Random; // Import Arrays class for easy printing

public class shuffleElementQ9 {

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println("Original array: " + Arrays.toString(arr)); // Print original
        shuffle(arr);
        System.out.println("Shuffled array: " + Arrays.toString(arr)); // Print shuffled
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void shuffle(int[] a){
        Random random = new Random();
        int n = a.length;
        for(int i = 0; i < n; i++){
            int randomIndexToSwap = random.nextInt(n - i) + i;
            swap(a, i, randomIndexToSwap);
        }
    }
}