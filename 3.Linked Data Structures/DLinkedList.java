public class DLinkedList {
    public static class Node {
        public int data;
        public Node next;
        public Node back;

        public Node(int data1, Node next1, Node back1) {
            data = data1;
            next = next1;
            back = back1;
        }

        public Node(int data1) {
            data = data1;
            next = null;
            back = null;
        }
    }

    private static Node convertArr2DLL(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node insertAtTail(Node head, int k) {
        Node newNode = new Node(k);

        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.back = current;

        return head;
    }
    
    static Node deleteLast(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node newTail = tail.back;
        newTail.next = null;
        tail.back = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 4};
        Node head = convertArr2DLL(arr);

        System.out.println("Doubly Linked List Initially: ");
        print(head);

        System.out.println("Doubly Linked List After Inserting At End:");
        head = insertAtTail(head, 10);
        print(head);

        System.out.println("Deleting Tail Element:");
        head = deleteLast(head);
        print(head);
    }
}