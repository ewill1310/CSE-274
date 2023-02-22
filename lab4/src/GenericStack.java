import java.util.NoSuchElementException;



/**
 * Complete the empty methods so that this class works with the StackDriver.java
 * class given. You may implement using either a LinkedList or an array. You MAY
 * NOT use the Java library Stack, LinkedList, or ArrayList classes.
 * 
 * @author john1819 Edited by will1310
 */
public class GenericStack<T> implements StackInterface<T> {

	private Node head;
	private int size;

	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry);
		if (head == null) {
			head = newNode;
			size++;
		} else {
			newNode.next = head;
			head = newNode;
			size++;
		}
	}

	@Override
	public T pop() {
		Node current = this.head;
		if (current != null) {
			T curr = current.data;
			head = current.next;
			size--;
			return curr;
		}else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public T peek() {
		int index = size;
		Node current = this.head;
		if (index >= 0 && index <= size) {
			while (current.next != null) {
				current = current.next;
			}
			for (int i = 0; i < index; i++) {
				current = this.head;
			}
			return current.data;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean isEmpty() {
		if (size != 0) {
			return false;
		}
		return true;
	}

	@Override
	public void clear() {
		while(size != 0) {
			pop();
		}
	}

	private class Node {
		private T data;
		private Node next;

		// Constructs a new node with the specified data
		private Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

}
