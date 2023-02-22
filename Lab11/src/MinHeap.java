//Copyright 2022, Evan Williams
//Code originally authored by john1819
//Code edited by Evan Williams, will1310
//Purpose: CSE 274 Lab 11
//Date: 11/17/2022

/**
 * Create the MinHeap class that will store integers and sort them based upon if
 * they are larger or smaller than another number and the can remove and add
 * numbers.
 * 
 * @author john1819, edited by will1310
 *
 */
public class MinHeap {
	private int size;
	int[] theHeap;

	/**
	 * 
	 */
	public MinHeap() {
		size = 0;
		theHeap = new int[20];

	}

	/**
	 * Insert element e into the minheap Return true if the element is inserted
	 * successfully
	 */
	public boolean insert(int e) {
		ensureCapacity();

		// implement your code here- don't forget to order heap after you add e
		if (size >= theHeap.length) {
			return false;
		}
		size++;
		theHeap[size] = e;
		orderHeap();
		return true;
	}

	public int get(int index) {
		return theHeap[index];
	}

	/**
	 * Private method to aid with insertion order heap after insertion parent =
	 * index/2
	 */
	private void orderHeap() {
		// two possible cases
		// if this is size = 1 - this is first and only
		// element no need to do anything
		if (size == 1) {
			return;
		}
		// otherwise start at bottom and check that element at
		// size is greater than parents (code given is
		// incomplete- you must finish it
		int index = size;
		// while element has parents
		while (index > 1) {
			// parent node can be found at index/2
			int parent = index / 2;
			// if element at parent index is less than element at original index - swap them
			// then change index to parent index.
			if (theHeap[index] < theHeap[parent]) {
				swapNodes(index, parent);
			}
			index = parent;

		}

	}

	/**
	 * Gets the minimum element from top of the heap
	 * 
	 * @return- the element removed
	 */
	public int remove() {
		// get the value from the root so that you can return it
		if (size == 0) {
			return -1;
		}
		// hint root = theHeap[1] since we don't use element 0
		int root = theHeap[1];
		// take the value from the last node and copy it to the top
		// hint the last node is theHeap[size] since we don't use element 0
		theHeap[1] = theHeap[size];
		// fix the heap by calling fixHeap
		fixHeap(1);
		// remove the last node (set to 0)
		int removed = size;
		theHeap[removed] = 0;
		size--;
		// return the removed value
		return root;
	}

	/**
	 * This method adjusts the heap after a removal. Makes sure that no child of the
	 * indicated index is less than that element in the heap.
	 * 
	 * @param -index to be checked for heap property
	 */
	private void fixHeap(int start) {
		// start at top = is root node greater than either child
		int curr = start;
		// first see if any children exist
		if (curr * 2 <= size) {
			// check first child
			if (theHeap[curr] > theHeap[curr * 2]) {
				// swap if curr is not smaller
				swapNodes(curr, curr * 2);
				fixHeap(curr * 2);

			}

			// check second child if exists
			if (curr * 2 + 1 <= size) {
				if (theHeap[curr] > theHeap[curr * 2 + 1]) {
					// swap if curr is not smaller
					swapNodes(curr, (curr * 2 + 1));
					fixHeap(curr * 2 + 1);
				}
			}
		}
	}

	/**
	 * Private method to swap members of heap at indexes n1 and n2. Used to adjust
	 * heap after insertion or deletion
	 * 
	 * @param n1
	 * @param n2
	 */
	private void swapNodes(int n1, int n2) {
		int temp = theHeap[n1];
		theHeap[n1] = theHeap[n2];
		theHeap[n2] = temp;

	}

	/**
	 * Gets number of elements in the heap
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns true if heap is empty
	 * 
	 * @return - boolean
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Private method to make sure array size of the heap is big enough. Called from
	 * insert
	 */
	private void ensureCapacity() {
		if (size == (theHeap.length - 1)) {
			int[] oldHeap = theHeap;
			int[] tempHeap = new int[2 * size];
			theHeap = tempHeap;
			for (int i = 0; i < size; i++) {
				theHeap[i] = oldHeap[i];
			}
		}
	}
}
