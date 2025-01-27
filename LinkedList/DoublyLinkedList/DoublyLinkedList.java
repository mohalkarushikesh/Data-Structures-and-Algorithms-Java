package LinkedList.DLL;

public class DoublyLinkedList {

	Node head;
	// create node class

	static class Node {
		Node prev;
		Node next;
		int data;

		Node(int data) {
			this.prev = null;
			this.data = data;
			this.next = null;
		}
	}

	// insert at begin

	public static DoublyLinkedList insertatbegin(DoublyLinkedList list, int data) {
		Node newNode = new Node(data);
		// check list is empty
		if (list.head != null) {
			list.head.prev = newNode;// we have set the head null so update prev head pointer
		}
		// newNode points to head
		newNode.next = list.head;
		// newNode becomes the head
		list.head = newNode;
		return list;
	}

	// insert at end

	public static DoublyLinkedList insertatend(DoublyLinkedList list, int data) {
		Node newNode = new Node(data);

		// check if list is empty
		if (list.head == null) {
			list.head = newNode;
			return list;
		}
		// else
		Node currNode = list.head;
		while (currNode.next != null) {
			currNode = currNode.next;
		}
		currNode.next = newNode;
		newNode.prev = currNode;

		return list;
	}

	// insert at position

	// delete at begin , end , position

	// print doubly linked list

	public static DoublyLinkedList printlist(DoublyLinkedList list) {
		Node currNode = list.head;
		System.out.print("doubly linked list ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		return list;
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		insertatbegin(list, 10);
		printlist(list);

		System.out.println();

		insertatend(list, 20);
		insertatend(list, 30);
		insertatend(list, 40);
		printlist(list);

	}
}
