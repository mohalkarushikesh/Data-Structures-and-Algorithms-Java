package LinkedList;

import org.jcp.xml.dsig.internal.SignerOutputStream;

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
			newNode.nxt = head;
			head = newNode;
		}
		Node last = head;
		while (last.nxt != null) {
			last = last.nxt;
		}
		last.nxt = newNode;
		System.out.println(newNode.data + " inserted at the end ");
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

	public static void searchByValue() {

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
	}
}
