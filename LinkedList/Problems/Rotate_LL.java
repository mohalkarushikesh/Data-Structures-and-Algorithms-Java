class Rotate_LL{
    Node head;
    // node class
    static class Node{
        int data;
        Node next;
        Node(int data){ // constructor
            this.data = data;
            this.next = null;
        }
    }
    // insert
    public static Rotate_LL insert(Rotate_LL list, int data){
        Node newNode = new Node(data);

        if(list.head == null){
            list.head = newNode;
            return list;
        }else{
            Node temp = list.head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return list;
    }

    // print
    public static void printlist(Rotate_LL list){
        Node temp = list.head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node rotate(Node head, int k){

        if(head == null || k == 0) return head; // check list is empty

        int len = 1;

        Node tail = head; // each rotation

        while( tail.next != null){ // traverse the last node to find the len
            tail = tail.next;
            len++;
        }

        if(k % len == 0 ) return head;  // k is multiple of list length no rotation

        k = k % len;    // cal effective rotation

        tail.next = head;  // connect last node to head to form circular list

        Node newLastNode = findLastNode(head , len - k);    // find new last node after len - k

        head = newLastNode.next;   // update the head to new starting node

        newLastNode.next = null;    // break circular link to form new list

        return head;    // reuturn head of the rotated list
    }

    public static Node findLastNode(Node temp, int k){
        int cnt = 1;

        while(temp.next != null){ // traverse to find node at point k
            if(cnt == k ) return temp; // return node at position
            cnt++;
            temp = temp.next ;
        }
        return temp; // always return node
    }

    public static void main(String args[]){
        Rotate_LL list = new Rotate_LL();

        insert(list, 10);
        insert(list, 20);
        insert(list, 30);
        insert(list, 40);
        insert(list, 50);

        System.out.print("Linked List : ");
        printlist(list);
        System.out.println();
        list.head = rotate(list.head, 2);
        System.out.print("Rotated List: ");
        printlist(list);
    }
}


/*

10 -> 20 -> 30 -> 40 -> 50
^                        |
|________________________|
1. calculate len: k = k % len
2. effective rotation: tail.nxt!=null
3. form circular list: tail-next = head
4. find newLatNode: len-k
5. update head & break circular link: head = newLastNode.nxt & newLastNode.nxt=null

*/
