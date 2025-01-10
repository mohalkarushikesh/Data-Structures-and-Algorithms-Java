package LinkedList;

public class SinglyLinkedList {
	Node head;

	static class Node {
		int data;
		Node nxt;

		Node(int data) {
			this.data = data;
			this.nxt = null;
		}
	}

	// index based insertion
	public static SinglyLinkedList insertAtAnyPosition(SinglyLinkedList list, int index, int data) {
		Node newNode = new Node(data);
		if (list.head == null && index == 0) {
			newNode.nxt = list.head;
			list.head = newNode;
			System.out.println("at index " + index + " inserted " + data + " Basically inserted at the beginning");
			return list;
		}
		// other index
		Node currNode = list.head;
		Node prev = null;
		int counter = 0;
		while (currNode != null && counter < index) {
			prev = currNode;
			currNode = currNode.nxt;
			counter++;
		}
		newNode.nxt = currNode;
		if (prev != null) {
			prev.nxt = newNode;
		}
		System.out.println("at index " + index + " inserted " + data);
		return list;
	}

	// index based deletion
	public static SinglyLinkedList deleteAtPosition(SinglyLinkedList list, int index) {
		Node currNode = list.head, prev = null;

		if (currNode != null && index == 0) {
			list.head = currNode.nxt;
			System.out.println("at index " + index + " deleted, i.e " + " beginning of the list " + currNode.data
					+ " is deleted ");
		}

		int counter = 0;
		while (currNode != null) {
			if (index == counter) {
				if (prev != null) {
					prev.nxt = currNode.nxt;
					System.out.println("at index " + index + " element " + currNode.data + " is deleted");
				}
				break;
			} else {
				prev = currNode;
				currNode = currNode.nxt;
				counter++;
			}
		}

		if (currNode == null) {
			System.out.println(index + " not found");
		}

		return list;
	}

	// insert at the beginning
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		newNode.nxt = head;
		head = newNode;
		System.out.println(data + " inserted at the beginning");
	}

	public void insertAfter(Node prevNode, int data) {
		// check if prev Node is null or not
		if (prevNode == null) {
			System.out.println("prevNode should be not be NULL");
			return;
		}
		Node newNode = new Node(data);
		newNode.nxt = prevNode.nxt;
		prevNode.nxt = newNode;
		System.out.println(newNode.data + " inserted after " + prevNode.data);
	}

	public void insertatend(int data) { // or else renamed as append method
		Node newNode = new Node(data);
		if (head == null) { // if the list is empty
			head = newNode;
			return;
		}
		Node last = head;
		while (last.nxt != null) {
			last = last.nxt;
		}
		last.nxt = newNode;
		// System.out.println(newNode.data + " inserted at the end ");
	}

	public void deleteFirstNode() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		}
		System.out.println(head.data + " The element at the beginning is deleted ");
		head = head.nxt;

	}

	public void deleteMidddleNode(Node prevNode) {
		if (prevNode == null || prevNode.nxt == null) {
			System.out.println("No need to delete after the given node");
			return;
		}
		Node nodeToDelete = prevNode.nxt;
		prevNode.nxt = nodeToDelete.nxt;
		System.out.println("deleted node " + nodeToDelete.data + " after the given node " + prevNode.data);
	}

	public void deleteEndNode() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		}
		if (head.nxt == null) { // if only one element
			head = null;
			return;
		}
		Node secLast = head;
		while (secLast.nxt.nxt != null) {
			secLast = secLast.nxt;
		}
		System.out.println(secLast.nxt.data + " is deleted i.e is  last element is deleted");
		secLast.nxt = null;

	}

	public int searchByValue(SinglyLinkedList list, int element) {
		if (list.head == null) {
			return -1;
		}
		Node temp = list.head;
		int index = 0;
		while (temp != null) {
			if (temp.data == element) {
				return index;
			}
			temp = temp.nxt;
			index++;
		}
		return -1;
	}

	public void deleteByValue(int key) {
		Node temp = head, prev = null;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (temp != null && temp.data == key) {
			head = temp.nxt;
			System.out.println(temp.data + " i.e key found at head (RIP)");
			return;
		}
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.nxt;
		}
		if (temp == null) {
			System.out.println("key is not found");
			return;
		}
		if (prev != null) {
			prev.nxt = temp.nxt;
			System.out.println("RIP to " + temp.data);
		}

	}

	// length
	public void getListLength() {
		int length = 0;
		Node currNode = head;
		while (currNode != null) {
			length++;
			currNode = currNode.nxt;
		}
		System.out.println("Length of the list: " + length);
	}

	// reverse
	public void reverseLinkedList() {
		Node next = null;
		Node currNode = head;
		Node prev = null;
		System.out.println("Reversed Linked List");
		while (currNode != null) {
			next = currNode.nxt; // store curr nodes next
			currNode.nxt = prev; // reverse the pointer
			prev = currNode; // update the prev
			currNode = next; // update the currNode
		}
		head = prev; // set the new head

	}

	// sort
	public void sortLinkedList() {
		System.out.println("sorted linked list ");
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Node currNode, index;
		for (currNode = head; currNode != null; currNode = currNode.nxt) {
			for (index = currNode.nxt; index != null; index = index.nxt) {
				if (currNode.data > index.data) {
					int temp = currNode.data;
					currNode.data = index.data;
					index.data = temp;
				}
			}
		}
	}

	// merge
	public static SinglyLinkedList mergeLinkedList(SinglyLinkedList list, SinglyLinkedList list2) {
		SinglyLinkedList mergelist = new SinglyLinkedList();
		Node current1 = list.head; // pointer 1
		Node current2 = list2.head; // pointer 2

		while (current1 != null && current2 != null) {
			if (current1.data <= current2.data) {
				mergelist.insertatend(current1.data);
				current1 = current1.nxt;
			} else {
				mergelist.insertatend(current2.data);
				current2 = current2.nxt;
			}
		}
		while (current1 != null) {
			mergelist.insertatend(current1.data);
			current1 = current1.nxt;
		}
		while (current2 != null) {
			mergelist.insertatend(current2.data);
			current2 = current2.nxt;
		}

		return mergelist;
	}

	// split
	public SinglyLinkedList[] splitLinkedList() {
		SinglyLinkedList[] lists = new SinglyLinkedList[2]; // split linked list into two
		lists[0] = new SinglyLinkedList();
		lists[1] = new SinglyLinkedList();

		Node fast = head, slow = head; // pointers

		while (fast != null && fast.nxt != null) { // When fast reaches the end of the list, slow will be at the middle.
			fast = fast.nxt.nxt;
			slow = slow.nxt;
		}
		lists[0].head = head; // means lists[0] contains the first half of the list // lists[0] starts from
								// the beginning of the original list.
		lists[1].head = slow.nxt; // means lists[1] contains the second half of the list // so lists[1] starts
									// from the middle of the original list.
		slow.nxt = null; // slow.nxt is set to null to break the link between the two halves.
		// By setting the heads and breaking the link, you’re effectively
		// creating two new lists without needing to move nodes around manually. The
		// nodes are already in place; you’re just reassigning the starting points and
		// breaking the connection between the two halves.
		return lists;
	}

	public void printlist() {
		Node temp = head;
		System.out.print("Linked List: ");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.nxt;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		System.out.println("****************Singly Linked List operations*************");
		System.out.println();

		SinglyLinkedList list = new SinglyLinkedList();

		list = insertAtAnyPosition(list, 0, 10);
		list = insertAtAnyPosition(list, 1, 20);
		list = insertAtAnyPosition(list, 2, 30);
		list = insertAtAnyPosition(list, 4, 50);
		list = insertAtAnyPosition(list, 5, 60);
		list = insertAtAnyPosition(list, 6, 70);
		list.printlist();

		System.out.println();

		list = insertAtAnyPosition(list, 3, 40);
		list.printlist();
		System.out.println();
		list = deleteAtPosition(list, 0);
		list.printlist();
		System.out.println();
		list = deleteAtPosition(list, 5);
		list.printlist();
		System.out.println();
		list.insertAtBeginning(9);
		list.printlist();
		System.out.println();
		Node fourth = list.head.nxt.nxt.nxt;

		list.insertAfter(fourth, 45);
		list.printlist();
		System.out.println();
		list.insertatend(70);
		list.printlist();
		System.out.println();
		list.deleteFirstNode();
		list.printlist();
		System.out.println();
		Node fortyFive = list.head.nxt.nxt;

		list.deleteMidddleNode(fortyFive);
		list.printlist();
		System.out.println();
		list.deleteEndNode();
		list.printlist();
		System.out.println();
		int index = list.searchByValue(list, 60);
		if (index == -1) {
			System.out.println("Element not found in list");
		} else {
			System.out.println("Element found at index " + index);
		}
		list.printlist();
		System.out.println();

		list.deleteByValue(60);
		list.printlist();
		System.out.println();

		list.getListLength();
		list.printlist();
		System.out.println();

		list.reverseLinkedList();
		list.printlist();
		System.out.println();

		list.sortLinkedList();
		list.printlist();
		System.out.println();

		// list 1
		System.out.println("list 1 : ");
		list.printlist();

		// make list 2
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insertatend(60);
		list2.insertatend(70);
		list2.insertatend(80);
		list2.insertatend(90);
		System.out.println("list 2 : ");
		list2.printlist();

		// merge
		SinglyLinkedList mergelist = mergeLinkedList(list, list2);
		System.out.println("Merged Linked List ");
		mergelist.printlist();
		System.out.println();

		// split the merged list
		SinglyLinkedList[] lists = mergelist.splitLinkedList();
		System.out.println("split list 1 ");
		lists[0].printlist();
		System.out.println("split list 2 ");
		lists[1].printlist();

	}
}
