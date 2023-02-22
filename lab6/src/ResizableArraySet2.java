import java.util.Arrays;
/**
 * A resizable array implementation of a set.  The underlying array
 * doubles in length whenever an add is performed and the array is full.
 * February 18, 2020
 * @author Norm Krumpe Edited By: Evan Williams on 10/5/22
 * @version 1.0
 *
 */

public class ResizableArraySet implements Set {
	private int size;
	private String[] set;
	private int frontIndex;

	/**
	 * Constructs a set with the underlying array having the specified
	 * initial capacity. Note that a large capacity means the array
	 * won't need to be resized as frequently, but it also means the
	 * array will take up more memory.
	 * @param capacity the initial capacity of the array
	 * @throws IllegalArgumentException if the capacity is less than 2
	 */
	public ResizableArraySet(int capacity) {
		// TODO: throw an exception if the initial capacity is less than 2
		size = 0;
		set = new String[capacity];
	}

	/**
	 * Constructs a set with the underlying array having an initial capacity of 10.
	 */
	public ResizableArraySet() {
		this(10);
	}

	//  It's important to include helpful comments in header comments if they
	// are specific to the implementation:
	
	// If an item is to be added, and the array is full, create a new array,
	// doubling its current size, and then add.
	@Override
	public boolean add(String s) {
		boolean success = false;

		// Use the find() helper method here.
		// TODO: Write this together

		return success;

	}


	/*
	 * add() and remove() and contains() all require a search
	 * to see if an item is in the set already.  So, it would make
	 * sense to put that logic in just one place
	 */
	private int find(String s) {
		int location = -1;

		// TODO: 

		return location;
	}

	@Override
	public boolean remove(String s) {
		boolean success = false;

		// TODO: Write this on your own.  Use the find() method
		// to help you, because if it is found, then find will tell you which index in the
		// array.  This index is useful to the remove() method.

		return success;
	}
	
	@Override
	public boolean addAll(String[] strings) {
		boolean success = false;
		
		// TODO: Write this on your own
		
		return success;
	}

	@Override
	public boolean contains(String s) {
		// TODO:   It's one line, and uses the find() method.
		return false;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		// TODO: Write this on your own
		// each reference in the array should be set to null
	}

	@Override
	public String[] toArray() {
		String[] newArray = new String[size];
		newArray = Arrays.copyOf(set, size);
		return newArray;
	}
	
		/**
		 * Increases size of the Array whenever it is full, doubling the length of the set
		 * Code Provided by: Cynthia Johnson
		 */
		private void ensureCapacity() {
			if (size == set.length) {
				String[] oldQueue = set;
				@SuppressWarnings("unchecked")
				String[] tempQueue = (String[]) new Object[2 * size];
				set = tempQueue;
				for (int i = 0; i < size; i++) {
					tempQueue[i] = oldQueue[(frontIndex + i) % oldQueue.length];
				}
				frontIndex = 0;
			}
		}

}
