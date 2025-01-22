package LinkedList.SLL;

import LinkedList.SLL.Insertion.Node;

public class DeleteAtPosition {
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

	public static DeleteAtPosition insert(DeleteAtPosition list, int data) {
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

	public static DeleteAtPosition deleteatposition(DeleteAtPosition list, int index) {
		Node currNode = list.head;
		Node prev = null;

		// found at index 0
		if (index == 0 && currNode != null) {
			list.head = currNode.next; // head is deleted
			return list;
		}
		// else other index
		int counter = 0;
		while (currNode != null) {
			if (counter == index) {
				prev.next = currNode.next; // unlink the currNode
				break;
			}
			prev = currNode;
			currNode = currNode.next;
			counter++;
		}

		// not found
		if (currNode == null) {
			System.out.println("index not found!");
		}

		return list;
	}

	public static void printlist(DeleteAtPosition list) {
		Node currNode = list.head;

		System.out.print("Singly LL ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}

	}

	public static void main(String[] args) {

		// 10 20 30 40 50

		DeleteAtPosition list = new DeleteAtPosition();
		insert(list, 10);
		insert(list, 20);
		insert(list, 30);
		insert(list, 40);

		printlist(list);

		System.out.println();

		deleteatposition(list, 1);
		printlist(list);

	}

}
