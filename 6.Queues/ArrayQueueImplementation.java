interface Queue<E>{
    public void add(E element);
    public E element();
    public boolean isEmpty();
    public E remove();
    public int size();
}

class ArrayQueue<E> implements Queue<E>{
    E[] elements;
    int front;
    int back;
    int currentSize; // Added to accurately track the number of elements
    static final int INITIAL_CAPACITY=4;

    public ArrayQueue(){
        this(INITIAL_CAPACITY);
    }

    public ArrayQueue(int capacity){
        elements =(E[]) new Object[capacity];
        front = 0;
        back = 0;
        currentSize = 0;
    }

    @Override
    public void add(E element){
        if(currentSize == elements.length){ // Check against actual size, not length-1 for a full array
            resize();
        }
        elements[back]=element;
        back = (back + 1) % elements.length; // Use modulo for circular increment
        currentSize++;
    }

    @Override
    public E element(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        return elements[front];
    }

    @Override
    public E remove(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        E element = elements[front];
        elements[front]=null; // Nullify the removed element for garbage collection
        front = (front + 1) % elements.length; // Use modulo for circular increment
        currentSize--;

        return element;
    }

    @Override
    public int size(){
        return currentSize; // Return the explicitly tracked size
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0; // Check against currentSize
    }

    void resize(){
        int newCapacity = elements.length * 2;
        E[] newElements = (E[]) new Object[newCapacity];

        // Copy elements from old array to new array in correct order
        for (int i = 0; i < currentSize; i++) {
            newElements[i] = elements[(front + i) % elements.length];
        }

        elements = newElements;
        front = 0; // Reset front to 0 in the new array
        back = currentSize; // Set back to currentSize (next available spot)
    }
}

public class ArrayQueueImplementation {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();

        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");
        queue.add("Date");

        System.out.println("Queue size after adding 4 elements: " + queue.size());
        System.out.println("Front element: " + queue.element());

        // This should trigger a resize
        queue.add("Elderberry");
        System.out.println("Queue size after adding another element (should trigger resize): " + queue.size());
        System.out.println("Front element after resize: " + queue.element());


        System.out.println("Removed element: " + queue.remove());
        System.out.println("Front element after removal: " + queue.element());
        System.out.println("Queue size after removal: " + queue.size());

        queue.add("Fig");
        queue.add("Grape");
        System.out.println("Queue size after adding more elements: " + queue.size());
        System.out.println("Front element: " + queue.element());


        System.out.println("--- Removing all elements ---");
        while (!queue.isEmpty()) {
            System.out.println("Removing: " + queue.remove());
        }

        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Final queue size: " + queue.size());


        try {
            queue.element();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught exception when trying to get element from empty queue: " + e.getMessage());
        }

        try {
            queue.remove();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught exception when trying to remove element from empty queue: " + e.getMessage());
        }
    }
}