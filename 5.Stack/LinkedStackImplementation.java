import java.util.EmptyStackException;

interface Stack<E> {
    boolean isEmpty();
    E peek();
    E pop();
    void push(E element);
    int size();
}

class LinkedStack<E> implements Stack<E> {
    Node<E> head = new Node<E>();
    int size;

    public boolean isEmpty() {
        return (size == 0);
    }

    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return head.prev.element;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E element = head.prev.element;
        Node<E> nodeToRemove = head.prev;
        nodeToRemove.prev.next = head;
        head.prev = nodeToRemove.prev;
        --size;
        return element;
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element, head.prev, head);
        head.prev.next = newNode;
        head.prev = newNode;
        ++size;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node() {
            this.prev = this;
            this.next = this;
        }

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}

public class LinkedStackImplementation {
    public static void main(String args[]) {
        LinkedStack<String> stringStack = new LinkedStack<>();

        System.out.println("String LinkedStack - Initial state:");
        System.out.println("Is empty: " + stringStack.isEmpty());
        System.out.println("Size: " + stringStack.size());
        System.out.println("\nPushing elements: Alpha, Beta, Gamma");
        stringStack.push("Alpha");
        stringStack.push("Beta");
        stringStack.push("Gamma");
        System.out.println("Current size: " + stringStack.size());
        System.out.println("Top element (peek): " + stringStack.peek());
        System.out.println("Is empty: " + stringStack.isEmpty());
        System.out.println("\nPopping elements:");
        System.out.println("Popped: " + stringStack.pop());
        System.out.println("Current size: " + stringStack.size());
        System.out.println("Top element (peek): " + stringStack.peek());
        System.out.println("Popped: " + stringStack.pop());
        System.out.println("Current size: " + stringStack.size());
        System.out.println("Top element (peek): " + stringStack.peek());
        System.out.println("\nPushing Delta");
        stringStack.push("Delta");
        System.out.println("Current size: " + stringStack.size());
        System.out.println("Top element (peek): " + stringStack.peek());
        LinkedStack<Integer> intStack = new LinkedStack<>();
        System.out.println("\nInteger LinkedStack - Initial state:");
        System.out.println("Is empty: " + intStack.isEmpty());
        System.out.println("Size: " + intStack.size());
        System.out.println("\nPushing integers: 100, 200, 300");
        intStack.push(100);
        intStack.push(200);
        intStack.push(300);
        System.out.println("Current size: " + intStack.size());
        System.out.println("Top element (peek): " + intStack.peek());
        System.out.println("\nPopping all elements:");
        while (!intStack.isEmpty()) {
            System.out.println("Popped: " + intStack.pop());
        }
        System.out.println("Is empty: " + intStack.isEmpty());
        System.out.println("Size: " + intStack.size());
        System.out.println("\nAttempting to peek/pop from an empty stack (should throw EmptyStackException):");
        try {
            intStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Caught EmptyStackException as expected: " + e.getMessage());
        }
        try {
            intStack.peek();
        } catch (EmptyStackException e) {
            System.out.println("Caught EmptyStackException as expected: " + e.getMessage());
        }
    }
}