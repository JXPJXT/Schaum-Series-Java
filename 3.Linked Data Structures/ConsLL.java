class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class ConsLL {
    public static void main(String[] args) {
        Node start = new Node(22);
        Node p = start;
        p.next = new Node(33);
        p = p.next;
        p.next = new Node(44);
        p = p.next;
        p.next = new Node(55);
        p = p.next;
        p.next = new Node(66);
    }
}
