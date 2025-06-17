public class LLPrac{
    public static void main(String args[]){
        Node head = new Node(1);
        head.next= new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next= new Node(5);
        head.next.next.next.next.next= new Node(6);
        head.next.next.next.next.next.next= new Node(7);
        System.out.println("Length of LL: "+lengthOfLL(head));
        System.out.println("Search 6 in LL: "+searchVal(head, 6));
    }
    static int lengthOfLL(Node head){
        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            temp=temp.next;
            cnt++;
        }
        return cnt;
    }
    static int searchVal(Node head,int target){
        int counter = 0;
        Node temp = head;
        while(temp!=null){
            if(temp.data==target){
                return ++counter;
            }
            else{
                temp=temp.next;
                counter++;
            }
        }
        return counter;
    }
    
}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
}