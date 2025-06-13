class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NodeSample {
    public static void main(String[] args) {
        Node start = new Node(22);
        start.next = new Node(33);
        start.next.next = new Node(44);
        start.next.next.next = new Node(55);
        start.next.next.next.next = new Node(66);

        System.out.print("Created Linked List: ");
        Node current = start;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}