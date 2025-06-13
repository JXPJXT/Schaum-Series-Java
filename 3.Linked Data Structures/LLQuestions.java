public class LLQuestions {

    static class Node {
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

    public static void main(String[] args) {
        Node head = new Node(10, new Node(20, new Node(30, new Node(40, new Node(50, new Node(60))))));
        
        System.out.println("--- Initial Linked List ---");
        printList(head);

        System.out.println("\n--- Calling deleteQ1 (deletes last element <= 35) ---");
        head = deleteQ1(head, 35);
        System.out.println("List after deleteQ1:");
        printList(head);

        System.out.println("\n--- Calling sizeQ2 ---");
        int listSize = sizeQ2(head);
        System.out.println("Size: " + listSize);

        System.out.println("\n--- Calling sumQ3 ---");
        int totalSum = sumQ3(head);
        System.out.println("Sum: " + totalSum);

        System.out.println("\n--- Calling removeLastQ4 ---");
        head = removeLastQ4(head);
        System.out.println("List after removeLastQ4:");
        printList(head);

        System.out.println("\n--- Calling copyQ5 ---");
        Node copiedList = copyQ5(head);
        System.out.println("Copied list:");
        printList(copiedList);
        System.out.println("Original list remains unchanged:");
        printList(head);

        System.out.println("\n--- Calling sublistQ6 ---");
        Node sub = sublistQ6(head, 1, 3);
        System.out.println("Resulting sublist from index 1 to 3:");
        printList(sub);
        
        System.out.println("\n--- Calling appendQ7 ---");
        Node listToAppend = new Node(100, new Node(200));
        System.out.println("List to append:");
        printList(listToAppend);
        Node listForAppend = copyQ5(head);
        appendQ7(listForAppend, listToAppend);
        System.out.println("Appending to a copy of the main list:");
        printList(listForAppend);
        
        System.out.println("\n--- Calling concatQ8 ---");
        Node secondList = new Node(99, new Node(88));
        System.out.println("Concatenating main list:");
        printList(head);
        System.out.println("with second list:");
        printList(secondList);
        Node concatenatedList = concatQ8(head, secondList);
        System.out.println("Result of concatenation (new list):");
        printList(concatenatedList);
        
        System.out.println("\n--- Calling get ---");
        int val = get(head, 2);
        System.out.println("Value at index 2 is: " + val);

        System.out.println("\n--- Calling set ---");
        set(head, 2, 999);
        System.out.println("List after setting index 2 to 999:");
        printList(head);

        System.out.println("\n--- Calling put ---");
        head = put(head, 0, 5);
        System.out.println("List after putting 5 at index 0:");
        printList(head);

        System.out.println("\n--- Calling swap ---");
        swap(head, 1, 4);
        System.out.println("List after swapping elements at index 1 and 4:");
        printList(head);
        
        System.out.println("\n--- Calling merged ---");
        Node mergeList1 = new Node(5, new Node(15, new Node(25)));
        Node mergeList2 = new Node(10, new Node(20, new Node(30)));
        System.out.println("Merging list1:");
        printList(mergeList1);
        System.out.println("with list2:");
        printList(mergeList2);
        Node mergedList = merged(mergeList1, mergeList2);
        System.out.println("Result of merge:");
        printList(mergedList);

        System.out.println("\n--- Calling rotateLeft ---");
        head = rotateLeft(head);
        System.out.println("List after rotating left:");
        printList(head);
    }

    static void printList(Node list) {
        if (list == null) {
            System.out.println("null");
            return;
        }
        Node current = list;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    static Node deleteQ1(Node list, int x) {
        if (list == null) {
            return null;
        }
        if (list.data > x) {
            return list;
        }

        Node current = list;
        Node prev = null;
        while (current.next != null && current.next.data <= x) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            return current.next;
        } else {
            prev.next = current.next;
            return list;
        }
    }

    static int sizeQ2(Node list) {
        int count = 0;
        Node current = list;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    static int sumQ3(Node list){
        int sum = 0;
        Node current = list;
        while(current != null){
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    static Node removeLastQ4(Node list){
        if(list == null || list.next == null){
            return null;
        }
        Node current = list;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
        return list;
    }

    static Node copyQ5(Node list){
        if(list == null){
            return null;
        }
        Node newHead = new Node(list.data);
        Node currentNew = newHead;
        Node currentOld = list.next;
        while(currentOld != null){
            currentNew.next = new Node(currentOld.data);
            currentNew = currentNew.next;
            currentOld = currentOld.next;
        }
        return newHead;
    }

    static Node sublistQ6(Node list, int m, int n){
        if(m < 0 || n < m || list == null){
            return null;
        }
        Node current = list;
        for(int i = 0; i < m && current != null; i++){
            current = current.next;
        }
        if(current == null){
            return null;
        }
        Node newHead = new Node(current.data);
        Node newCurrent = newHead;
        current = current.next;
        for(int i = m + 1; i < n && current != null; i++){
            newCurrent.next = new Node(current.data);
            newCurrent = newCurrent.next;
            current = current.next;
        }
        return newHead;
    }

    static void appendQ7(Node list1, Node list2){
        if(list1 == null){
            list1 = list2;
            return;
        }
        Node current = list1;
        while(current.next != null){
            current = current.next;
        }
        current.next = list2;
    }

    static Node concatQ8(Node list1, Node list2){
        Node result = copyQ5(list1);
        Node list2Copy = copyQ5(list2);
        if (result == null) {
            return list2Copy;
        }
        appendQ7(result, list2Copy);
        return result;
    }
    
    static int get(Node list, int i){
        if (i < 0) throw new IllegalArgumentException();
        Node current = list;
        for (int j = 0; j < i; j++) {
            if (current == null) throw new IllegalArgumentException();
            current = current.next;
        }
        if (current == null) throw new IllegalArgumentException();
        return current.data;
    }

    static void set(Node list, int i, int x){
        if (i < 0) throw new IllegalArgumentException();
        Node current = list;
        for (int j = 0; j < i; j++) {
            if (current == null) throw new IllegalArgumentException();
            current = current.next;
        }
        if (current == null) throw new IllegalArgumentException();
        current.data = x;
    }

    static Node put(Node list, int i, int x){
        if (i < 0) throw new IllegalArgumentException();
        if (i == 0) {
            return new Node(x, list);
        }
        Node current = list;
        for (int j = 0; j < i - 1; j++) {
            if (current == null) throw new IllegalArgumentException();
            current = current.next;
        }
        if (current == null) throw new IllegalArgumentException();
        current.next = new Node(x, current.next);
        return list;
    }

    static void swap(Node list, int i, int j){
        if (i < 0 || j < 0 || i == j) return;
        Node nodeI = list;
        Node nodeJ = list;
        for (int k = 0; k < i; k++) {
            if (nodeI == null) throw new IllegalArgumentException();
            nodeI = nodeI.next;
        }
        for (int k = 0; k < j; k++) {
            if (nodeJ == null) throw new IllegalArgumentException();
            nodeJ = nodeJ.next;
        }
        if (nodeI == null || nodeJ == null) throw new IllegalArgumentException();
        int temp = nodeI.data;
        nodeI.data = nodeJ.data;
        nodeJ.data = temp;
    }

    static Node merged(Node list1, Node list2){
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node head;
        if (list1.data <= list2.data) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        Node current = head;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }
        return head;
    }
    
    static Node rotateLeft(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node firstNode = head;
        Node newHead = head.next;
        Node lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = firstNode;
        firstNode.next = null;
        return newHead;
    }
}
