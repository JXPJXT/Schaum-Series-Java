import java.util.*;

public class TestStringStack {
    public static void main(String args[]){
        Queue<String> queue = new Queue<>();
        queue.add("GB");
        queue.add("DE");
        queue.add("FR");
        queue.add("ES");
        System.out.println(queue);
        System.out.println("queue.element(): "+queue.element());
        System.out.println("queue.remove(): "+queue.remove());
        System.out.println(queue);
        System.out.println("queue.remove(): "+queue.remove());
        System.out.println(queue);
        System.out.println("queue.add(\"IE\"):");
        queue.add("IE");
        System.out.println(queue);
        System.out.priintln("queue.remove(): "+queue.remove());
        System.out.println(queue);

    }    
}
