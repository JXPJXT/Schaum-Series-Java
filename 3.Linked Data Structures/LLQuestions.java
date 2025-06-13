import java.util.Arrays;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LLQuestions {

    public static void main(String[] args) {
        int[] myArray = {10, 20, 30, 40, 50, 60};
        int n = myArray.length;
        int x = 35;

        System.out.println("Original array: " + Arrays.toString(myArray));
        System.out.println("Performing delete operation with x = " + x);
        
        delete(myArray, n, x);

        System.out.println("Array after delete: " + Arrays.toString(myArray));

        System.out.println("\n--- Another Example ---");
        int[] anotherArray = {5, 15, 25, 35, 45};
        int n2 = anotherArray.length;
        int x2 = 25;

        System.out.println("Original array: " + Arrays.toString(anotherArray));
        System.out.println("Performing delete operation with x = " + x2);

        delete(anotherArray, n2, x2);
        System.out.println("Array after delete: " + Arrays.toString(anotherArray));
    }

    static void delete(int[] a, int n, int x) {
        int i = 0;
        while (i < n && a[i] <= x) {
            ++i;
        }

        if (i > 0 && i < n) {
            System.arraycopy(a, i, a, i - 1, n - i);
        }

        if (n > 0) {
           a[n - 1] = 0;
        }
    }
}
