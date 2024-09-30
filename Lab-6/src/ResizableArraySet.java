import java.util.Arrays;
/**
 * A resizable array implementation of a set.  The underlying array
 * doubles in length whenever an add is performed and the array is full.
 * February 18, 2020 - Edited and due on: 10/7/22
 * @author Norm Krumpe edited by: Evan Williams - will1310
 * @version 1.0
 *
 */

public class ResizableArraySet implements Set {
	private int size;
	private String[] set;

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
		ensureCapacity();  // make sure array is big enough for one more
		if(find(s) == -1) {
			set[size] = s;
			size++;
			success = true;
		}else {
			return false;
		}
		return success;

	}

	/*
	 * add() and remove() and contains() all require a search
	 * to see if an item is in the set already.  So, it would make
	 * sense to put that logic in just one place
	 */
	private int find(String s) {
		int location = -1;
		for(int i = 0; i<this.size; i++) {
			if(set[i].equals(s)) {
				location = i;
			}
		}
		return location;
	}

	@Override
	public boolean remove(String s) {
		boolean success = false;
		if(find(s) != -1) {
			int index = find(s);
			for(int i = index; i<size-1; i++) {
				set[i] = set[i+1];
			}
			set[size] = null;
			size--;
			success = true;
		}else {
			success = false;
		}

		return success;
	}
	
	@Override
	public boolean addAll(String[] strings) {
		boolean success = false;
		for(int i = 0; i<strings.length; i++) {
			add(strings[i]);
		}
		for(int i = 0; i<strings.length; i++) {
			if(contains(strings[i])) {
				success = true;
			}else {
				success = false;
				break;
			}
		}
		return success;
	}

	@Override
	public boolean contains(String s) {
		if(find(s) != -1) return true;
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
		for(int i = 0; i<size-1; i++) {
			set[i] = null;
		}
		size = 0;
	}

	@Override
	public String[] toArray() {
		String[] newArray = new String[size];
		newArray = Arrays.copyOf(set, size);
		return newArray;
	}
	
	private void ensureCapacity() {
		int frontIndex = 0;
		if (size == set.length) {
			String[] oldQueue = set;
			@SuppressWarnings("unchecked")
			String[] tempQueue = (String[]) new String[2 * size];
			set = tempQueue;
			for (int i = 0; i < size; i++) {
				tempQueue[i] = oldQueue[(frontIndex + i) % oldQueue.length];
			}
			frontIndex = 0;
		}
	}

}
