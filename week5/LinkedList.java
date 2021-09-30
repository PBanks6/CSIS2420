package week5;

public class LinkedList {
	Node head;
	Node tail;

	public void append(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}

	public void printList() {
		Node current = head;
		System.out.print("List Contents: ");
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void Prepend(int data) {
		Node prepend = new Node(data);

		if (head == null) {
			head = prepend;
			tail = prepend;
		} else {
			Node cur = head;
			head = prepend;
			head.next = cur;
		}

	}

	public void Delete(int data) {
		if (head.data == data) {
			head = head.next;
			return;
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
		System.out.println("The provided value is not found in this list");
	}

	public void Search(int data) {
		int pos = 0;
		if (head.data == data) {
			head = head.next;
			System.out.println(data + " was found in location " + pos + ".");
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				System.out.println(data + " was found in location " + pos + ".");
			}
			pos++;
			current = current.next;
		}
	}

	public void Length() {
		int leng = 0;
		Node current = head;
		while (current.next != null) {
			leng++;
			current = current.next;
		}

		System.out.println("The length of the list is " + (leng + 1));
	}
}
