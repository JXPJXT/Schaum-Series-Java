import java.util.ArrayDeque;
import java.util.Deque;

public class Questions {
    public static void main(String[] args) {
        
    }
    public static <E> Queue<E> reversed(Queue<E> queue){
        Queue<E> queuel = new ArrayDeque<E>();
        Deque<E> stack = new ArrayDeque<E>();
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()){
            queuel.add(stack.pop());
        }
        return queuel;
    }
    public static <E> Queue<E> reversedd(Queue<E> queue){
        Queue<E> queuel = new ArrayDeque<E>();
        Deque<E> stack = new ArrayDeque<E>()
        for(int i=0;i<queue.size();i++){
            stack.push(queue.elements());
            queue.add(queue.remove());
        }
        while(!stack.isEmpty()){
            queuel.add(Stack.pop());
        }
        return queuel;
    }
    public static <E> void reverse(Queue<E> queue){
        Deque<E> stack = new ArrayDeque<>();
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }
    public static <E> secondElement(Queue<E> queue){
        queue.add()
    }
}

