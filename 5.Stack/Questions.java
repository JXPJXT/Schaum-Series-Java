import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Questions {

    public static <E> Deque<E> reversed(Deque<E> stack) {
        Deque<E> stack1 = new ArrayDeque<E>();
        while(!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        return stack1;
    }

    public static <E> Deque<E> reversedPreservingOriginal(Deque<E> stack) {
        Deque<E> stack1 = new ArrayDeque<E>();
        Deque<E> stack2 = new ArrayDeque<E>();
        while(!stack.isEmpty()) {
            stack1.push(stack.peek());
            stack2.push(stack.pop());
        }
        while(!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        return stack1;
    }

    public static <E> void reverse(Deque<E> stack) {
        Deque<E> stack1 = new ArrayDeque<E>();
        Deque<E> stack2 = new ArrayDeque<E>();
        while(!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while(!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    public static <E> E penultimate(Deque<E> stack) {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty, no penultimate element.");
        }
        E x1 = stack.pop();
        if (stack.isEmpty()) {
            stack.push(x1);
            throw new NoSuchElementException("Stack has only one element, no penultimate element.");
        }
        E x2 = stack.peek();
        stack.push(x1);
        return x2;
    }

    public static <E> E popPenultimate(Deque<E> stack) {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty, no penultimate element to pop.");
        }
        E x1 = stack.pop();
        if (stack.isEmpty()) {
            stack.push(x1);
            throw new NoSuchElementException("Stack has only one element, no penultimate element to pop.");
        }
        E x2 = stack.pop();
        stack.push(x1);
        return x2;
    }

    public static <E> E bottom(Deque<E> stack) {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        Deque<E> stack1 = new ArrayDeque<E>();
        while(!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        E x = stack1.peek();
        while(!stack1.isEmpty()) {
            stack.push(stack1.pop());
        }
        return x;
    }

    public static <E> E popBottom(Deque<E> stack) {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        Deque<E> stack1 = new ArrayDeque<E>();
        while(!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        E x = stack1.pop();
        while(!stack1.isEmpty()) {
            stack.push(stack1.pop());
        }
        return x;
    }

    // ArrayStack methods - assuming these would be part of an ArrayStack class
    public static class ArrayStack<E> {
        private E[] elements;
        private int size;

        @SuppressWarnings("unchecked")
        public ArrayStack(int capacity) {
            elements = (E[]) new Object[capacity];
            size = 0;
        }

        public void push(E e) {
            if (size == elements.length) {
                throw new IllegalStateException("Stack is full");
            }
            elements[size++] = e;
        }

        public E pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            E e = elements[--size];
            elements[size] = null;
            return e;
        }

        public E peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return elements[size-1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void reverse() {
            for (int i=0; i<size/2; i++) {
                E e = elements[i];
                elements[i] = elements[size-1-i];
                elements[size-1-i] = e;
            }
        }

        public E penultimate() {
            if (size < 2) {
                throw new NoSuchElementException("Stack has fewer than two elements.");
            }
            return elements[size-2];
        }

        public E popPenultimate() {
            if (size < 2) {
                throw new NoSuchElementException("Stack has fewer than two elements to pop.");
            }
            E element = elements[size-2];
            elements[size-2] = elements[size-1];
            elements[size-1] = null;
            --size;
            return element;
        }

        public E bottom() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            return elements[0];
        }

        public E popBottom() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            E element = elements[0];
            for (int i=0; i<size-1; i++) {
                elements[i] = elements[i+1];
            }
            elements[size-1] = null;
            --size;
            return element;
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i = size - 1; i >= 0; i--) {
                sb.append(elements[i]);
                if (i > 0) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    // LinkedStack methods - assuming these would be part of a LinkedStack class
    public static class LinkedStack<E> {
        private static class Node<E> {
            E element;
            Node<E> next;
            Node<E> prev;

            Node(E element, Node<E> prev, Node<E> next) {
                this.element = element;
                this.prev = prev;
                this.next = next;
            }
        }

        private Node<E> head; // Dummy head node for circular doubly linked list
        private int size;

        public LinkedStack() {
            head = new Node<>(null, null, null);
            head.next = head;
            head.prev = head;
            size = 0;
        }

        public void push(E e) {
            Node<E> newNode = new Node<>(e, head.prev, head);
            head.prev.next = newNode;
            head.prev = newNode;
            size++;
        }

        public E pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            Node<E> topNode = head.prev;
            E element = topNode.element;
            topNode.prev.next = head;
            head.prev = topNode.prev;
            topNode.next = null;
            topNode.prev = null;
            size--;
            return element;
        }

        public E peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return head.prev.element;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void reverse() {
            if (head == null || head.next == head || head.next.next == head) {
                return;
            }

            Node<E> current = head.next;
            Node<E> temp = null;

            head.next = head.prev;
            head.prev = current;

            Node<E> prevNode = head;
            Node<E> nextNode;

            while (current != head) {
                nextNode = current.next;
                current.next = prevNode;
                current.prev = nextNode;
                prevNode = current;
                current = nextNode;
            }
        }

        public E penultimate() {
            if (size < 2) {
                throw new NoSuchElementException("Stack has fewer than two elements.");
            }
            return head.prev.prev.element;
        }

        public E popPenultimate() {
            if (size < 2) {
                throw new NoSuchElementException("Stack has fewer than two elements to pop.");
            }
            Node<E> penultimateNode = head.prev.prev;
            E element = penultimateNode.element;
            penultimateNode.prev.next = penultimateNode.next;
            penultimateNode.next.prev = penultimateNode.prev;
            penultimateNode.next = null;
            penultimateNode.prev = null;
            size--;
            return element;
        }

        public E bottom() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            return head.next.element;
        }

        public E popBottom() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            Node<E> bottomNode = head.next;
            E element = bottomNode.element;
            head.next = bottomNode.next;
            bottomNode.next.prev = head;
            bottomNode.next = null;
            bottomNode.prev = null;
            size--;
            return element;
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder("[");
            Node<E> current = head.prev;
            while (current != head) {
                sb.append(current.element);
                if (current.prev != head) {
                    sb.append(", ");
                }
                current = current.prev;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("Demonstrating Stack Operations");

        Deque<Integer> stackDeque = new ArrayDeque<>();
        stackDeque.push(10);
        stackDeque.push(20);
        stackDeque.push(30);
        System.out.println("Original Deque: " + stackDeque);
        System.out.println("Reversed Deque (new): " + reversed(new ArrayDeque<>(stackDeque)));
        Deque<Integer> stackDequePreserved = new ArrayDeque<>();
        stackDequePreserved.push(10);
        stackDequePreserved.push(20);
        stackDequePreserved.push(30);
        System.out.println("Reversed Deque (new, original preserved): " + reversedPreservingOriginal(stackDequePreserved));
        System.out.println("Original Deque after preserving: " + stackDequePreserved);

        Deque<Integer> stackToReverse = new ArrayDeque<>();
        stackToReverse.push(10);
        stackToReverse.push(20);
        stackToReverse.push(30);
        System.out.println("Deque before reverse: " + stackToReverse);
        reverse(stackToReverse);
        System.out.println("Deque after reverse: " + stackToReverse);

        Deque<Integer> stackPenultimate = new ArrayDeque<>();
        stackPenultimate.push(10);
        stackPenultimate.push(20);
        stackPenultimate.push(30);
        System.out.println("Deque: " + stackPenultimate + ", Penultimate: " + penultimate(stackPenultimate));
        System.out.println("Deque after penultimate call: " + stackPenultimate);

        Deque<Integer> stackPopPenultimate = new ArrayDeque<>();
        stackPopPenultimate.push(10);
        stackPopPenultimate.push(20);
        stackPopPenultimate.push(30);
        System.out.println("Deque: " + stackPopPenultimate + ", Popped Penultimate: " + popPenultimate(stackPopPenultimate));
        System.out.println("Deque after popPenultimate call: " + stackPopPenultimate);

        Deque<Integer> stackBottom = new ArrayDeque<>();
        stackBottom.push(10);
        stackBottom.push(20);
        stackBottom.push(30);
        System.out.println("Deque: " + stackBottom + ", Bottom: " + bottom(stackBottom));
        System.out.println("Deque after bottom call: " + stackBottom);

        Deque<Integer> stackPopBottom = new ArrayDeque<>();
        stackPopBottom.push(10);
        stackPopBottom.push(20);
        stackPopBottom.push(30);
        System.out.println("Deque: " + stackPopBottom + ", Popped Bottom: " + popBottom(stackPopBottom));
        System.out.println("Deque after popBottom call: " + stackPopBottom);

        System.out.println("\nDemonstrating ArrayStack Operations");
        ArrayStack<String> arrayStack = new ArrayStack<>(5);
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");
        System.out.println("ArrayStack: " + arrayStack);
        arrayStack.reverse();
        System.out.println("ArrayStack after reverse: " + arrayStack);
        System.out.println("ArrayStack Penultimate: " + arrayStack.penultimate());
        System.out.println("ArrayStack Popped Penultimate: " + arrayStack.popPenultimate());
        System.out.println("ArrayStack after popPenultimate: " + arrayStack);
        System.out.println("ArrayStack Bottom: " + arrayStack.bottom());
        System.out.println("ArrayStack Popped Bottom: " + arrayStack.popBottom());
        System.out.println("ArrayStack after popBottom: " + arrayStack);


        System.out.println("\nDemonstrating LinkedStack Operations");
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("X");
        linkedStack.push("Y");
        linkedStack.push("Z");
        System.out.println("LinkedStack: " + linkedStack);
        linkedStack.reverse();
        System.out.println("LinkedStack after reverse: " + linkedStack);
        System.out.println("LinkedStack Penultimate: " + linkedStack.penultimate());
        System.out.println("LinkedStack Popped Penultimate: " + linkedStack.popPenultimate());
        System.out.println("LinkedStack after popPenultimate: " + linkedStack);
        System.out.println("LinkedStack Bottom: " + linkedStack.bottom());
        System.out.println("LinkedStack Popped Bottom: " + linkedStack.popBottom());
        System.out.println("LinkedStack after popBottom: " + linkedStack);
    }
}