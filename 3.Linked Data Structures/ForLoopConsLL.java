class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ForLoopConsLL {
    public static void main(String[] args) {
        Node start = new Node(22),p=start;
        for(int i=0;i<4;i++){
            p = p.next = new Node(33+11*i);
        }
        System.out.print("Created Linked List: ");
        Node current = start;
        while(current!=null){
            System.out.print(current.data+"->");
            current=current.next;
            if(current.data==66){
                System.out.print(current.data);
                current=current.next;
            }
        }
        System.out.println();
        System.out.println("null");
    }
     
}

