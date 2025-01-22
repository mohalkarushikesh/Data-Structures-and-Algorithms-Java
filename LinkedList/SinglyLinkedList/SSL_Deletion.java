package LinkedList;

import LinkedList.SLL_Insertion.Node;

public class SLL_Deletion {

	Node head;

	static class Node { // inner class made static so the main method can access it
		int data;
		Node next;

		// constructor
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static SLL_Deletion insert(SLL_Deletion list, int data) {
		// create node
		Node newNode = new Node(data);

		// check if list empty
		if (list.head == null) {
			list.head = newNode;
			return list;
		} else {
			// temp node
			Node last = list.head;

			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}

		return list;
	}

	public static SLL_Deletion delete(SLL_Deletion list, int element) {

		Node currNode = list.head;
		Node prev = null;

		// found at head
		// change head to currNode next

		if (currNode != null && currNode.data == element) {
			list.head = currNode.next; // change the head;
			return list;
		}
		// found at last
		// find the previous node of node to be deleted
		// prev.next = currNode.next;

		while (currNode != null && currNode.data != element) {
			prev = currNode;
			currNode = currNode.next;
		}

		if (currNode != null) {
			prev.next = currNode.next; // unlink currNode from linked list
		}

		// not found
		if (currNode == null) {
			System.out.println("Element not found");
		}
		return list;
	}

	public static void printlist(SLL_Deletion list) {
		Node currNode = list.head;

		System.out.print("Singly LL ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}

	}

	public static void main(String[] args) {

		// 10 20 30 40 50

		SLL_Deletion list = new SLL_Deletion();
		insert(list, 10);
		insert(list, 20);
		insert(list, 30);
		insert(list, 40);
		printlist(list);
		
		System.out.println();
		
		delete(list, 40);
		printlist(list);

	}
}
