/**
 * Implements a set of strings using linked nodes. February 18, 2020 - Edited
 * and due on: 10/7/22
 * 
 * @author Norm Krumpe edited by: Evan Williams - will1310
 * @version 1.0
 * 
 *
 */
public class LinkedSet implements Set {
	private Node head;
	private int size;

	public LinkedSet() {
		head = null;
		size = 0;
	}

	@Override
	public boolean add(String s) {
		boolean success = false;
		Node current = new Node(s);
		if (head == null) {
			head = new Node(s);
			size++;
			success = true;
		} else {
			if (find(s) == null) {
				while (head.next != null) {
					head = head.next;
				}
				head.next = current;
				size++;
				success = true;
			} else {
				success = false;
			}
		}
		return success;
	}

	@Override
	public boolean addAll(String[] strings) {
		boolean success = false;
		for (int i = 0; i < strings.length; i++) {
			add(strings[i]);
		}
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
			System.out.println(find(strings[i]));
			if (contains(strings[i])) {
				success = true;
			} else {
				success = false;
				break;
			}
		}
		return success;
	}

	@Override
	public boolean remove(String s) {
		boolean success = false;
		Node currentNode = find(s);
		currentNode = currentNode.next;
		size--;
		return success;
	}

	@Override
	public boolean contains(String s) {
		Node currentNode = find(s);
		if (currentNode != null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void clear() {
// No loop is needed here, because garbage collection will
// take care of everything as soon as the head is set to null.
		head = null;
		size = 0;
	}

	/*
	 * add() and remove() and contains() all require a search to see if an item is
	 * in the set already. So, it would make sense to put that logic in just one
	 * place. If the specified string is found, this method returns a reference to
	 * the NODE that contains that string. That node reference is useful for the
	 * remove() method. The method should return null if it's not found.
	 */
	private Node find(String s) {
		Node result = null;
		Node current = head;
		if (current == null) {
			result = null;
		} else {
			if (current.data.equals(s)) {
				result = current;
			} else {
				while (current.next != null) {
					if (current.data.equals(s)) {
						result = current;
					}
					current = current.next;
				}
			}
		}
		return result;
	}

	@Override
	public String[] toArray() {
		String[] newArray = new String[size];
		Node current = head;
		int index = 0;
		while (current != null && index < size) {
			newArray[index] = current.data;
			index++;
// add this line
			current = current.next;
		}
		return newArray;
	}

	private class Node {
		private String data;
		private Node next;

		private Node(String data) {
			this.data = data;
			this.next = null;
		}
	}
}