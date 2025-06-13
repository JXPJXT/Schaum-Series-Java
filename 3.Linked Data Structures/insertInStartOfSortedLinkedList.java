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

public class insertInStartOfSortedLinkedList {
    public static void main(String[] args) {
        Node start = new Node(22);
        Node p = start;

        for (int i = 1; i < 5; i++) {
            p.next = new Node(22 + 11 * i);
            p = p.next;
        }

        System.out.println("Original list:");
        printList(start);

        start = insertInSorted(start, 40);

        System.out.println("\nList after inserting 40:");
        printList(start);
        
        start = insertInSorted(start, 10);

        System.out.println("\nList after inserting 10:");
        printList(start);
    }

    static Node insertInSorted(Node start, int x) {
        if (start == null || start.data > x) {
            start = new Node(x, start);
            return start;
        }

        Node p = start;
        while (p.next != null) {
            if (p.next.data > x) {
                break;
            }
            p = p.next;
        }

        p.next = new Node(x, p.next);
        return start;
    }
    
    static void printList(Node start) {
        Node p = start;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.print("null");
    }
}