package LinkedList;

public class SinglyLinkedList {
	Node head; // head of list

	static class Node { // Linked list node
		int data;
		Node next;

		Node(int data) { // constructor
			this.data = data;
			this.next = null;
		}
	}

	// method to insert new node
	public static SinglyLinkedList insertAtPosition(SinglyLinkedList list, int index, int data) {
		// create new node
		Node new_node = new Node(data);

		if (list.head == null && index == 0) { 
			new_node.next = list.head; //  sets the next pointer of the new node to the current head of the list. Essentially, it links the new node to the existing list.
			list.head = new_node;	// set newNode to head 
			System.out.println("At index " + index + " inserted " + data);
			return list;
		}

		Node currNode = list.head;
		Node prev = null;
		int counter = 0;
		while (currNode != null && counter < index) {
			prev = currNode;	// prev node updated to currNode 
			currNode = currNode.next;	// currNode updated to next node 
			counter++;
		}

		new_node.next = currNode;
		if (prev != null) { // it means the new node is not being inserted at the head, so prev.next is set to the new node.
			prev.next = new_node;	// here insert operation happens
		}

		System.out.println("At index " + index + " inserted " + data);
		return list;
	}

	// delete node
	public static SinglyLinkedList deleteAtPosition(SinglyLinkedList list, int index) {
		Node currNode = list.head, prev = null;

		if (index == 0 && currNode != null) {
			list.head = currNode.next;
			System.out.println("element at head is deleted!");
			return list;
		}

		// delete in between

		int counter = 0;

		while (currNode != null) {
			if (index == counter) {
				prev.next = currNode.next;
				System.out.println("Index " + index + " is deleted!");
				break;
			} else {
				prev = currNode; // prev node updated to currNode
				currNode = currNode.next; // currNode updated to next node
				counter++;
			}
		}

		// index not found
		if (currNode == null) {
			System.out.println("Index " + index + " not found!");
		}

		return list; // return the updates list
	}

	// search
	public static int search(SinglyLinkedList list, int element) {
		if (list.head == null) {
			return -1;
		}
		Node temp = list.head;
		int index = 0;
		while (temp != null) {
			if (element == temp.data) {
				return index;
			}
			index++;
			temp = temp.next;
		}
		return -1;
	}

	// printing linked list
	public static void printList(SinglyLinkedList list) {
		Node currNode = list.head; // currently head is current node
		System.out.print("Linked list: ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next; // move to next node
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		list = insertAtPosition(list, 0, 10);
		list = insertAtPosition(list, 1, 20);
		list = insertAtPosition(list, 2, 30);
		list = insertAtPosition(list, 4, 50);

		printList(list);

		list = insertAtPosition(list, 3, 40);

		// printList(list);

		int element = 50;

		int ans = search(list, element);

		if (ans == -1) {
			System.out.println("element not found in liked list");
		} else {
			System.out.println("element found at the index " + ans);
		}
	}
}
