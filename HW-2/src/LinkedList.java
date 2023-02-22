import java.util.NoSuchElementException;

/**
 * Code to create the generic linked list class for HW project 2
 * @author Evan Williams
 * December 2, 2022
 * Code referenced from Lab 2, 
 *Sort method from https://www.geeksforgeeks.org/merge-sort-for-linked-list/ and modifed by @will1310
 */

public class LinkedList<T extends Comparable<T>> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	/**
	 * Creates an empty list.
	 */
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Returns a space-separated string of the elements in the list. If the list
	 * if linked list contains no elements returns ""
	 * @return returnString
	 */
	public String toString() {
		String returnString = "";

		Node<T> current = head;
		while (current != null) {
			returnString = returnString + current.data + " \n\n";
			current = current.next;
		}
		return returnString;
	}

	/**
	 * Returns the first item in the list. If the list is empty, throw a
	 * NoSuchElementException.
	 * @return head.data
	 */
	public T getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		} else {
			return head.data;
		}
	}

	/**
	 * Returns the last item in the list. If the list is empty, throw a
	 * NoSuchElementException.
	 * @return tail.data
	 */
	public T getLast() {
		if (tail == null) {
			throw new NoSuchElementException();
		} else {
			return tail.data;
		}
	}

	/**
	 * Returns the item at the specified index. If the index is not valid, throw an
	 * IndexOutOfBoundsException.
	 * @param index an int
	 * @return current.data
	 */
	public T getAt(int index) {
		if (size < index) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.data;
		}
	}

	/**
	 * Inserts an item at the beginning of the list.
	 * @param num
	 */
	public void insertFirst(T num) {
		Node<T> newNode = new Node<T>(num);
		newNode.next = null;
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
		size++;
	}

	/**
	 * Inserts an item at the end of the list.
	 * @param num
	 */
	public void insertLast(T num) {
		Node<T> newNode = new Node<T>(num);
		newNode.next = null;
		if (this.tail == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	/**
	 * Removes and returns the first element from the list. 
	 * If the list is empty, throw a NoSuchElementException.
	 * @return temp
	 */
	public T removeFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		} else if (!(head == tail)) {
			T temp = head.data;
			head = head.next;
			size--;
			return temp;
		} else {
			T temp = head.data;
			head = head.next;
			tail = head.next;
			size--;
			return temp;
		}
	}

	/**
	 * Removes and returns the last element from the list. 
	 * If the list is empty, throw a NoSuchElementException.
	 * @return temp
	 */
	public T removeLast() {
		if (tail == null) {
			throw new NoSuchElementException();
		} else if (!(head == tail)) {
			T temp = tail.data;
			tail = tail.previous;
			tail.next = null;
			size--;
			return temp;
		} else {
			T temp = head.data;
			head = null;
			tail = null;
			size--;
			return temp;
		}
	}

	/**
	 * Returns the number of elements in the list.
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * This method detects if the list is empty or not
	 * @return true if empty, and false otherwise.
	 */
	public boolean isEmpty() {
		if (size != 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Sorts the list
	 */
	public void sort() {
		head = mergeSort(head);
		Node<T> current = head;
		while (current.next != null) {
			current = current.next;
		}
		tail = current;
	}

	/**
	 * Helper method for sort. Splits the list into 2
	 * @param head
	 * @return temp
	 */
	private Node<T> split(Node<T> head) {
		Node<T> fast = head;
		Node<T> slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node<T> temp = slow.next;
		slow.next = null;
		return temp;
	}

	/**
	 * Start merge sort
	 * @param node
	 * @returns a call to the method merge with parameters of node and nextNode
	 */
	private Node<T> mergeSort(Node<T> node) {
		if (node == null || node.next == null) {
			return node; 
		}
		Node<T> nextNode = split(node);
		node = mergeSort(node); 
		nextNode = mergeSort(nextNode); 
		return merge(node, nextNode);
	}

	/**
	 * Helper method to merge the to combine two sorted lists 
	 * @param first
	 * @param second
	 * @return
	 */
	private Node<T> merge(Node<T> first, Node<T> second) {
		// return if either list is empty and stop recursion
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		if (first.data.compareTo(second.data) < 0) {
			first.next = merge(first.next, second);
			first.next.previous = first;
			first.previous = null;
			return first;
		} else {
			second.next = merge(first, second.next);
			second.next.previous = second;
			second.previous = null;
			return second;
		}
	}


	/**
	 *A private node class for outer class to access
	 *@author Evan Williams
	 *December 2, 2022
	 *@param <T>
	 */
	private class Node<T extends Comparable<T>> {
		private T data;
		private Node<T> next;
		private Node<T> previous;

		/**
		 * Constructs a new Node with the specified data
		 * @param data
		 */
		private Node(T data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}
}
