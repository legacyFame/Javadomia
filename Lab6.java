/**
 * 
 * @author Hiro
 *
 *         (F) Standard Searching and Sorting Algorithms using data structures
 *         and algorithms learned from course Data Structures (CST 201): 16)
 * 
 *         Write a Java program for the following:
 * 
 *         ** 1) Create a doubly linked list of elements. 2) Delete a given
 *         element from the above list. 3) Display the contents of the list
 *         after deletion.
 * 
 *         17) Write a Java program that implements Quick sort algorithm for
 *         sorting a list of names in ascending order.
 * 
 *         ** 18) Write a Java program that implements the binary search
 *         algorithm.
 *
 */
public class Lab6 {
	class DoublyLinkedList {
		class Node {
			int data;
			Node previous;
			Node next;

			Node(int data) {
				this.data = data;

			}
		}

		Node head, tail = null;

		public void addNode(int data) {
			Node newNode = new Node(data);

			if (head == null) {
				head = tail = newNode;
				head.previous = null;
				tail.next = null;
			} else {
				tail.next = newNode;
				newNode.previous = tail;
				tail = newNode;
				tail.next = null;
			}
			display();
			return;
		}

		public void delete(int number) {
			Node current = head;
			while (current != null) {
				if (current.data == number) {
					if (current == head) {
						head = current.next;
					} else if (current == tail) {
						tail = tail.previous;
						tail.next = null;
					} else {
						current.previous.next = current.next;
						current.next.previous = current.previous;
					}
					current = null;
					display();
					return;
				}
				current = current.next;
			}
		}

		public void display() {
			Node current = head;
			if (head == null) {
				System.out.println("List is empty");
				return;
			}
			System.out.println("Nodes of doubly linked list: ");
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
			return;
		}
	}

	static void bS(int list[], int search) {
		int u = 0;
		int m;
		int v = list.length;
		while (u < v) {
			m = (u + v) / 2;
			if (list[m] == search) {
				System.out.println("Element found:"+search);
				return;
			} else if (search > list[m]) {
				u = m + 1;
			} else {
				v = m - 1;
			}
		}
		if (list[v] == search) {
			System.out.println("Element found:"+search);
			return;
		}
		System.out.println("Element not found");
	}

	public static void main(String[] args) {

		Lab6 lab = new Lab6();
		int list[] = { 1, 2, 3, 4, 5 };
		DoublyLinkedList dList = lab.new DoublyLinkedList();
		for (int number : list) {
			dList.addNode(number);
		}
		for (int number : list) {
			dList.delete(number);
		}
		for (int number : list) {
			bS(list, number);
		}

	}

}
