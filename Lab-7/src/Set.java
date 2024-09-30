/*
 * Basic interface for a set of strings. A set is an unordered collection
 * that does not allow for duplicates.  "Unordered" means that the client using
 * the set should have no expectation or concern about the order of the elements.
 * That's why the interface does not have any methods that are index-based.
 */
public interface Set {

	/**
	 * Adds the specified string to this set.
	 * @param s the string to be added
	 * @return true iff the add was successful
	 */
	public boolean add(String s);
	
	/**
	 * Removes the specified string from this set.
	 * @param s the string to be removed
	 * @return true iff the remove was successful
	 */
	public boolean remove(String s);
	
	/**
	 * Removes all strings from this set.
	 */
	public void clear();
	
	/**
	 * Determines whether the specified string is in this set.
	 * @param s the string whose presence is to be tested
	 * @return true iff the string is in this set
	 */
	public boolean contains(String s);
	
	/**
	 * Returns the string of elements in this set.
	 * @return the string of elements in this set
	 */
	public int size();
	
	/**
	 * Returns true if this set contains no elements, and false otherwise.
	 * @return true iff this set contains no elements
	 */
	public boolean isEmpty();
	
	/**
	 * Adds all elements of an array to this set.
	 * @param the array of strings to be added
	 * @return true if at least one of the strings was added (that is, if the size of the set increased)
	 */
	boolean addAll(String[] strings);
	
	
	/**
	 * Returns an array containing all of the strings in this set.  If the set
	 * contains no elements, an empty array is returned.
	 * @return an array of all the elements in this set
	 */
	public String[] toArray();
	
}
