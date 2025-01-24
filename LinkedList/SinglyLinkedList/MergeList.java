package LinkedList.SLL;

import LinkedList.SLL.Insertion.Node;

public class MergeList {

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

	public static MergeList insert(MergeList list, int data) {
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

	public static MergeList merge(MergeList list1, MergeList list2) {
		MergeList mergelist = new MergeList();

		// pointer1
		Node current1 = list1.head;
		// pointer2
		Node current2 = list2.head;

		// traverse
		while (current1 != null && current2 != null) {
			if (current1.data <= current2.data) {
				insert(mergelist, current1.data);
				current1 = current1.next;
			} else {
				insert(mergelist, current2.data);
				current2 = current2.next;
			}
		}
		while (current1 != null) {
			insert(mergelist, current1.data);
			current1 = current1.next;
		}
		while (current2 != null) {
			insert(mergelist, current2.data);
			current2 = current2.next;
		}
		return mergelist;
	}

	public static void printlist(MergeList list) {
		Node currNode = list.head;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}

	}

	public static void main(String[] args) {

		// 10 20 30 40 50

		MergeList list1 = new MergeList();
		insert(list1, 10);
		insert(list1, 20);
		insert(list1, 30);
		insert(list1, 40);
		System.out.print("list 1 : ");
		printlist(list1);

		System.out.println();

		MergeList list2 = new MergeList();
		insert(list2, 60);
		insert(list2, 70);
		insert(list2, 80);
		insert(list2, 90);
		System.out.print("list 2 : ");
		printlist(list2);

		System.out.println("Merge list: ");
		MergeList mergelist = merge(list1, list2);
		printlist(mergelist);
	}

}
