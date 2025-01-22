package LinkedList.SLL;

import LinkedList.SLL.Insertion.Node;

public class Sort {

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

	public static Sort insert(Sort list, int data) {
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

	public static Sort bubblesort(Sort list) {
		Node currNode = list.head, index;
		System.out.println("sorted list: ");
		for (currNode = list.head; currNode != null; currNode = currNode.next) {
			for (index = currNode.next; index != null; index = index.next) {
				if (currNode.data > index.data) {
					int temp = currNode.data;
					currNode.data = index.data;
					index.data = temp;
				}
			}
		}

		return list;
	}

	public static void printlist(Sort list) {
		Node currNode = list.head;

		System.out.print("Singly LL ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}

	}

	public static void main(String[] args) {

		// 10 20 30 40 50

		Sort list = new Sort();
		insert(list, 20);
		insert(list, 10);
		insert(list, 90);
		insert(list, 60);
		insert(list, 80);
		insert(list, 30);

		printlist(list);
		
		System.out.println();
		
		bubblesort(list);
		printlist(list);

	}

}
