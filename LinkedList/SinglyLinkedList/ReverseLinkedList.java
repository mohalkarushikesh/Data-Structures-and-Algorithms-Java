package LinkedList.SLL;

import LinkedList.SLL.Insertion.Node;

public class ReverseLinkedList {
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

	public static ReverseLinkedList insert(ReverseLinkedList list, int data) {
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

	public static ReverseLinkedList reverselinkedlist(ReverseLinkedList list) {

		Node currNode = list.head, next;
		Node prev = null;
		// store next
		// reverse pointer
		// prev becomes currNode
		// currNode becomes next

		// set head
		while (currNode != null) {
			next = currNode.next;
			currNode.next = prev;
			prev = currNode;
			currNode = next;
		}
		list.head  = prev;
		return list;
	}

	public static void printlist(ReverseLinkedList list) {
		Node currNode = list.head;

		System.out.print("Singly LL ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}

	}

	public static void main(String[] args) {

		// 10 20 30 40 50

		ReverseLinkedList list = new ReverseLinkedList();
		insert(list, 10);
		insert(list, 20);
		insert(list, 30);
		insert(list, 40);
		insert(list, 50);

		printlist(list);

		System.out.println();
		
		reverselinkedlist(list);
		printlist(list);
		
	}

}
