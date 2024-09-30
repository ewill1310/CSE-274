import java.util.NoSuchElementException;

public class Driver {

	public static void main(String[] args) {

		// As we test our methods, make sure the method works as expected...
		// ...with an empty list
		// ...with a non-empty list
		// **** YOU CAN MAKE ANY CHANGES YOU WANT TO THE CODE IN THIS METHOD ****
		// It is your tester. Test thoroughly.
		// As we test our methods, make sure the method works as expected...
		// ...with an empty list
		// ...with a non-empty list

		// Test empty constructor
		LinkedList list = new LinkedList();
		System.out.println("?" + list.toString());

		// Test insertFirst
		list.insertFirst(17);
		list.insertFirst(20);
		System.out.println("20 17? " + list.toString());

		// Test insertLast
		list.insertLast(50);
		list.insertLast(51);
		System.out.println("20 17 50 51? " + list.toString());

		// Test getFirst getLast and getAt
		System.out.println("20? " + list.getFirst());
		System.out.println("51? " + list.getLast());
		System.out.println("50? " + list.getAt(2));
		System.out.println("17? " + list.getAt(1));
		System.out.println("20? " + list.getAt(0));

		// Test getFirst and getLast exception throwing
		LinkedList thrown = new LinkedList();
		try {
			System.out.println("20? " + thrown.getFirst());
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				System.out.println("NoSuchElementException? NoSuchElementException");
			}
		}
		try {
			System.out.println("51? " + thrown.getLast());
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				System.out.println("NoSuchElementException? NoSuchElementException");
			}
		}

		// Test getAt Exception throwing
		try {
			System.out.println("20? " + list.getAt(-1));
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("IndexOutOfBoundsException? IndexOutOfBoundsException");
			} else {
				e.printStackTrace();
			}
		}
		try {
			System.out.println("20? " + list.getAt(124));
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("IndexOutOfBoundsException? IndexOutOfBoundsException");
			} else {
				e.printStackTrace();
			}
		}

		// Test getSize
		System.out.println("4? " + list.getSize());
		list.insertLast(64);
		System.out.println("5? " + list.getSize());

		// Test isEmpty
		LinkedList empty = new LinkedList();
		System.out.println("Empty = False? " + list.isEmpty());
		System.out.println("Empty = True? " + empty.isEmpty());

		// Test removeFirst and removeLast
		System.out.println("20 17 50 51 64? " + list.toString());
		list.removeFirst();
		System.out.println("17 50 51 64? " + list.toString());
		list.removeLast();
		System.out.println("17 50 51? " + list.toString());

		// Test removeFirst and removeLast exception throwing
		LinkedList remove = new LinkedList();
		try {
			System.out.println("20? " + remove.removeFirst());
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				System.out.println("NoSuchElementException? NoSuchElementException");
			}
		}
		try {
			System.out.println("51? " + remove.removeLast());
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				System.out.println("NoSuchElementException? NoSuchElementException");
			}
		}

	}

}
