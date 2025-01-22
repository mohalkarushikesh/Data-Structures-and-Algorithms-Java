package LinkedList.SLL;

import LinkedList.SLL.Insertion.Node;

public class Search {
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

	public static Search insert(Search list, int data) {
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

	public static int search(Search list, int element) { // search by value and return index

		Node currNode = list.head;
		int index = 0;
		while (currNode != null) {
			if (currNode.data == element) {
				return index;
			}
			currNode = currNode.next;
			index++;
		}
		return -1;
	}

	public static void printlist(Search list) {
		Node currNode = list.head;

		System.out.print("Singly LL ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}

	}

	public static void main(String[] args) {

		// 10 20 30 40 50

		Search list = new Search();
		insert(list, 10);
		insert(list, 20);
		insert(list, 30);
		insert(list, 40);

		printlist(list);

		System.out.println();

		int index = search(list, 40);
		if (index == -1) {
			System.out.println("not found");
		} else {
			System.out.println("found at index : " + index);
		}
		

	}

}
