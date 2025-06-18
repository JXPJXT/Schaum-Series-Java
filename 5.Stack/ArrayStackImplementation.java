import java.util.EmptyStackException;

interface Stack<E> {
    boolean isEmpty();
    E peek();
    E pop();
    void push(E element);
    int size();
}

class ArrayStack<E> implements Stack<E> {
    E[] elements;
    private int size;
    static final int INITIAL_CAPACITY = 1000;

    public ArrayStack() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
    }

    ArrayStack(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E element = elements[--size];
        elements[size] = null; // Clear the reference to help with garbage collection
        return element;
    }

    public void push(E element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public int size() {
        return size;
    }

    void resize() {
        assert size == elements.length;
        Object[] a = new Object[2 * size];
        System.arraycopy(elements, 0, a, 0, size);
        elements = (E[]) a;
    }
}

public class ArrayStackImplementation {
    public static void main(String args[]) {
        // Create an ArrayStack of Strings
        ArrayStack<String> stringStack = new ArrayStack<>(5); // Smaller capacity for demonstration

        System.out.println("String Stack - Initial state:");
        System.out.println("Is empty: " + stringStack.isEmpty());
        System.out.println("Size: " + stringStack.size());

        // Push elements
        System.out.println("\nPushing elements: Apple, Banana, Cherry");
        stringStack.push("Apple");
        stringStack.push("Banana");
        stringStack.push("Cherry");

        System.out.println("Current size: " + stringStack.size());
        System.out.println("Top element (peek): " + stringStack.peek());
        System.out.println("Is empty: " + stringStack.isEmpty());

        // Push more elements to test resize
        System.out.println("\nPushing more elements: Date, Elderberry, Fig (to test resize)");
        stringStack.push("Date");
        stringStack.push("Elderberry");
        stringStack.push("Fig"); // This should trigger a resize

        System.out.println("Current size after more pushes: " + stringStack.size());
        System.out.println("Top element (peek): " + stringStack.peek());

        // Pop elements
        System.out.println("\nPopping elements:");
        System.out.println("Popped: " + stringStack.pop());
        System.out.println("Current size: " + stringStack.size());
        System.out.println("Top element (peek): " + stringStack.peek());

        System.out.println("Popped: " + stringStack.pop());
        System.out.println("Current size: " + stringStack.size());
        System.out.println("Top element (peek): " + stringStack.peek());

        // Test with integers
        ArrayStack<Integer> intStack = new ArrayStack<>(); // Using default capacity

        System.out.println("\nInteger Stack - Initial state:");
        System.out.println("Is empty: " + intStack.isEmpty());
        System.out.println("Size: " + intStack.size());

        System.out.println("\nPushing integers: 10, 20, 30");
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        System.out.println("Current size: " + intStack.size());
        System.out.println("Top element (peek): " + intStack.peek());

        System.out.println("\nPopping all elements:");
        while (!intStack.isEmpty()) {
            System.out.println("Popped: " + intStack.pop());
        }
        System.out.println("Is empty: " + intStack.isEmpty());
        System.out.println("Size: " + intStack.size());

        // Test EmptyStackException
        System.out.println("\nAttempting to peek/pop from an empty stack (should throw EmptyStackException):");
        try {
            intStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Caught EmptyStackException: " + e.getMessage());
        }
    }
}