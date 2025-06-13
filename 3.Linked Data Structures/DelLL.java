public class DelLL {
    public static void main(String[] args) {
        Node start = new Node(22);
        Node p = start;
        for (int i = 1; i < 5; i++) {
            p = p.next = new Node(22 + 11 * i);
        }
        System.out.println("Orignal LL");

        Node current = start;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }
    Node delete(Node start, int x){
        if(start==null||start.data>x){
            return start;
        }
        
    }
}
