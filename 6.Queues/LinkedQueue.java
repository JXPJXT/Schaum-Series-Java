// Interface definition
interface Queue<E>{
    public boolean add(E element); // THIS MUST BE 'boolean'
    public E element();
    public boolean isEmpty();
    public E remove();
    public int size();
}

// Class implementation
public class LinkedQueue<E> implements Queue<E>{
    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;

        Node(){
            this.prev = this;
            this.next = this;
        }

        Node(E element, Node<E> prev, Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head = new Node<E>(); // Sentinel head node
    private int size;

    @Override
    public boolean add(E element){ // THIS MUST BE 'boolean' to match the interface
        Node<E> newNode = new Node<>(element, head.prev, head);
        head.prev.next = newNode;
        head.prev = newNode;
        size++;
        return true; // Indicate that the element was successfully added
    }

    @Override
    public E element(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        return head.next.element;
    }

    @Override
    public boolean isEmpty(){
        return(size == 0);
    }

    @Override
    public E remove(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        E element = head.next.element;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return element;
    }

    @Override
    public int size(){
        return size;
    }
}

// Main method for testing
class LinkedQueueImplementation { // This class should not be 'public' if LinkedQueue is public in the same file
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();

        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Queue size: " + queue.size());

        System.out.println("\n--- Adding elements ---");
        queue.add("Apple"); // This call is fine; it now returns boolean
        System.out.println("Added: Apple");
        queue.add("Banana");
        System.out.println("Added: Banana");
        queue.add("Cherry");
        System.out.println("Added: Cherry");

        System.out.println("\nIs queue empty? " + queue.isEmpty());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Front element: " + queue.element());

        System.out.println("\n--- Removing elements ---");
        System.out.println("Removed: " + queue.remove());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Front element: " + queue.element());

        queue.add("Date");
        System.out.println("Added: Date");
        System.out.println("Queue size: " + queue.size());
        System.out.println("Front element: " + queue.element());

        System.out.println("\n--- Removing all remaining elements ---");
        while (!queue.isEmpty()) {
            System.out.println("Removed: " + queue.remove());
        }

        System.out.println("\nIs queue empty? " + queue.isEmpty());
        System.out.println("Queue size: " + queue.size());

        System.out.println("\n--- Testing exceptions on empty queue ---");
        try {
            queue.element();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught exception (element): " + e.getMessage());
        }

        try {
            queue.remove();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught exception (remove): " + e.getMessage());
        }
    }
}