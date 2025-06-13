public class InsLL {
    public static void main(String[] args) {
        Node start = new Node(22);
        Node p = start;
        for (int i = 1; i < 5; i++) {
            p = p.next = new Node(22 + 11 * i);
        }

        start = insert(start, 11);

        Node current = start;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }

    static Node insert(Node start, int x) {
        if (start == null || start.data > x) {
            Node newNode = new Node(x, start);
            return newNode;
        }

        Node s = start;
        while (s.next != null && s.next.data < x) {
            s = s.next;
        }

        s.next = new Node(x, s.next);
        return start;
    }
}
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
