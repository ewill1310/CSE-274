import java.util.NoSuchElementException;

public class LinkedList {

	private Node head;
	private Node tail;
	private int size;

	/*
	 * Creates an empty list.
	 */
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/*
	 * Returns a space-separated list of the elements in the list. If the list
	 * contains no elements, return an empty string ""
	 */
	public String toString() {
		String temp = "";
		Node current = head;
		while (current != null) {
			temp = temp + current.data + " ";
			current = current.next;
		}
		return temp;
	}

	/*
	 * Returns the first item in the list. If the list is empty, throw a
	 * NoSuchElementException.
	 */
	public int getFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			Node current = this.head;
			while (current.previous != null) {
				current = current.previous;
			}
			return current.data;
		}
	}

	/*
	 * Returns the last item in the list. If the list is empty, throw a
	 * NoSuchElementException.
	 */
	public int getLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			Node current = this.tail;
			while (current.next != null) {
				current = current.next;
			}
			return current.data;
		}
	}

	/*
	 * Returns the item at the specified index. If the index is not valid, throw an
	 * IndexOutOfBoundsException.
	 */
	public int getAt(int index) {
		Node current = this.head;
		if (index >= 0 && index <= size) {
			while (current.previous != null) {
				current = current.previous;
			}
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.data;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/*
	 * Inserts an item at the beginning of the list.
	 */
	public void insertFirst(int num) {
		Node newNode = new Node(num);
		if (head == null) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
			size++;
		}
	}

	/*
	 * Inserts an item at the end of the list.
	 */
	public void insertLast(int num) {
		Node newNode = new Node(num);
		if (tail == null) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	/*
	 * Removes and returns the first element from the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public int removeFirst() {
		Node current = this.head;
		if (current != null) {
			int curr = current.data;
			head = current.next;
			return curr;
		}else {
			throw new NoSuchElementException();
		}
		
	}

	/*
	 * Removes and returns the last element from the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public int removeLast() {
		Node current = this.tail;
		if (current != null) {
			int curr = current.data;
			tail = current.previous;
			tail.next = null;
			return curr;
		}else {
			throw new NoSuchElementException();
		}
	}

	/*
	 * Returns the number of elements in the list.
	 */
	public int getSize() {
		return size;
	}

	/*
	 * Returns true if the list is empty, and false otherwise.
	 */
	public boolean isEmpty() {
		if (size != 0) {
			return false;
		}
		return true;
	}

	// A private Node class. By making it an inner class,
	// the outer class can access it easily, but the client cannot.
	private class Node {
		private int data;
		private Node next;
		private Node previous;

		// Constructs a new node with the specified data
		private Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
